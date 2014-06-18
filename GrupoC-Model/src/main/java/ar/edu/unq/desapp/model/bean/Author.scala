package ar.edu.unq.desapp.model.bean

import java.util.ArrayList

import scala.beans.BeanProperty

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "authors")
class Author(@BeanProperty var name: String) {

  @Id @GeneratedValue
  var id: Int = _
  
  @OneToMany @BeanProperty
  var writtenBooks: java.util.List[Book] = new ArrayList[Book]
  
  private def this() = this(null)
}
