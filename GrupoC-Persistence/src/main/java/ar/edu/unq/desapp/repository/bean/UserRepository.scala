package ar.edu.unq.desapp.repository.bean

import ar.edu.unq.desapp.repository.generic.HibernateGenericDAO
import ar.edu.unq.desapp.model.bean.User
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class UserRepository extends HibernateGenericDAO[User] {

  private val serialVersionUID: Long = -85439969463099004L

  override def getDomainClass: Class[User] = {
    classOf[User]
  }
}
