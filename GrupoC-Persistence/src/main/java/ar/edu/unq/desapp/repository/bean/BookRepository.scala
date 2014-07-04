package ar.edu.unq.desapp.repository.bean

import ar.edu.unq.desapp.repository.generic.HibernateGenericDAO
import ar.edu.unq.desapp.model.bean.Book

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class BookRepository extends HibernateGenericDAO[Book] {

  private val serialVersionUID: Long = 1L

  persistentClass = classOf[Book]
  
  def findTheTwentyMostBorrowedBook: java.util.List[Book] = {
    this.getSession().createCriteria(this.persistentClass).asInstanceOf[java.util.List[Book]]
  }
}
