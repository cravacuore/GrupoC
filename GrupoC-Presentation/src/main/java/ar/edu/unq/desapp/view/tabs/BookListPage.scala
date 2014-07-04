package ar.edu.unq.desapp.view.tabs

import ar.edu.unq.desapp.appModel.BookListAppModel
import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.view.model.{BasePage, BookDetailsPage}
import de.agilecoders.wicket.core.markup.html.bootstrap.navigation.BootstrapPagingNavigator
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.{Button, Form}
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.markup.html.list.{ListItem, PageableListView}
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.request.mapper.parameter.PageParameters
import ar.edu.unq.desapp.services.GeneralService
import scala.beans.BeanProperty
import org.apache.wicket.spring.injection.annot.SpringBean

class BookListPage extends BasePage {
  
  @BeanProperty @SpringBean(name = "services.general")
  var generalService: GeneralService = _
  
	override def onInitialize {
		super.onInitialize
		val bookListAppModel = new BookListAppModel(this.generalService.bookService)
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
            //Data - items for each book on the list
                new Label("title", book.getModelObject.title),
                new Label("isbn", book.getModelObject.isbn),
                new Label("registrationDate", book.getModelObject.registrationDate.toDate),
                new Label("reservation", form.getModelObject.getReservationsAmount(book.getModelObject)),
                new Label("state", form.getModelObject.isAvailable(book.getModelObject)),
            //Actions
                new BookmarkablePageLink("details", classOf[BookDetailsPage], new PageParameters().add("book", book.getModelObject)),
                new Button("delete") { def onClick() { form.getModelObject.deleteBook(book.getModelObject)}	}
            )
			}
    // Pagination nav
    form.add(new BootstrapPagingNavigator("navigator", books))
    // Add table
		form.add(books)
	}
}
