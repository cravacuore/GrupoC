package ar.edu.unq.desapp.services.bean

import ar.edu.unq.desapp.services.GenericService
import ar.edu.unq.desapp.model.bean.Book
import javax.annotation.Resource
import ar.edu.unq.desapp.repository.bean.BookRepository

class BookService extends GenericService[Book] {

  private val serialVersionUID: Long = 1L
  
  @Resource
  private var bookDAO: BookRepository = _
  
  def retriveAllMostBorrowed: java.util.List[Book] = {
	bookDAO.findTheTwentyMostBorrowedBook
  }
}
