package ar.edu.unq.desapp.view.model

import ar.edu.unq.desapp.appModel.BookDetails
import ar.edu.unq.desapp.model.bean.{Book, Comment}
import ar.edu.unq.desapp.services.GeneralService
import ar.edu.unq.desapp.view.security.ScalaBaseProjectSession
import ar.edu.unq.desapp.view.tabs.BookListPage
import de.agilecoders.wicket.core.markup.html.bootstrap.navigation.BootstrapPagingNavigator
import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.{Button, StatelessForm, TextArea}
import org.apache.wicket.markup.html.image.Image
import org.apache.wicket.markup.html.list.{ListItem, PageableListView}
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.spring.injection.annot.SpringBean

import scala.beans.BeanProperty

class BookDetailsPage(book: Book) extends HeadBlankPage {

	val mainPage: BookListPage = new BookListPage

  @BeanProperty @SpringBean(name = "services.general")
  var generalService: GeneralService = _

 	override def onInitialize() {
 	  super.onInitialize()
 	  	
    val bookDetails: BookDetails = new BookDetails(book)
    val bookForm = new StatelessForm[BookDetails]("bookForm", new CompoundPropertyModel(bookDetails))
		
 	  addImage(bookForm)
 		addLabels(bookForm)
    addCommentsTable(bookForm)
    addCommentsActions(bookForm)
 		addActions(bookForm)
 		add(bookForm)
 	}
	
 	private def addImage(parent: StatelessForm[BookDetails]) {
    val image = new Image("cover", "../library.png")
    val url = parent.getModelObject.book.getImageUrl
    image.add(new AttributeModifier("src", url))
		parent.add(image)
 	}

 	private def addLabels(parent: StatelessForm[BookDetails]) {
 		parent.add(new Label("book.title"))
 		parent.add(new Label("book.isbn"))
		parent.add(new Label("getAuthors"))
 		parent.add(new Label("book.editorial"))
 	}

  // Adds comments table
  private def addCommentsTable(form: StatelessForm[BookDetails]) {
    val comments =
      new PageableListView[Comment]("comments", form.getModelObject.book.comment, 5) {
        override def populateItem(comment: ListItem[Comment]) =
          comment.add(
            new Label("comment", comment.getModelObject.getComment),
            new Label("author", comment.getModelObject.getUser.getUsername),
            new Label("date", comment.getModelObject.getDate.toDate)
          )
      }
    // Pagination nav
    form.add(new BootstrapPagingNavigator("navigator", comments))
    // Add table
    form.add(comments)
  }

  private def addCommentsActions(parent: StatelessForm[BookDetails]){
    parent.add(new TextArea[String]("book_comment"))
 		parent.add(new Button("addComment") { override def onSubmit() { addComment(parent.getModelObject.book, parent.getModelObject.book_comment) }})
  }

 	private def addActions(parent: StatelessForm[BookDetails]){
		parent.add(new Button("back") {	override def onSubmit() { backPage() }})
 	}

 	private def backPage() {
		setResponsePage(mainPage)
 	}

  private def addComment(book: Book, comment: String) {
    ScalaBaseProjectSession.getCurrentUser.commentBook(book, comment)
    generalService.bookService.update(book)
    setResponsePage(new BookDetailsPage(book))
  }
}
