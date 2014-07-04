 package ar.edu.unq.desapp.view.model
 
 import org.apache.wicket.markup.html.basic.Label
 import org.apache.wicket.markup.html.form.{TextArea, Button, Form, TextField}
 import org.apache.wicket.markup.html.panel.FeedbackPanel
 import org.apache.wicket.model.CompoundPropertyModel

 import ar.edu.unq.desapp.appModel.AddEditBook
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
	
 	private def addActions(parent: Form[AddEditBook]){
 		parent.add(new Button("accept") {
 			def onClick() {
 	//################################## Opcion 1
		//      val serialVersionUID: Long = 1341242141L
		//      
		//      override def onSubmit {
		//        ManageBookPanel.this.services.save(form.getModelObject())
		//      } 			  
 	//############################################
 	//################################## Opcion 2
 //				this.addEditBook.book.validate()
 //				this.addEditBook.saveChanges
 //				returnPage()
 	//############################################
 			  
 	//################################## Opcion 3 - Si esta siendo editado en vez de creado
 				//      override def onSubmit {
				//        ManageBookPanel.this.services.update(form.getModelObject())
				//      }
 	//############################################
 			}
 		})
 		parent.add(new Button("cancel") /*{ def onClick { returnPage }*/)
// 		parent.add(new Button("add") /*{ def onClick { returnPage }*/)
 	}
	
 //	def returnPage() {
 //		parentPage.searchBooks
 //		responsePage = parentPage
 //	}
	
 	private def addGrilInputs(parent: Form[AddEditBook]) {
 		parent.add(new TextField[String]("book.title"))
 		parent.add(new TextField[String]("book.isbn"))
 		parent.add(new TextField[String]("book.editorial"))
 		parent.add(new TextField[String]("book.imageUrl"))
 		parent.add(new TextArea[String]("book.description"))
 		parent.add(new TextField[String]("book.authors"))
 		parent.add(new FeedbackPanel("feedbackPanel"))
 	}
 }
