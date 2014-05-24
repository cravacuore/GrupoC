package ar.edu.unq.desapp.model.bean

import org.joda.time.DateTime
import org.joda.time.Days
import reflect.BeanProperty
import javax.persistence._

@Entity
@Table(name = "loan_books")
class LoanBook(
  var anUser: User,
  var aBook: Book,
  var dateOfLoan: DateTime,
  var refundDate: DateTime) {

  @Id @GeneratedValue
  var id: Int = _

  def isOutOfDate: Boolean = {
    dateOfLoan.isAfter(refundDate)
  }

  def amountDaysBetweenLoanAndRefund: Int = {
    Days.daysBetween(dateOfLoan.withTimeAtStartOfDay(), refundDate.withTimeAtStartOfDay()).getDays()
  }
  
  // Accessor's //
  
  def getId: Int = {
    id
  }
  
  def setId(anId: Int) {
    id = anId
  }
  
  @OneToOne(mappedBy = "id_user")
  def getAnUser: User = {
    anUser
  }
  
  def setAnUser(user: User) {
    anUser = user
  }
  
  @OneToOne(mappedBy = "id_book")
  def getABook: Book = {
    aBook
  }
  
  def setABook(book: Book) {
    aBook = book
  }
  
  def getDateOfLoan: DateTime = {
    dateOfLoan
  }
  
  def setDateOfLoan(anDate: DateTime) {
    dateOfLoan = anDate
  }
  
  def getRefundDate: DateTime = {
    refundDate
  }
  
  def setRefundDate(anDate: DateTime) {
    refundDate = anDate
  }
}
