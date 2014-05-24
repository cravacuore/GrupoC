package ar.edu.unq.desapp.model.bean

import java.awt.Image
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import org.joda.time.DateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.Table
import javax.persistence.ManyToMany

@Entity
@Table(name = "books")
class Book (
  var title: String,
  var isbn: String,
  var editorial: String,
  var image: Image,
  var description: String,
  var authors: List[Author],
  var amount: Int = 1 ,
  var registrationDate: DateTime = new DateTime
){

  private val serialVersionUID: Long = 1L

  @Id @GeneratedValue
  var id: Int = _

  var comment: List[Comment] = Nil

  def addComment(anUser: User, comment: String) {
    val aComment = new Comment(anUser, comment, new DateTime)
    this.comment = aComment :: this.comment
  }

  // Accessor's //
  
  def getId: Int = {
    id
  }
  
  def setId(id: Int) {
    this.id = id
  }
  
  def getTitle: String = {
    title
  }
  
  def setTitle(aTitle: String) {
    title = aTitle
  }
  
  def getIsbn: String = {
    isbn
  }
  
  def setIsbn(anIsbn: String) {
    isbn = anIsbn
  }
  
  def getEditorial: String = {
    editorial
  }
  
  def setEditorial(anEditorial: String) {
    editorial = anEditorial
  }
  
  def getImage: Image = {
    image
  }
  
  def setImage(anImage: Image) {
    image = anImage
  }
  
  def getDescription: String = {
    description
  }
  
  def setDescription(aDescription: String) {
    description = aDescription
  }
  
  @ManyToMany
  def getAuthors: java.util.List[Author] = {
    authors.asJava.toList
  }
  
  def setAuthors(anAuthors: java.util.List[Author]) {
    authors = anAuthors.asScala.toList
  }
  
  def getAmount: Int = {
    amount
  }
  
  def setAmount(anAmount: Int) {
    amount = anAmount
  }
  
  def getRegistrationDate: DateTime = {
    registrationDate
  }
  
  def setRegistrationDate(date: DateTime) {
    registrationDate = date
  }
  
  def getComment: java.util.List[Comment] = {
    comment.asJava.toList
  }
  
  def setComment(comments: java.util.List[Comment]) {
    comment = comments.asScala.toList
  }
}
