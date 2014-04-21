package ar.edu.unq.desapp

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
    aBook.comment = (this.username, aComment) :: aBook.comment
  }
}
