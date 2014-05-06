package ar.edu.unq.desapp.model.bean

import java.awt.Image
import org.joda.time.DateTime
import javax.persistence.{GeneratedValue, Id, Entity}
import reflect.BeanProperty
import javax.persistence._

@Entity
@Table(name = "BOOK")
class Book(
  @Column(name = "title")
  var title: String,
  @Column(name = "isbn")
  var isbn: String,
  @Column(name = "editorial")
  var editorial: String,
  @Column(name = "image")
  var image: Image,
  @Column(name = "description")
  var description: String,
  @OneToMany(mappedBy="id_author")
  var authors: List[Author],
  @Column(name = "amount")
  var amount: Int = 1 ,
  @Column(name = "registration_date")
  var registrationDate: DateTime = new DateTime
){
  @Id @GeneratedValue
  @Column(name = "id_book")
  var id: Long = 0
  
  @Column(name = "comment")
  var comment: List[Comment] = Nil 
  
  def addComment(anUser: User, comment: String) = {
    val aComment = new Comment(anUser, comment, new DateTime)
    this.comment = aComment :: this.comment
  }
}
