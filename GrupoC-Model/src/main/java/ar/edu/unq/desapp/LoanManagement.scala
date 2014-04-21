package ar.edu.unq.desapp

import org.joda.time.DateTime

class LoanManagement(val notificationSystem: NotificationSystem, private val loanConf: LoanConfiguration) {
  var reservedBooks: Map[User, List[Book]] = Map()
  var borrowedBooks: List[LoanBook] = Nil

  def reserveBook(anUser: User, aBook: Book) {
    val isReserved: Boolean = reservedBooks.values.exists(b => b.contains(aBook))
    val reserveBooksToUser: List[Book] = reservedBooks.get(anUser) match {
      case Some(books) =>
        if (books.length < loanConf.amountAllowLoan && !isReserved) {
          aBook :: books
        } else {
          books
        }
      case None => if (!isReserved) List(aBook) else Nil
    }
    reservedBooks += (anUser -> reserveBooksToUser)
  }

  def recordLoan(anUser: User, aBook: Book) {
    if (aBook.amount - 1 >= 0) { //validate
      aBook.amount -= 1

      val refundDate = new DateTime().plusDays(loanConf.maxDaysOfLoan)
      val loanBook = new LoanBook(anUser, aBook, new DateTime, refundDate)
      borrowedBooks = (loanBook) :: borrowedBooks

      anUser.borrowBook(aBook)
    }
  }

  def deleteLoan(anUser: User, aBook: Book) {
    borrowedBooks = borrowedBooks.filter(b => b.equals(aBook))
    anUser.returnBook(aBook)

    reservedBooks.find(r => r._2.contains(aBook)) match {
      case Some(user) => notificationSystem.notifyUserOfAvailableBook(user._1, aBook)
      case None => Nil
    }
  }

  def signUpNotification(anUser: User, aBook: Book) {
    notificationSystem.addObserver(anUser, aBook)
  }
}
