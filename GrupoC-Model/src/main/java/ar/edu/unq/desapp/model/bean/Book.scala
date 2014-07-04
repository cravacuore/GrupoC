package ar.edu.unq.desapp.model.bean

import java.util.ArrayList
import javax.persistence.{Column, Entity, GeneratedValue, Id, OneToMany, Table}

import org.joda.time.DateTime

import scala.beans.BeanProperty
import scala.collection.JavaConversions.seqAsJavaList
import scala.collection.JavaConverters.asScalaBufferConverter

@Entity @Table(name = "books")
class Book (
  @BeanProperty
  var title: String,
  @BeanProperty
  var isbn: String,
  @BeanProperty
  var editorial: String,
  @BeanProperty
  var imageUrl: String,
  @BeanProperty
  var description: String,
  @BeanProperty
  var amount: Int = 1,
  @BeanProperty
  var registrationDate: DateTime = new DateTime
){

  private val serialVersionUID: Long = 1L

  @Id @GeneratedValue 
  @Column(name = "id_book")
  var id: Int = _

  @OneToMany @BeanProperty
  var comment: java.util.List[Comment] = new ArrayList[Comment]

  @OneToMany @BeanProperty
  var authors: java.util.List[Author] = new ArrayList[Author]

  private def this() = this(null, null, null, null, null)
  
  def addComment(anUser: User, comment: String) {
    val aComment = new Comment(comment, new DateTime)
    aComment.user = anUser
    this.comment = aComment :: this.comment.asScala.toList
  }
}
