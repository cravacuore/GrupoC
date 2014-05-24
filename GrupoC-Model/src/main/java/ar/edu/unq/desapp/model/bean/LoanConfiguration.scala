package ar.edu.unq.desapp.model.bean

import javax.persistence._

@Entity
@Table(name = "loan_config")
class LoanConfiguration {
  
  @Id @GeneratedValue
  var id: Int = _
  
  var maxDaysOfLoan: Int = 4
  var amountAllowLoan: Int = 3
  
  // Accessor's //
  
  def getId: Int = {
    id
  }
  
  def setId(anId: Int) {
    id = anId
  }
  
  def getMaxDaysOfLoan: Int = {
    maxDaysOfLoan
  }
  
  def setMaxDaysOfLoan(md: Int) {
    maxDaysOfLoan = md
  }
  
  def getAmountAllowLoan: Int = {
    amountAllowLoan
  }
  
  def setAmountAllowLoan(amount: Int) {
    amountAllowLoan = amount
  }
}
