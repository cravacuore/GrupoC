package ar.edu.unq.desapp.model.bean

import scala.beans.BeanProperty

import org.joda.time.DateTime

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "comments")
class Comment(
  @BeanProperty
  var comment: String,
  @BeanProperty
  var date: DateTime) {
  
  @Id @GeneratedValue
  @Column(name = "id_comment")
  var id: Int = _
  
  @ManyToOne @BeanProperty
  var user: User = _
  
  def this() = this(null, null)
}
