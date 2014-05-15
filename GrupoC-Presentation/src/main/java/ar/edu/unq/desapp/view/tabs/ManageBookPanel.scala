package ar.edu.unq.desapp.view.tabs

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Button
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.list.PropertyListView
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.CompoundPropertyModel

import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.services.GeneralService
import ar.edu.unq.desapp.services.bean.BookService
import ar.edu.unq.desapp.utils.builder.BookBuilder

//@SerialVersionUID(33415151324214142l)
class ManageBookPanel(var idPanel: String) extends Panel(idPanel) {

//  var bookEmtpy: Book = new BookBuilder().build
//  var form: Form[Book] = new Form[Book]("bookForm", new CompoundPropertyModel[Book](this.bookEmtpy))
//  
//  override def onInitialize() {
//    super.onInitialize
//    this.descriptionBookLabel(form)
//    this.textFieldAddBook(form)
//    this.createButton(form)
//    this.createTableBook(form)
//  }
//
//  protected def createTableBook(parent: Form[Book]) {
//    //TODO added implement retriveAll
////    parent.add(new PropertyListView[Book]("retriveAll", this.services.retriveAll) {
////      val serialVersionUID = 1L
////
////      override def populateItem(item: ListItem[Book]) {
////        item.add(new Label("title"))
////        item.add(new Label("isbn"))
////        item.add(new Label("editorial"))
////        item.add(new Label("description"))
////      }
////    })
//  }
//  
//  protected def descriptionBookLabel(form: Form[Book]) {
//    form.add(new Label("labelTitle"))
//    form.add(new Label("labelIsbn"))
//    form.add(new Label("labelEditorial"))
//    form.add(new Label("labelAmount"))
//    form.add(new Label("labelDescription"))
//  }
//
//  protected def textFieldAddBook(form: Form[Book]) {
//    form.add(new TextField[String]("title"))
//    form.add(new TextField[String]("isbn"))
//    form.add(new TextField[String]("editorial"))
//    form.add(new TextField[Integer]("amount"))
//    form.add(new TextField[String]("description"))
//  }
//
//  protected def createButton(form: Form[Book]) {
//    form.add(new Button("Add") {
//      val serialVersionUID: Long = 1341242141L
//      
//      override def onSubmit {
//        ManageBookPanel.this.services.save(form.getModelObject())
//      }
//    })
//    
//    form.add(new Button("Edit") {
//      val serialVersionUID: Long = 301032951023L
//      
//      override def onSubmit {
//        ManageBookPanel.this.services.update(form.getModelObject())
//      }
//    })
//    
//    form.add(new Button("Delete") {
//      val serialVersionUID: Long = 980981230129L
//      
//      override def onSubmit {
//        ManageBookPanel.this.services.delete(form.getModelObject())
//      }
//    })
//    
//  }
  
}
