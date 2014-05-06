package ar.edu.unq.desapp.model.bean

import org.joda.time.DateTime
import org.joda.time.Days
import reflect.BeanProperty
import javax.persistence._

@Entity
@serializable
@Table(name = "LOAN_BOOK")
class LoanBook(
  @OneToOne(mappedBy = "id_user") var anUser: User,
  @OneToOne(mappedBy = "id_book") var aBook: Book,
  @Column(name = "date_of_loan") var dateOfLoan: DateTime,
  @Column(name = "refund_date") var refundDate: DateTime) {

  @Id @GeneratedValue
  @Column(name = "id_loan_book")
  var id: Long = 0

  def isOutOfDate: Boolean = {
    dateOfLoan.isAfter(refundDate)
  }

  def amountDaysBetweenLoanAndRefund: Int = {
    Days.daysBetween(dateOfLoan.withTimeAtStartOfDay(), refundDate.withTimeAtStartOfDay()).getDays()
  }
}
