package ar.edu.unq.desapp.view.model

import org.apache.wicket.Page
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.spring.injection.annot.SpringComponentInjector

import ar.edu.unq.desapp.services.GeneralService

class MyApplication extends AuthenticatedWebApplication {

  var aMounterURL: MounterURL = _
  var generalService: GeneralService = _
  
  def getContextPath = {
    this.getServletContext().getContextPath();
  }

  override protected def getWebSessionClass: Class[_ <: AuthenticatedWebSession] = {
		  classOf[WebSession]
  }
  
  override def getHomePage:  Class[_ <: Page] = {
    classOf[HomePage]
  }

  override protected def getSignInPageClass: Class[_ <: WebPage] = {
    classOf[HomePage]
  }

  override def init = {
    super.init
    this.aMounterURL = new MounterURL(this)
    // Magic!! //
    this.getComponentInstantiationListeners.add(new SpringComponentInjector(this));
    // ////////////////

    this.mountPage("home", classOf[HomePage])
  }

//  private def initializeModel = {
//    
//    var generalSer: GeneralService = this.generalService
//
//  }
  
}
