package ar.edu.unq.desapp.utils.builder

import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.model.bean.User
import ar.edu.unq.desapp.model.management.LibrarySystem
import ar.edu.unq.desapp.model.bean.Librarian

abstract class LibraryUserBuilder[T <: LibraryUserBuilder[T, U], U] extends BuilderToTest[U] {

  var name: String = "no name"
  var password: String = "no password"
  var email: String = "no email"
  var borrowedBooks: List[Book] = List()

  def withName(aName: String): T

  def withPassword(aPassword: String): T

  def withEmail(anEmail: String): T

  def withBorrowedBooks(books: List[Book]): T

}

class UserBuilder extends LibraryUserBuilder[UserBuilder, User] {

  def withName(aName: String): UserBuilder = {
    this.name = aName
    this
  }

  def withPassword(aPassword: String): UserBuilder = {
    this.password = aPassword
    this
  }

  def withEmail(anEmail: String): UserBuilder = {
    this.email = anEmail
    this
  }

  def withBorrowedBooks(books: List[Book]): UserBuilder = {
    this.borrowedBooks = books
    this
  }

  def build: User = {
    val user = new User(this.name, this.email, this.password)
    user.borrowedBooks = this.borrowedBooks
    user
  }
}

class LibrarianBuilder(var librarySystem: LibrarySystem) extends LibraryUserBuilder[LibrarianBuilder, Librarian] {

  var system = librarySystem

  def withName(aName: String): LibrarianBuilder = {
    this.name = aName
    this
  }

  def withPassword(aPassword: String): LibrarianBuilder = {
    this.password = aPassword
    this
  }

  def withEmail(anEmail: String): LibrarianBuilder = {
    this.email = anEmail
    this
  }

  def withBorrowedBooks(books: List[Book]): LibrarianBuilder = {
    this.borrowedBooks = books
    this
  }

  def withLibrarySystem(libSystem: LibrarySystem): LibrarianBuilder = {
    this.librarySystem = libSystem
    this
  }

  def build: Librarian = {
    val librarian = new Librarian(this.name, this.email, this.password, this.librarySystem)
    librarian.borrowedBooks = this.borrowedBooks
    librarian
  }
}
