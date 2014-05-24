package ar.edu.unq.desapp.model.bean

import org.joda.time.DateTime
import reflect.BeanProperty
import javax.persistence._

@Entity
@Table(name = "comments")
class Comment(
  var anUser: User,
  var comment: String,
  var date: DateTime) {
  
  @Id @GeneratedValue
  @Column(name = "id_comment")
  var id: Int = _
  
  // Accessor's //
  
  def getId: Int = {
    id
  }
  
  def setId(anID: Int) {
    id = anID
  }
  
  @OneToOne(mappedBy = "id_user")
  def getUser: User = {
    anUser
  }
  
  def setUser(user: User) {
    anUser = user
  }
  
  def getComment: String = {
    comment
  }
  
  def setComment(aComment: String) {
    comment = aComment
  }
  
  def getDate: DateTime = {
    date
  }
  
  def setDate(aDate: DateTime) {
    date = aDate
  }
}
