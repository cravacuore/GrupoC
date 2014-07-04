package ar.edu.unq.desapp.appModel

import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.services.bean.BookService
import scala.beans.BeanProperty
import org.apache.wicket.spring.injection.annot.SpringBean
import ar.edu.unq.desapp.utils.builder.Builder
import ar.edu.unq.desapp.model.bean.Author
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class AddEditBook(var bookService: BookService) extends Serializable with Builder{
  
  val book: Book = new Book(null, null, null, null, null)
  var create: Boolean = true
  
  var book_title: String = _
  var book_isbn: String = _
  var book_editorial: String = _
  var book_imageUrl: String = _
  var book_description: String = _
  var book_authors: List[Author] = _
  
  def saveChanges {
    book.title = book_title
    book.isbn = book_isbn
    book.editorial = book_editorial
    book.imageUrl = book_imageUrl
    book.description = book_description
    bookService.save(book)
  }
  
  def editBook(aBook: Book) {
   book_title = aBook.title
   book_isbn = aBook.isbn
   book_editorial = aBook.editorial
   book_imageUrl = aBook.imageUrl
   book_description = aBook.description
   book_authors = aBook.authors.toList
  }
}
