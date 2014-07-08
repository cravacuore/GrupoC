package ar.edu.unq.desapp.services

import ar.edu.unq.desapp.model.bean.Book
import org.apache.commons.io.IOUtils
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient

import scala.util.parsing.json.JSON

class BookApiService {  // TODO - Delete - Deprecated, now this behavior added on BookService

  //  def getBook(isbn: String = "s1gVAAAAYAAJ") = {
  //    Http("http://www.googleapis.com/books/v1/volumes/?q=isbn:" + isbn)
  ////      .param("key","AIzaSyBjabeSyJz1GuxqRLBI9S434upZLfkC35I")
  //      .option(HttpOptions.connTimeout(10000))
  //      .asString
  //  }

  class CC[T] { def unapply(a:Any):Option[T] = Some(a.asInstanceOf[T]) }

  object M extends CC[Map[String, Any]]
  object L extends CC[List[Any]]
  object S extends CC[String]

  def getExternalBook(isbn: String = "9589760457") = {
    getBook(isbn).head
  }

  private def getBook(isbn: String) = {
    for {
      Some(M(map)) <- List(getJson(isbn))
      L(items) = map("items")
//M(item) = map("items")
      M(item) <- items
      M(volumeInfo) = item("volumeInfo")
      S(title) = volumeInfo("title")
      L(authors) = volumeInfo("authors")
      S(editorial) = volumeInfo("publisher")
      M(imageLinks) = volumeInfo("imageLinks")
      S(imageUrl) = imageLinks("thumbnail")
    } yield {
      new Book(title, isbn, editorial, imageUrl, authors.toString()) //TODO - Add description
    }
  }

  def getJson(isbn: String) = {
    val apiUrl = "https://www.googleapis.com/books/v1/volumes/"
    val apiKey = "&key=AIzaSyBjabeSyJz1GuxqRLBI9S434upZLfkC35I"
    val filterParams = "&fields=items(volumeInfo)"

    val request = new HttpGet(apiUrl + "?q=isbn:" + isbn + filterParams + apiKey)
    val client = new DefaultHttpClient()
    val response = client.execute(request)

    println(response.getStatusLine.getStatusCode)
    val json = IOUtils.toString(response.getEntity.getContent)
    //    response.getEntity.getContent.toString
    //    "Getting json" + json
    JSON.parseFull(json)
  }
}
