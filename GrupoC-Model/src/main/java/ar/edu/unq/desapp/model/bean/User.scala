package ar.edu.unq.desapp.model.bean

class User(val username: String, val email: String, val password: String) {

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
