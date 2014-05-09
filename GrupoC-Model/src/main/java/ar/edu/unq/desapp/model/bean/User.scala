package ar.edu.unq.desapp.model.bean

import reflect.BeanProperty
import javax.persistence._

@Entity
@Table(name = "USER")
@Inheritance(strategy=InheritanceType.JOINED)
class User (
  var username: String,
  var email: String,
  var password: String) {

  @Id @GeneratedValue
  var id: Long = _

  @OneToMany(mappedBy = "id_book")
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
}
