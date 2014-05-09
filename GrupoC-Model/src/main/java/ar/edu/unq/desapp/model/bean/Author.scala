package ar.edu.unq.desapp.model.bean

import javax.persistence.{ GeneratedValue, Id, Entity }
import reflect.BeanProperty
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity
@Table(name = "AUTHOR")
class Author(var name: String) {

  @Id @GeneratedValue
  var id: Long = _

  @OneToMany(mappedBy = "id_book")
  var writtenBooks: List[Book] = Nil
}
