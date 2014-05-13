package ar.edu.unq.desapp.view.model

import org.apache.wicket.protocol.http.WebApplication

class HomeApplication extends WebApplication {
  
	override def getHomePage: Class[Home] = classOf[Home]
}
