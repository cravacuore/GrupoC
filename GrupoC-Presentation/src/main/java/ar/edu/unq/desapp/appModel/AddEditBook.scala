package ar.edu.unq.desapp.appModel

import ar.edu.unq.desapp.model.bean.Book

class AddEditBook extends Serializable {
	val book: Book = new Book(null, null, null, null, null)
	var create: Boolean = true
}