package ar.edu.unq.desapp.utils.builder

import java.awt.Image
import java.awt.image.BufferedImage
import org.joda.time.DateTime
import ar.edu.unq.desapp.model.bean.Book
import ar.edu.unq.desapp.model.bean.Author

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class BookBuilder extends BuilderToTest[Book] {

  var title: String = "no title"
  var isbn: String = "no isbn"
  var editorial: String = "no editorial"
  var image: String = "no picture"
  var description: String = "no description"
  var authors: List[Author] = Nil
  var amount: Int = 1 //DEFAULT!!!!
  var registrationDate = new DateTime

  def withTitle(aTitle: String): BookBuilder = {
    this.title = aTitle
    this
  }

  def withIsbn(anIsbn: String): BookBuilder = {
    this.isbn = anIsbn
    this
  }

  def withEditorial(anEditorial: String): BookBuilder = {
    this.editorial = anEditorial
    this
  }

  def withImage(anImage: String): BookBuilder = {
    this.image = anImage
    this
  }

  def withDescription(anDescription: String): BookBuilder = {
    this.description = anDescription
    this
  }

  def withAmount(n: Int): BookBuilder = {
    this.amount = n
    this
  }

  def withAuthors(myAuthors: List[Author]): BookBuilder = {
    this.authors = myAuthors
    this
  }

  def withRegistrationDate(date: DateTime): BookBuilder = {
    this.registrationDate = date
    this
  }

  def build: Book = {
    var book = new Book(
      this.title,
      this.isbn,
      this.editorial,
      this.image,
      this.description,
      this.amount)
    
    book.authors = this.authors
    book
  }
}
