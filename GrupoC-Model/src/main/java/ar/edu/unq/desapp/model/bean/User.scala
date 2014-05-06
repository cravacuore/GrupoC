package ar.edu.unq.desapp.model.bean

import javax.persistence._
import reflect.BeanProperty

@Entity
@Table(name = "USER")
@Inheritance(strategy=InheritanceType.JOINED)
class User(
  @Column(name = "name") var username: String,
  @Column(name = "email") var email: String,
  @Column(name = "password") var password: String) {

  @Id @GeneratedValue
  @Column(name = "id_user")
  var id: Long = 0

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
