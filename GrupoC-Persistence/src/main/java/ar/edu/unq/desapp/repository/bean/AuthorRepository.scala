package ar.edu.unq.desapp.repository.bean

import ar.edu.unq.desapp.repository.generic.HibernateGenericDAO
import ar.edu.unq.desapp.model.bean.Author

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class AuthorRepository extends HibernateGenericDAO[Author] {

  private val serialVersionUID: Long = -8543996946304099004L;

  override def getDomainClass: Class[Author] = {
    classOf[Author]
  }
  
  override def findAll: List[Author] = {
    this.getHibernateTemplate().find("from " + this.getDomainClass.getName() + " o")
      .asInstanceOf[java.util.List[Author]].toList
  }
}
