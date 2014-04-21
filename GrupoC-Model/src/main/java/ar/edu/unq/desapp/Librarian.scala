package ar.edu.unq.desapp

import java.awt.Image

class Librarian(username: String, email: String, password: String, val librarySystem: LibrarySystem)
  extends User(username, email, password) {

  def addBookToSystem(book: Book, cant: Int = 1) {
    librarySystem manualBookLoad (book, cant)
  }

  def modifyBookFromTheSystem(oldBook: Book, newBook: Book) {
    //TODO: Implement
  }

  def deleteBookFromTheSystem(aBook: Book) {
    librarySystem removeBook (aBook.isbn)
  }

  def configureMaxReservesAmount(amount: Int) {
    librarySystem.configLoan.amountAllowLoan = amount
  }

  def configureMaxDaysOfLoan(maxDate: Int) {
    librarySystem.configLoan.maxDaysOfLoan = maxDate
  }

  def registerUser(username: String, email: String, password: String, typeUser: String) {
    //TODO validate if exist an user with same email
    typeUser match {
      case "User" => librarySystem.users = new User(username, email, password) :: librarySystem.users
      case "Librarian" => librarySystem.users = new Librarian(username, email, password, librarySystem) :: librarySystem.users
    }
  }
}
