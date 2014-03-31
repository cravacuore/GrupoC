package ar.edu.unq.desapp
import org.scalatest.mock.MockitoSugar
import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.GivenWhenThen
import ar.edu.unq.desapp._
import java.awt.Image

//import org.junit.runner.RunWith
//import org.scalatest.junit.JUnitRunner
//
//@RunWith(classOf[JUnitRunner])
class SearchBookSystemTest extends FunSpec with ShouldMatchers with GivenWhenThen with MockitoSugar {
	
	def fixture = new {
	  val system = new LibrarySystem()
	  val searcher = new SearchBookSystem()
	  
	  val author1 = new Author("author1")
	  val author2 = new Author("author2")
	  val author3 = new Author("author3")
	  val author4 = new Author("hisName")
	  val author5 = new Author("someName")
	  val authors = author1 :: author2 :: author3
	  val authors2 = author4 :: author5

	  //Book A
	  val isbnA = "ISBN-1234"
	  val titleA = "Title A book"
	  val editorialA = "EditorialSarasa"	
	  val mockImageA = mock()[Image]
	  val descriptionA = "This is a description"
	  val bookA = new Book(titleA, isbnA, editorialA, mockImageA, descriptionA, authors)
	  //Book B
	  val isbnB = "ISBN-5678"
	  val titleB = "Title B book"
	  val editorialB = "EditorialSarasaB"	
	  val mockImageB = mock()[Image]
	  val descriptionB = "Description of B book"
	  val bookB = new Book(titleB, isbnB, editorialB, mockImageB, descriptionB, authors)
	  //Book C
	  val isbnC = "ISBN-9012"
	  val titleC = "Title C book"
	  val editorialC = "EditorialSaraC"	
	  val mockImageC = mock()[Image]
	  val descriptionC = "Description of C book"
	  val bookC = new Book(titleC, isbnC, editorialC, mockImageC, descriptionC, authors)
	}
	
	describe("Search Book System"){
	    it("should give a top 20 book rank"){
	      val librarySystem = fixture.system
	      val searcher = fixture.searcher
	      
	      given("the following books")
	      val bookA = fixture.bookA
	      val bookB = fixture.bookB
	      val bookC = fixture.bookC
	      
	      librarySystem manualBookLoad(bookA)
	      librarySystem manualBookLoad(bookB)
	      librarySystem manualBookLoad(bookC)
	      
	      when("borrow books")
	      //This use users, should be tested here?
	        // user borrowBook(bookA) x3 bookB x2 bookC x1...
	      
	      then("Sarasa") //TODO
	      val result: List[Book] = searcher top20borrowed
	       //TODO result . position
	      result should contain bookA // or ((bookA, 3))
	      result should contain ((bookB, 2)) 
	      result should contain ((bookC, 1))
	    }
	    
	    it("should give a rank with the last books added"){
	      val librarySystem = fixture.system
	      val searcher = fixture.searcher
	      
	      given("the following books")
	      val bookA = fixture.bookA
	      val bookB = fixture.bookB
	      val bookC = fixture.bookC
	      
	      val isbn = fixture.isbnA
	      val title = fixture.titleA
	      
	      when("added to the library system")
	      librarySystem manualBookLoad(bookA)
	      librarySystem manualBookLoad(bookB)
	      librarySystem manualBookLoad(bookC)
	      
	      //TODO: correct if automatic load doesn't returns book
	      val bookD = librarySystem automaticBookLoadByIsbn(isbn)
	      val bookE = librarySystem automaticBookLoadByTitle(title)
	      
	      then("rank of last added books")
	      val rank = searcher lastBooksAdded
	      
	      rank should have size (5)
	      rank should contain (bookA)
	      rank should contain (bookB)
	      rank should contain (bookC)
	      rank should contain (bookD)
	      rank should contain (bookE)
	    }
	    
	    it("should be able to find with no precise data"){
	      val librarySystem = fixture.system
	      val searcher = fixture.searcher
	      
	      given("the following data")
	      val bookA = fixture.bookA
	      val bookB = fixture.bookB
	      val bookC = fixture.bookC
	      
	      //Search request data
	      val someTitle1 = "title"
	      val someTitle2 = "A book"
	      val someAuthor1 = "name"
	      val someAuthor2 = "author"
	      
	      when("searching with no precise data")
	      searcher searchBook(someTitle1)
	      searcher searchBook(someTitle2)
	      searcher searchBook(someAuthor1)
	      searcher searchBook(someAuthor2)
	      
	      then("the books should be found")
	      //Check result
	    }
	}
}