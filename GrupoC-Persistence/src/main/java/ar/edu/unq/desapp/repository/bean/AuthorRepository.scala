package ar.edu.unq.desapp.repository.bean

import ar.edu.unq.desapp.repository.generic.HibernateGenericDAO
import ar.edu.unq.desapp.model.bean.Author

class AuthorRepository extends HibernateGenericDAO[Author] {

  private val serialVersionUID: Long = -8543996946304099004L;

  override def getDomainClass: Class[Author] = {
    classOf[Author]
  }
}
