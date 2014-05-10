package ar.edu.unq.desapp.view.model

import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.markup.html.WebPage

class MounterURL(private val webApplication: WebApplication) {

  def mount(mountPath: String ,pageClass: Class[_ <: WebPage] , parameters: Seq[String]) {
		webApplication.mountPage(mountPath, pageClass)
	}
}