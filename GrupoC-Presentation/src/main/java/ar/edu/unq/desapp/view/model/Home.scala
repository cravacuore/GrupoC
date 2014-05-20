package ar.edu.unq.desapp.view.model

import scala.collection.JavaConverters.seqAsJavaListConverter
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.Model
import org.apache.wicket.spring.injection.annot.SpringBean
//import ar.edu.unq.desapp.services.GeneralService
import ar.edu.unq.desapp.utils.DSLWicket
import ar.edu.unq.desapp.view.tabs.BookListPanel
import ar.edu.unq.desapp.view.tabs.RankingBorrowedBookPanel

@SerialVersionUID(9798132401L)
class Home extends WebPage with DSLWicket {

  var message: Label = null

  override def onInitialize {
    super.onInitialize
    add(this.createTabs)
  }
  
  protected def createTabs: TabbedPanel[AbstractTab] = {
    var tabs: List[AbstractTab] = List(
        (new AbstractTab(new Model("BookListPanel")) {
        	def getPanel(panelId: String): Panel = { 
        	  new BookListPanel(panelId)
        	}
        }),
        (new AbstractTab(new Model("RankingBorrowedBookPanel")) {
        	def getPanel(panelId: String): Panel = { 
        	  new RankingBorrowedBookPanel(panelId) 
        	}
        })
    )
    new TabbedPanel("tabs", tabs.asJava)
  }
}
