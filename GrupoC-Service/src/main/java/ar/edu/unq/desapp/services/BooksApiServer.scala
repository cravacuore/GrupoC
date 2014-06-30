package ar.edu.unq.desapp.services

import org.apache.commons.io.IOUtils
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient

import scala.util.parsing.json.{JSONObject, JSON}

class BooksApiServer {

  //  def getBook(isbn: String = "s1gVAAAAYAAJ") = {
  //    Http("http://www.googleapis.com/books/v1/volumes/?q=isbn:" + isbn)
  ////      .param("key","AIzaSyBjabeSyJz1GuxqRLBI9S434upZLfkC35I")
  //      .option(HttpOptions.connTimeout(10000))
  //      .asString
  //  }

  def getBook(isbn: String = "9589760457") = {

    val apiUrl = "https://www.googleapis.com/books/v1/volumes/"
    val apiKey = "&key=AIzaSyBjabeSyJz1GuxqRLBI9S434upZLfkC35I"
    val filterParams = "&fields=items(volumeInfo)"

    val request = new HttpGet(apiUrl + "?q=isbn:" + isbn + filterParams + apiKey)
    val client = new DefaultHttpClient()
    val response = client.execute(request)

    println(response.getStatusLine.getStatusCode)
    val json = IOUtils.toString(response.getEntity.getContent)
    //    response.getEntity.getContent.toString
    "Getting json" + json
//      JSON.parseRaw(json)
  }
}