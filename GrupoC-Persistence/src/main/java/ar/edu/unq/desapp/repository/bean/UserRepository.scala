package ar.edu.unq.desapp.repository.bean

import ar.edu.unq.desapp.repository.generic.HibernateGenericDAO
import ar.edu.unq.desapp.model.bean.User

class UserRepository extends HibernateGenericDAO[User]{

  private val erialVersionUID: Long = -85439969463099004L

  override def getDomainClass: Class[User] = {
    classOf[User]
  }
}
