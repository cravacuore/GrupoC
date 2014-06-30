package ar.edu.unq.desapp.view.model

import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication
import org.apache.wicket.spring.injection.annot.SpringComponentInjector
import ar.edu.unq.desapp.services.GeneralService
import org.apache.wicket.injection.Injector
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession
import ar.edu.unq.desapp.view.security.ScalaBaseProjectSession
import ar.edu.unq.desapp.view.security.WebSession
import org.apache.wicket.markup.html.WebPage
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.apache.wicket.spring.injection.annot.SpringBean
import ar.edu.unq.desapp.view.security.ComponentSecurityConfigurer
import scala.beans.BeanProperty

class HomeApplication extends AuthenticatedWebApplication with ApplicationContextAware {
	
	@BeanProperty //@SpringBean(name = "generalService")
	var generalService: GeneralService = _
	
	private var initialized: Boolean = false
	private var context: ApplicationContext = _
	private var componentSecurityConfigurer: ComponentSecurityConfigurer = _
	
	override def init() {
	  if(!initialized) {
	    super.init()
	    initialized = true
		this.getComponentInstantiationListeners().add(new SpringComponentInjector(this))
	  }
	  var a = this.getGeneralService
	}

	override def getHomePage: Class[HomePage] = {
	  classOf[HomePage]
	}
	
	override def getWebSessionClass: Class[_<: AbstractAuthenticatedWebSession] = {
	  classOf[WebSession]
	}
	
	override def getSignInPageClass: Class[_<: WebPage] = {
	  classOf[LoginPage]
	}
	
	override def setApplicationContext(applicationContext: ApplicationContext) {
	  context = applicationContext
	}
	
	def getApplicationContext: ApplicationContext = {
	  context
	}
	
	def setComponentSecurityConfigurer(componentSecurityConfigurer: ComponentSecurityConfigurer) {
        this.componentSecurityConfigurer = componentSecurityConfigurer;
    }
}
