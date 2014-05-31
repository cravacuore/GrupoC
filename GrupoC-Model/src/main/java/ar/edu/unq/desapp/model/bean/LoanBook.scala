package ar.edu.unq.desapp.model.bean

import scala.beans.BeanProperty

import org.joda.time.DateTime
import org.joda.time.Days

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity 
@Table(name = "loan_books")
class LoanBook(
  @BeanProperty
  var dateOfLoan: DateTime,
  @BeanProperty
  var refundDate: DateTime) {

  @Id @GeneratedValue
  var id: Int = _

  @OneToOne @BeanProperty
  var book: Book = _
  
  @OneToOne @BeanProperty
  var user: User = _
  
  private def this() = this(null, null)
  
  def isOutOfDate: Boolean = {
    dateOfLoan.isAfter(refundDate)
  }

  def amountDaysBetweenLoanAndRefund: Int = {
    Days.daysBetween(dateOfLoan.withTimeAtStartOfDay(), refundDate.withTimeAtStartOfDay()).getDays()
  }
}
