package ar.edu.unq.desapp

class User(val username: String, var email: String, var password: String) {
	val loanManagement: LoanManagement //when should this be assigned???
	
	def borrowBook(aBook: Book){
	  
	}
	
	def returnBook(aBook: Book){
	  
	}
	
	def commentBook(aBook: Book){
	  
	}
}