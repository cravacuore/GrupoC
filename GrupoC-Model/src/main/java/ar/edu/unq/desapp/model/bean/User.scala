package ar.edu.unq.desapp.model.bean

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

import javax.persistence._

@Entity
@Table(name = "users")
@Inheritance(strategy=InheritanceType.JOINED)
class User (
  var username: String,
  var email: String,
  var password: String) {
 
  @Id @GeneratedValue
  var id: Int = _

  var borrowedBooks: List[Book] = Nil

  def borrowBook(aBook: Book) {
    borrowedBooks = aBook :: borrowedBooks
  }

  def returnBook(aBook: Book) {
    borrowedBooks = borrowedBooks filter (book => !book.equals(aBook))
    aBook.amount += 1
  }

  def commentBook(aBook: Book, aComment: String) {
    aBook.addComment(this, aComment)
  }
  
  // Accessor's //
  
  def getId: Int = {
    id
  }
  
  def setId(anId: Int) { 
    id = anId
  }
  
  def getUsername: String = {
    username
  }
  
  def setUsername(anUsername: String) {
    username = anUsername
  }
  
  def getEmail: String = {
    email
  }
  
  def setEmail(anEmail: String) {
    email = anEmail
  }
  
  def getPassword: String = {
    password
  }
  
  def setPassword(aPassword: String) {
    password = aPassword
  }
  
  def getBorrowedBooks: java.util.List[Book] = {
    borrowedBooks.asJava.toList
  }
  
  def setBorrowedBooks(bb: java.util.List[Book]) {
    borrowedBooks = bb.asScala.toList
  }
}
