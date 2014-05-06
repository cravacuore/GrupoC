package ar.edu.unq.desapp.model.bean

import javax.persistence.{ GeneratedValue, Id, Entity }
import reflect.BeanProperty
import javax.persistence._

@Entity
@Table(name = "AUTHOR")
class Author(@Column(name = "name") var name: String) {

  @Id @GeneratedValue
  @Column(name = "id_author")
  var id: Long = 0

  @Column(name = "written_books")
  @OneToMany(mappedBy = "id_book")
  var writtenBooks: List[Book] = Nil
}
