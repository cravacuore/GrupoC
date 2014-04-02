package ar.edu.unq.desapp

class LibrarySystem {
    var books: List[Book] = null
	var users: List[User] = null
	
	def manualBookLoad(aBook: Book){
      books.::(aBook)
	}
	
	def automaticBookLoadByIsbn(isbn: String){
	  
	}
	
	def automaticBookLoadByTitle(title: String){
	  
	}
	
	def editBook(isbn: String){

	}
	
	def removeBook(isbn: String){

	}
	
	def filterByIsbn(): List[Book] = {
		null
	}
}