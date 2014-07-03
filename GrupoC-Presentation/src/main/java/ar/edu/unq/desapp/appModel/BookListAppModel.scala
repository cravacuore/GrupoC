package ar.edu.unq.desapp.appModel

import java.util

import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.utils.builder.Builder

class BookListAppModel extends Serializable with Builder {
	var books: java.util.List[Book] = new util.ArrayList
	books.add(
		aBook.build
	)
  books.add(
    aBook.withTitle("Test2").build
  )
  books.add(
    aBook.withDescription("This is a book").build
  )
  books.add(
    aBook.withEditorial("NanaEditorial").build
  )
  books.add(
    aBook.withIsbn("234567890").build
  )
  books.add(
    aBook.build
  )
  books.add(
    aBook.build
  )
  books.add(
    aBook.build
  )

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
