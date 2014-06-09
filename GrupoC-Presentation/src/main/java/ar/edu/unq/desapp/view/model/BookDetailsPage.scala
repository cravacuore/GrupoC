package ar.edu.unq.desapp.view.model

import org.apache.wicket.markup.html.basic.Label
import ar.edu.unq.desapp.model.bean.Book
import org.apache.wicket.markup.html.form.Form
import ar.edu.unq.desapp.appModel.AddEditBook
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.form.Button
import org.apache.wicket.markup.html.image.Image
import ar.edu.unq.desapp.appModel.BookDetails
import org.apache.wicket.model.CompoundPropertyModel
import ar.edu.unq.desapp.view.tabs.BookListPage

class BookDetailsPage extends HeadBlankPage {

	var book: Book = new Book("no title","no isbn","no editorial","this must be an Image-URL","no description",Nil) 
   	var mainPage: BookListPage = new BookListPage
 	var bookDetails: BookDetails = new BookDetails(book)
   	
 	override def onInitialize {
 	  	super.onInitialize
 	  	
 	  	//TODO - Refactor
 	  	if (this.book == null) this.book = new Book("no title","no isbn","no editorial","this must be an Image-URL","no description",Nil)
 		val bookForm = new Form[BookDetails]("bookForm", new CompoundPropertyModel(this.bookDetails))
		
 	  	addImage(bookForm)
 		addLabels(bookForm)
 		addActions(bookForm)
 		add(bookForm)
 	}
	
 	def addActions(parent: Form[BookDetails]){
 		parent.add(new Button("addComment") { def onClick { commentPage() }})
 		parent.add(new Button("back") {	def onClick { backPage() }})
 	}
	
 	def commentPage() {
// 		this.setResponsePage(new CommentPage(book))
 	}
 	
 	def backPage() {
 		this.setResponsePage(mainPage)
 	}
	
 	def addLabels(parent: Form[BookDetails]) {
 		parent.add(new Label("book.title"))
 		parent.add(new Label("book.isbn"))
 		parent.add(new Label("book.editorial"))
 		parent.add(new Label("book.description")) 
// 		parent.add(new FeedbackPanel("feedbackPanel"))
 	}
 	
 	def addImage(parent: Form[BookDetails]) {
 		parent.add(new Image("cover", "url"))
 	}
}