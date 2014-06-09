 package ar.edu.unq.desapp.view.model

 import ar.edu.unq.desapp.appModel.AddEditBook
 import org.apache.wicket.markup.html.basic.Label
 import org.apache.wicket.markup.html.form.Form
 import org.apache.wicket.markup.html.panel.FeedbackPanel
 import org.apache.wicket.markup.html.form.TextField
 import org.apache.wicket.markup.html.form.Button
 import org.apache.wicket.model.CompoundPropertyModel
 import ar.edu.unq.desapp.view.tabs.BookListPage

 class AddEditBookPage extends BasePage {
	
 	var mainPage: BookListPage = new BookListPage
 	var addEditBook: AddEditBook = new AddEditBook
	
 	override def onInitialize {
 	  	super.onInitialize
 		val bookForm = new Form[AddEditBook]("bookForm", new CompoundPropertyModel(this.addEditBook))
		
 		add(new Label("title", if (this.addEditBook.create) "New Book" else "Edit Book Data"))
 		addGrilInputs(bookForm)
 		addActions(bookForm)
 		add(bookForm)
 	}
	
 	def addActions(parent: Form[AddEditBook]){
 		parent.add(new Button("accept") {
 			def onClick {
 //				this.addEditBook.book.validate()
 //				this.addEditBook.saveChanges
 //				returnPage()
 			}
 		})
 		parent.add(new Button("cancel") /*{ def onClick { returnPage }*/)
// 		parent.add(new Button("add") /*{ def onClick { returnPage }*/)
 	}
	
 	//TODO Refactor
 //	def returnPage() {
 //		parentPage.searchBooks
 //		responsePage = parentPage
 //	}
	
 	def addGrilInputs(parent: Form[AddEditBook]) {
 		parent.add(new TextField[String]("book.title"))
 		parent.add(new TextField[String]("book.isbn"))
 		parent.add(new TextField[String]("book.editorial"))
 		parent.add(new TextField[String]("book.description")) 
 		parent.add(new FeedbackPanel("feedbackPanel"))
 	}
 }