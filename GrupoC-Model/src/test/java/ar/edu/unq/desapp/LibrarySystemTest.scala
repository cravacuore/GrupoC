package ar.edu.unq.desapp
import org.scalatest.mock.MockitoSugar
import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.GivenWhenThen
import ar.edu.unq.desapp._

class LibrarySystemTest extends FunSpec with ShouldMatchers with GivenWhenThen with MockitoSugar {
	
	def fixture = new {
	  val system = new LibrarySystem()
	  
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
	  val mockImageA = mock[Image]
	  val descriptionA = "This is a description"
	  val bookA = new Book(titleA, isbnA, editorialA, mockImageA, descriptionA, authors)
	  //Book B
	  val isbnB = "ISBN-5678"
	  val titleB = "Title B book"
	  val editorialB = "EditorialSarasaB"	
	  val mockImageB = mock[Image]
	  val descriptionB = "Description of B book"
	  val bookB = new Book(titleB, isbnB, editorialB, mockImageB, descriptionB, authors)
	  //Book C
	  val isbnC = "ISBN-9012"
	  val titleC = "Title C book"
	  val editorialC = "EditorialSaraC"	
	  val mockImageC = mock[Image]
	  val descriptionC = "Description of C book"
	  val bookC = new Book(titleC, isbnC, editorialC, mockImageC, descriptionC, authors)
	}
	
	describe("Library System"){
	    it("should load manually the books to the system"){
	      val librarySystem = fixture.system
	      
	      given("the following books")
	      val authorA = fixture.author1
	      val authorB = fixture.author2
	      val authorC = fixture.author3
	      
	      when("loading the books")
	      //Shouldn t this recieve an entire book? Or this creates a book?
	        // librarySystem manualBookLoad(fixture.bookA)
	      librarySystem manualBookLoad(fixture.titleA, fixture.isbnA, fixture.editorialA, fixture.mockImageA, fixture.descriptionA, fixture.authors)
	      librarySystem manualBookLoad(fixture.titleB, fixture.isbnB, fixture.editorialB, fixture.mockImageB, fixture.descriptionB, fixture.authors)
	      librarySystem manualBookLoad(fixture.titleA, fixture.isbnC, fixture.editorialC, fixture.mockImageC, fixture.descriptionC, fixture.authors)
	      
	      then("the books should be loaded")
	      val booksLoaded = librarySystem filterByIsbn
	      
	      booksLoaded should have size (3)
	      booksLoaded should contain (fixture.isbnA)
	      booksLoaded should contain (fixture.isbnB)
	      booksLoaded should contain (fixture.isbnC)
	    }
	    
	    it("should load automatically the books to the system"){
	      val librarySystem = fixture.system
	      
	      given("the following data")
	      val isbn = fixture.isbnA
	      val xtitle = fixture.titleA
	      
	      when("searching the books by isbn and title automatically")
	      librarySystem automaticBookLoadByIsbn(isbn)
	      librarySystem automaticBookLoadByTitle(title)
	      
	      then("the books should be found and loaded")
	      val bookLoadedByIsbn = librarySystem searchByIsbn(isbn)
	      val bookLoadedByTitle = librarySystem searchByTitle(title)
	      
	      bookLoadedByIsbn should have size (1)
	      bookLoadedByIsbn should contain (isbn)
	      
	      bookLoadedByTitle should have size (1)
	      bookLoadedByTitle should contain (title)
	    }
	    
	    it("should give a top 20 book rank"){
	      val librarySystem = fixture.system
	      
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
	      val result = librarySystem top20borrow
	       //TODO result . position
	      result should contain ((bookA, 3))
	      result should contain ((bookB, 2)) 
	      result should contain ((bookC, 1))
	    }
	    
	    it("should give a rank with the last books added"){
	      val librarySystem = fixture.system
	      
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
	      val rank = librarySystem lastBooksAdded
	      
	      rank should have size (5)
	      rank should contain (bookA)
	      rank should contain (bookB)
	      rank should contain (bookC)
	      rank should contain (bookD)
	      rank should contain (bookE)
	    }
	    
	    it("should be able to find with no precise data"){
	      val librarySystem = fixture.system
	      
	      given("the following data")
	      val bookA = fixture.bookA
	      val bookB = fixture.bookB
	      val bookC = fixture.bookC
	      
	      //Search data
	      val someTitle1 = "title"
	      val someTitle2 = "A book"
	      val someAuthor1 = "name"
	      val someAuthor2 = "author"
	      
	      when("searching with no precise data")
	      //TODO
	      //Use search data
	      
	      then("the books should be found")
	      //Check result
	    }
	}
}