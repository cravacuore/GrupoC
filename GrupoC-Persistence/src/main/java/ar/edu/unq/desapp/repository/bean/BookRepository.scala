package ar.edu.unq.desapp.repository.bean

import ar.edu.unq.desapp.repository.generic.HibernateGenericDAO
import ar.edu.unq.desapp.model.bean.Book

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class BookRepository extends HibernateGenericDAO[Book] {

  private val serialVersionUID: Long = 1L

  override def getDomainClass: Class[Book] = {
    classOf[Book]
  }
  
  override def findAll: List[Book] = {
    this.getHibernateTemplate().find("from " + this.getDomainClass.getName() + " o")
      .asInstanceOf[java.util.List[Book]].toList
  }
}
