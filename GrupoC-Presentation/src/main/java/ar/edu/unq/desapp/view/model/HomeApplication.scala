package ar.edu.unq.desapp.view.model

import de.agilecoders.wicket.core.Bootstrap
import org.apache.wicket.protocol.http.WebApplication
import ar.edu.unq.desapp.services.GeneralService
import scala.beans.BeanProperty
import org.apache.wicket.spring.injection.annot.SpringComponentInjector
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ApplicationContext
import ar.edu.unq.desapp.view.security.ComponentSecurityConfigurer
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession
import ar.edu.unq.desapp.view.security.WebSession
import org.apache.wicket.markup.html.WebPage

class HomeApplication extends AuthenticatedWebApplication with ApplicationContextAware {
  
  @BeanProperty
  var generalService: GeneralService = _
  
  private var isInitialized: Boolean = false
  private var context: ApplicationContext = _
  private var componentSecurityConfigurer: ComponentSecurityConfigurer = _
  
  override def getHomePage: Class[HomePage] = classOf[HomePage]

  override def init(){
    if(!isInitialized) {
      super.init()
      this.getComponentInstantiationListeners().add(new SpringComponentInjector(this))
      isInitialized = true
    }
    Bootstrap.install(this)
  }

  override def getWebSessionClass: Class[_ <: AbstractAuthenticatedWebSession] = {
    classOf[WebSession]
  }

  override def getSignInPageClass: Class[_ <: WebPage] = {
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
