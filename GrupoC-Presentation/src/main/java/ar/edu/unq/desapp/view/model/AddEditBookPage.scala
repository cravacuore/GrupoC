 package ar.edu.unq.desapp.view.model
 
 import org.apache.wicket.markup.html.basic.Label
 import org.apache.wicket.markup.html.form.{TextArea, Button, Form, TextField}
 import org.apache.wicket.markup.html.panel.FeedbackPanel
 import org.apache.wicket.model.CompoundPropertyModel
 import ar.edu.unq.desapp.appModel.AddEditBook
 import ar.edu.unq.desapp.view.tabs.BookListPage
 import scala.beans.BeanProperty
 import org.apache.wicket.spring.injection.annot.SpringBean
 import ar.edu.unq.desapp.services.bean.BookService

 class AddEditBookPage extends BasePage {
	
    @BeanProperty @SpringBean(name = "services.book")
    var bookService: BookService = _
    
 	var mainPage: BookListPage = new BookListPage
 	var addEditBook: AddEditBook = new AddEditBook(bookService)
	
 	override def onInitialize {
 	  	super.onInitialize
 		val bookForm = new Form[AddEditBook]("bookForm", new CompoundPropertyModel(this.addEditBook))
		
 		add(new Label("title", if (this.addEditBook.create) "New Book" else "Edit Book Data"))
 		addGrilInputs(bookForm)
 		addActions(bookForm)
 		add(bookForm)
 	}
	
 	private def addActions(parent: Form[AddEditBook]){
 		parent.add(new Button("accept") {
 			val serialVersionUID: Long = 1341242141L
 			override def onSubmit() {
 			  AddEditBookPage.this.addEditBook.saveChanges
 			}
 		})
 		parent.add(new Button("cancel") { 
 			val serialVersionUID: Long = 13414242141L
 			override def onSubmit() {
 			  AddEditBookPage.this.returnPage
 			}
 		})
 	}
	
 	def returnPage() {
 	  //TODO implement return page
 	}
	
 	private def addGrilInputs(parent: Form[AddEditBook]) {
 		parent.add(new TextField[String]("book_title"))
 		parent.add(new TextField[String]("book_isbn"))
 		parent.add(new TextField[String]("book_editorial"))
 		parent.add(new TextField[String]("book_imageUrl"))
 		parent.add(new TextArea[String]("book_description"))
 		parent.add(new TextField[String]("book_authors"))
 		parent.add(new FeedbackPanel("feedbackPanel"))
 	}
 }
