package ar.edu.unq.desapp.repository.bean

import ar.edu.unq.desapp.repository.generic.HibernateGenericDAO
import ar.edu.unq.desapp.model.bean.User
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class UserRepository extends HibernateGenericDAO[User] {

  private val erialVersionUID: Long = -85439969463099004L

  override def getDomainClass: Class[User] = {
    classOf[User]
  }
  override def findAll: List[User] = {
    this.getHibernateTemplate().find("from " + this.getDomainClass.getName() + " o")
      .asInstanceOf[java.util.List[User]].toList
  }

}
