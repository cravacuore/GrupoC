package ar.edu.unq.desapp.view.model

import org.apache.wicket.protocol.http.WebApplication

class PublicLibraryWeb extends WebApplication{
	def getHomePage = classOf[HomePage]
}