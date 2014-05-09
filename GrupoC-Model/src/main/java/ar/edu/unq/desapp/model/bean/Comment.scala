package ar.edu.unq.desapp.model.bean

import org.joda.time.DateTime
import reflect.BeanProperty
import javax.persistence._

@Entity
@Table(name = "COMMENT")
class Comment(
  @OneToOne(mappedBy = "id_user") var anUser: User,
  @Column(name = "comment") var comment: String,
  @Column(name = "comment_date") var date: DateTime) {
  @Id @GeneratedValue
  @Column(name = "id_comment")
  var id: Long = _
}
