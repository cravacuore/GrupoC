package ar.edu.unq.desapp.view.model

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import ar.edu.unq.desapp.view.tabs.RankingBorrowedBookPage
import ar.edu.unq.desapp.view.tabs.BookListPage

@SerialVersionUID(1129872141829429463L)
//@AuthorizeInstantiation("ROLE_USER")
class BasePage extends HeadBlankPage {

  override def onInitialize {
    super.onInitialize
    this.addLinkToHome
    this.addMainOptions
  }

  private def addLinkToHome {
    add(new BookmarkablePageLink[HomePage]("linkToHomePage", classOf[HomePage]))
  }
  
  private def addMainOptions {
    add(new BookmarkablePageLink("BookList", classOf[BookListPage]))
	add(new BookmarkablePageLink("RankingBorrowedBook", classOf[RankingBorrowedBookPage]))
    add(new BookmarkablePageLink("AddBook", classOf[AddEditBookPage]))
  }
}
