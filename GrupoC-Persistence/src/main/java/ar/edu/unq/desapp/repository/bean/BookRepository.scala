package ar.edu.unq.desapp.repository.bean

import ar.edu.unq.desapp.repository.generic.HibernateGenericDAO
import ar.edu.unq.desapp.model.bean.Book

class BookRepository extends HibernateGenericDAO[Book] {
	
  private val serialVersionUID: Long = 1L
  
  override def getDomainClass: Class[Book] = {
    classOf[Book]
  }
}