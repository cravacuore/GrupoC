package ar.edu.unq.desapp.builders

import ar.edu.unq.desapp.LibrarySystem
import ar.edu.unq.desapp.LoanManagement
import ar.edu.unq.desapp.NotificationSystem
import ar.edu.unq.desapp.LoanConfiguration

abstract class BuilderToTest[T] {

  def build: T //generic build
}

//Here define the builders to share with others test
trait Builder {
  val aLoanConfiguration = new LoanConfiguration
  val anUser: UserBuilder = new UserBuilder
  val aLibrarian: LibrarianBuilder = new LibrarianBuilder(new LibrarySystem(aLoanConfiguration))
  val aBook: BookBuilder = new BookBuilder
  val aLoanManagement: LoanManagement = new LoanManagement(new NotificationSystem, aLoanConfiguration)
}
