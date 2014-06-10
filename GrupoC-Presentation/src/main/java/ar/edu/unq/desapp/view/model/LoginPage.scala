package ar.edu.unq.desapp.view.model

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.PasswordTextField
import org.apache.wicket.markup.html.form.RequiredTextField
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.request.mapper.parameter.PageParameters
import scala.collection.JavaConversions._
import ar.edu.unq.desapp.view.security.ScalaBaseProjectSession

class LoginPage(parameters: PageParameters) extends HeadBlankPage {

  add(new LoginForm("loginform"))

  //TODO - Refactor
  def this() {
    this(null)
  }

  private class LoginForm(id: String) extends Form(id) {

    private var username: String = _

    private var password: String = _

//    setModel(new CompoundPropertyModel(this))

    add(new RequiredTextField("username"))

    add(new PasswordTextField("password"))

    add(new FeedbackPanel("feedback"))

    protected override def onSubmit {
      val session = ScalaBaseProjectSession.getSession
      if (session.signIn(username, password)) {
        LoginForm.this.setResponsePage(classOf[HomePage])
      } else {
        error(getString("login.failed"))
      }
    }
  }
}
