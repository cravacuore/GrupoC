package ar.edu.unq.desapp.view.model

import ar.edu.unq.desapp.services.BooksApiServer
import org.apache.wicket.markup.html.basic.Label

class TestGoogleAPIServicePage extends HeadBlankPage {
  override def onInitialize() {
    super.onInitialize()

    val service = new BooksApiServer
    val req = service.getBook()

    add(new Label("content", req))
  }
}
