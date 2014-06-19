package ar.edu.unq.desapp.appModel

import ar.edu.unq.desapp.model.bean.Book
import java.util.ArrayList
import ar.edu.unq.desapp.utils.builder.Builder

class BookListAppModel extends Serializable with Builder {
	var books: java.util.List[Book] = new ArrayList
	books.add(
		aBook.build
	)
}
