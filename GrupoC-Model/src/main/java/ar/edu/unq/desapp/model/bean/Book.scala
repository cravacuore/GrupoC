package ar.edu.unq.desapp.model.bean

import java.awt.Image
import org.joda.time.DateTime
import reflect.BeanProperty
import javax.persistence.{Entity, Id, GeneratedValue, Table}

@Entity
@Table(name = "BOOK")
class Book(
  var title: String,
  var isbn: String,
  var editorial: String,
  var imageUrl: String,
  var description: String,
  var authors: List[Author],
  var amount: Int = 1 ,
  var registrationDate: DateTime = new DateTime
){

  private val serialVersionUID: Long = 1L

  @Id @GeneratedValue
  var id: Long = _

  var comment: List[Comment] = Nil

  def addComment(anUser: User, comment: String) {
    val aComment = new Comment(anUser, comment, new DateTime)
    this.comment = aComment :: this.comment
  }
}
