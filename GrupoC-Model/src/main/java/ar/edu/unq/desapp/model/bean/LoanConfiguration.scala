package ar.edu.unq.desapp.model.bean

import javax.persistence._

@Table(name = "LOAN_CONFIG")
class LoanConfiguration {
  @Column(name = "max_days_loan")
  var maxDaysOfLoan: Int = 4
  @Column(name = "amount_allow_loan")
  var amountAllowLoan: Int = 3
}
