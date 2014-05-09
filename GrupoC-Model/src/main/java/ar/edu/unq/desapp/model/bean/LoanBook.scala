package ar.edu.unq.desapp.model.bean

import org.joda.time.DateTime
import org.joda.time.Days
import reflect.BeanProperty
import javax.persistence._

@Entity
@Table(name = "LOAN_BOOK")
class LoanBook(
  @OneToOne(mappedBy = "id_user") 
  var anUser: User,
  @OneToOne(mappedBy = "id_book")
  var aBook: Book,
  var dateOfLoan: DateTime,
  var refundDate: DateTime) {

  @Id @GeneratedValue
  var id: Long = _

  def isOutOfDate: Boolean = {
    dateOfLoan.isAfter(refundDate)
  }

  def amountDaysBetweenLoanAndRefund: Int = {
    Days.daysBetween(dateOfLoan.withTimeAtStartOfDay(), refundDate.withTimeAtStartOfDay()).getDays()
  }
}
