package ar.edu.unq.desapp.view.tabs

import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.list.PropertyListView
import org.apache.wicket.markup.html.panel.Panel

import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.services.bean.BookService
import ar.edu.unq.desapp.utils.DSLWicket

@SerialVersionUID(123412341234L)
class RankingBorrowedBookPanel(var idPanel: String, var form: Form[BookService]) extends Panel(idPanel) with DSLWicket{
  
  this.createTableRanking(form)
  
  protected def createTableRanking(form: Form[BookService]) {
    form.add(new PropertyListView[Book]("bookService.retriveAllMostBorrowed") {
      val serialVersionUID = 1L

      override def populateItem(item: ListItem[Book]) {
        item.add(label("title"))
        item.add(label("isbn"))
        item.add(label("editorial"))
        item.add(label("description"))
//        item.add(image)
      }
    })
  }
  
}
