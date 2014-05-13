package ar.edu.unq.desapp.view.model

import scala.collection.JavaConverters.seqAsJavaListConverter
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.model.Model
import org.apache.wicket.spring.injection.annot.SpringBean
import ar.edu.unq.desapp.utils.DSLWicket
import ar.edu.unq.desapp.view.tabs.ManageBookPanel
import ar.edu.unq.desapp.services.GeneralService
import ar.edu.unq.desapp.view.tabs.RankingBorrowedBookPanel
import org.apache.wicket.markup.html.form.Button


@SerialVersionUID(9798132401L)
class Home extends WebPage with DSLWicket {

  @SpringBean(name = "services.general")
  var generalService: GeneralService = new GeneralService

  var message: Label = null

  override def onInitialize {
    super.onInitialize
    
//    this.createTabs
//    val form = new Form[GeneralService]("GeneralServiceForm", new CompoundPropertyModel[GeneralService](this.generalService))
//    this.createTabsBook(form)
//    add(form)
  }
  
//  protected def changeTab {
//     add(new Button("button"))
//  }

  protected def createTabs() {
    var tabs: List[AbstractTab] = List(
//        (new AbstractTab(new Model[String]("tab1")) {
//        def getPanel(panelId: String): Panel = { return new ManageBookPanel(panelId, generalService.bookService) }
//        }),
//        (new AbstractTab(new Model[String]("tab3")) {
//        override def getPanel(panelId: String): Panel = { new RankingBorrowedBookPanel(panelId, generalService.bookService) }
//        })
    )
    
//    add(new TabbedPanel("tabs", tabs.asJava))
  }
 
}
