package ar.edu.unq.desapp.view.model

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Button
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.image.Image
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.model.CompoundPropertyModel

import ar.edu.unq.desapp.appModel.BookDetails
import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.view.tabs.BookListPage
import org.apache.wicket.request.mapper.parameter.PageParameters

class BookDetailsPage(params: PageParameters) extends HeadBlankPage {

	var book: Book = new Book("no title","no isbn","no editorial","this must be an Image-URL","no description") // TODO - get book as parameter
 	var mainPage: BookListPage = new BookListPage

 	override def onInitialize() {
 	  super.onInitialize()
 	  	
    val bookDetails: BookDetails = new BookDetails(book)
    val bookForm = new Form[BookDetails]("bookForm", new CompoundPropertyModel(bookDetails))
		
 	  addImage(bookForm)
 		addLabels(bookForm)
 		addActions(bookForm)
 		add(bookForm)
 	}
	
 	private def addImage(parent: Form[BookDetails]) {
 		parent.add(new Image("cover", "../library.png"))
 	}

 	private def addLabels(parent: Form[BookDetails]) {
 		parent.add(new Label("book.title"))
 		parent.add(new Label("book.isbn"))
 		parent.add(new Label("book.editorial"))
 		parent.add(new Label("book.description"))
// 		parent.add(new FeedbackPanel("feedbackPanel"))
 	}

 	private def addActions(parent: Form[BookDetails]){
 		parent.add(new Button("addComment") { def onClick() { commentPage() }})
// 		parent.add(new Button("back") {	def onClick() { backPage() }})
    parent.add(new BookmarkablePageLink("back", classOf[BookListPage]))
 	}

 	private def commentPage() {
// 		this.setResponsePage(new CommentPage(book))
 	}

 	private def backPage() {
		this.setResponsePage(mainPage)
 	}
}
