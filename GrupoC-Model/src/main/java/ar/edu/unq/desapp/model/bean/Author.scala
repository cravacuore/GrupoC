package ar.edu.unq.desapp.model.bean

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "authors")
class Author(var name: String) {

  @Id @GeneratedValue
  var id: Int = _

  var writtenBooks: List[Book] = _
  
  // Accessor's //
  
  def getId: Int = {
    id
  }
  
  def setId(anID: Int) {
    id = anID
  }
  
  def getName: String = {
    name
  }
  
  def setName(aName: String) {
    name = aName
  }
  
  @OneToMany
  def getWrittenBooks: java.util.List[Book] = {
    writtenBooks.asJava.toList
  }
  
  def setWrittenBooks(aWrittenBooks: java.util.List[Book]) {
    writtenBooks = aWrittenBooks.asScala.toList
  }
}
