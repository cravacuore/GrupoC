package ar.edu.unq.desapp.repository.bean

import ar.edu.unq.desapp.repository.generic.HibernateGenericDAO
import ar.edu.unq.desapp.model.bean.Librarian

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class LibrarianRepository extends HibernateGenericDAO[Librarian] {

  private val serialVersionUID: Long = -854399694634099004L;

  override def getDomainClass: Class[Librarian] = {
    classOf[Librarian]
  }
  
  override def findAll: List[Librarian] = {
    this.getHibernateTemplate().find("from " + this.getDomainClass.getName() + " o")
      .asInstanceOf[java.util.List[Librarian]].toList
  }
}
