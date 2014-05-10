package ar.edu.unq.desapp.view.model

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession
import org.apache.wicket.authroles.authorization.strategies.role.Roles
import org.apache.wicket.request.Request

class WebSession(request: Request) extends AuthenticatedWebSession(request: Request) {

	private val serialVersionUID: Long = 1L;

	override def authenticate(username: String, password: String ): Boolean = {
		true
	}

	override def getRoles: Roles = {
		val roles: Roles = new Roles
		roles.add("ADMIN")
		roles
	}
}