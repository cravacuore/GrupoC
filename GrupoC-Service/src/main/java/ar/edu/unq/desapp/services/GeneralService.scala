package ar.edu.unq.desapp.services

import ar.edu.unq.desapp.services.bean.BookService
import ar.edu.unq.desapp.services.bean.UserService
import ar.edu.unq.desapp.services.bean.AuthorService
import ar.edu.unq.desapp.services.bean.LoanBookService

class GeneralService {
  
  var bookService: BookService = _
  var userService: UserService = _
  var authorService: AuthorService = _
  var loanBookService: LoanBookService = _
}
