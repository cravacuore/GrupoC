package ar.edu.unq.desapp.repository.generic

import org.springframework.orm.hibernate3.support.HibernateDaoSupport
import scala.collection.JavaConverters._
import scala.collection.JavaConversions._
import ar.edu.unq.desapp.model.bean.User

abstract class HibernateGenericDAO[T] extends HibernateDaoSupport with GenericRepository[T] with Serializable {

	private val serialVersionUID: Long = 5058950102420892922L
	implicit protected var persistentClass: Class[T] = this.getDomainClass
	
	protected def getDomainClass: Class[T]
	
	override def save(entity: T) {
	  this.getHibernateTemplate.save(entity)
	  this.getHibernateTemplate.flush()
	}
	
	def findAll: List[T]
	
	override def delete(entity: T) {
	  this.getHibernateTemplate().delete(entity)
	}
	
	override def deleteById(id: Serializable) {
		val obj: T = this.findById(id);
		this.getHibernateTemplate().delete(obj);
	}
	
	override def update(entity: T) {
	  this.getHibernateTemplate().update(entity)
	}
	
	override def findById(id: Serializable): T = {
	  this.getHibernateTemplate().get(this.persistentClass, id)
	}
}
