package ar.edu.unq.desapp.view.tabs

import ar.edu.unq.desapp.appModel.BookListAppModel
import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.view.model.{BasePage, BookDetailsPage}
import de.agilecoders.wicket.core.markup.html.bootstrap.navigation.BootstrapPagingNavigator
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.markup.html.list.{ListItem, PageableListView}
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.request.mapper.parameter.PageParameters

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
			new PageableListView[Book]("books", form.getModelObject.books, 5) {
			  	override def populateItem(book: ListItem[Book]) =
			    	book.add(
                new Label("title", book.getModelObject.title),
                new Label("isbn", book.getModelObject.isbn),
	              new Label("registrationDate", book.getModelObject.registrationDate.toDate),
                new BookmarkablePageLink("details", classOf[BookDetailsPage], new PageParameters().add("book", book.getModelObject))
//                new Label("reservation", book.getModelObject.reservations),
//                new Label("state")
			      	)
			}
    form.add(new BootstrapPagingNavigator("navigator", books))
		form.add(books)
	}

	//######################### Para el borrado desde la misma lista ########################
	//      override def onSubmit {
	//        ManageBookPanel.this.services.delete(form.getModelObject())
	//      }
	//#######################################################################################
}
