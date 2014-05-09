package ar.edu.unq.desapp.model.bean

import javax.persistence._

@Entity
@Table(name = "LOAN_CONFIG")
class LoanConfiguration {
  var maxDaysOfLoan: Int = 4
  var amountAllowLoan: Int = 3
}
