package ar.edu.unq.desapp.view.model

import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.spring.injection.annot.SpringBean
import ar.edu.unq.desapp.services.GeneralService
import ar.edu.unq.desapp.utils.DSLWicket

class HomePage extends WebPage with DSLWicket{

  val serialVersionUID: Long = 1L
  
  @SpringBean(name = "services.general")
  var generalService: GeneralService = null
  
  override def onInitialize {
	  super.onInitialize
	  
  }
  
}

class HelloWorld extends WebPage {
  add(new Label("message", "carajo!!!"))
}