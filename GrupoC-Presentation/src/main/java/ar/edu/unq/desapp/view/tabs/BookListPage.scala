package ar.edu.unq.desapp.view.tabs

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Button
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.list.ListView
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.request.mapper.parameter.PageParameters

import ar.edu.unq.desapp.appModel.BookListAppModel
import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.view.model.BasePage
import ar.edu.unq.desapp.view.model.BookDetailsPage

class BookListPage extends BasePage {

	override def onInitialize {
		super.onInitialize
		val bookListAppModel = new BookListAppModel
		val form = new Form[BookListAppModel]("bookListForm",
		    new CompoundPropertyModel[BookListAppModel](bookListAppModel)
		)
		addBookTable(form)
		add(form)
	}

	// Adds table book items
	private def addBookTable(form: Form[BookListAppModel]) {
		val books =
		  
		  // TODO - PageableListView
			new ListView[Book]("books") {
			  	override def populateItem(item: ListItem[Book]) = 
			    	item.add(
//			      		new Button("title") { def onClick() { detailsPage(item.getModelObject) }}
//              new Label("title")
              new BookmarkablePageLink("title", classOf[BookDetailsPage], new PageParameters().add("book", item.getModelObject))
			      		// new Label("isbn")
	//		      		new Label("registrationDate")
                // new Label("reservation")
                // new Label("state")
			      	)
			}
		form.add(books)
	}
	
	
	//TODO - Refactor
//	private def detailsPage(book: Book){
//	  new BookmarkablePageLink("title", classOf[BookDetailsPage], new PageParameters().add("book", book))
//    this.setResponsePage(new BookDetailsPage(book))
//	}
	
	//######################### Para el borrado desde la misma lista ########################
	//      override def onSubmit {
	//        ManageBookPanel.this.services.delete(form.getModelObject())
	//      }
	//#######################################################################################
}
