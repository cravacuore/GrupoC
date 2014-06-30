package ar.edu.unq.desapp.view.model

import de.agilecoders.wicket.core.Bootstrap
import org.apache.wicket.protocol.http.WebApplication

class HomeApplication extends WebApplication {
	override def getHomePage: Class[HomePage] = classOf[HomePage]

  override def init(){
    super.init()
    Bootstrap.install(this)
  }
}
