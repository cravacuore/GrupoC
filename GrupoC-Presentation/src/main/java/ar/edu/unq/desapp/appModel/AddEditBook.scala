package ar.edu.unq.desapp.appModel

import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.services.bean.BookService
import scala.beans.BeanProperty
import org.apache.wicket.spring.injection.annot.SpringBean

class AddEditBook extends Serializable {
  
  @BeanProperty @SpringBean(name = "services.book")
  var bookService: BookService = _

  val book: Book = new Book(null, null, null, null, null)
  var create: Boolean = true
}
