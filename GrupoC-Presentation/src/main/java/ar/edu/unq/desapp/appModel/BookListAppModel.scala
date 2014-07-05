package ar.edu.unq.desapp.appModel

import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.services.bean.BookService
import ar.edu.unq.desapp.utils.builder.Builder

import scala.collection.JavaConversions._

class BookListAppModel(var bookService: BookService) extends Serializable with Builder {
  
  var books: java.util.List[Book] = bookService.retriveAll//new util.ArrayList

  def isAvailable(aBook: Book): String = {
    if(aBook.amount > 3) "Available" else "Not available" // TODO - aBook.reservations -> get this through Service?
  }

  def getReservationsAmount(aBook: Book): Int = {
    1 // Service.getAmount(aBook) // TODO - Use service to get needed info
//    bookService.findById(aBook).getReservationsAmount()
  }

  def deleteBook(aBook: Book) {
    bookService.delete(aBook)
  }
}
