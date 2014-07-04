package ar.edu.unq.desapp.services

import ar.edu.unq.desapp.services.bean.BookService
import ar.edu.unq.desapp.services.bean.UserService
import ar.edu.unq.desapp.services.bean.AuthorService
import ar.edu.unq.desapp.services.bean.LoanBookService
import org.springframework.beans.factory.annotation.Autowired
import scala.beans.BeanProperty

class GeneralService {
  @BeanProperty
  var userService: UserService = _
  @BeanProperty
  var bookService: BookService = _
  @BeanProperty
  var authorService: AuthorService = _
  @BeanProperty
  var loanBookService: LoanBookService = _
}
