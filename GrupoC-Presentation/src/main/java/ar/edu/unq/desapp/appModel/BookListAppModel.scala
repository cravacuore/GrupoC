package ar.edu.unq.desapp.appModel

import java.util
import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.utils.builder.Builder
import ar.edu.unq.desapp.services.bean.BookService
import ar.edu.unq.desapp.view.model.BookDetailsPage
import scala.beans.BeanProperty
import org.apache.wicket.spring.injection.annot.SpringBean

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class BookListAppModel(var bookService: BookService) extends Serializable with Builder {
  
  var books: java.util.List[Book] = bookService.retriveAll//new util.ArrayList
  
  var books1: java.util.List[Book] = new util.ArrayList
  books1.add(
		aBook.build
	)
  books1.add(
    aBook.withTitle("Test2").build
  )
  books1.add(
    aBook.withDescription("This is a book").build
  )
  books1.add(
    aBook.withEditorial("NanaEditorial").build
  )
  books1.add(
    aBook.withIsbn("234567890").build
  )
  books1.add(
    aBook.build
  )
  books1.add(
    aBook.build
  )
  books1.add(
    aBook.build
  )

  def getBooks: java.util.List[Book] = {
    bookService
    for (book <- this.books1) {
      bookService.save(book)
    }
    bookService.retriveAll
  }
  
  def isAvailable(aBook: Book): String = {
    if(aBook.amount > 3) "Available" else "Not available" // TODO - aBook.reservations -> get this through Service?
  }

  def getReservationsAmount(aBook: Book): Int = {
    1 // Service.getAmount(aBook) // TODO - Use service to get needed info
  }

  def deleteBook(aBook: Book) {
    // TODO - Service.deleteBook(aBook)
  }
}
