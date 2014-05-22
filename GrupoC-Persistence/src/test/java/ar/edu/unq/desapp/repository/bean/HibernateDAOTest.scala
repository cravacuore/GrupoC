package ar.edu.unq.desapp.repository.bean

import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.specs2.mock.Mockito
import ar.edu.unq.desapp.model.bean.User
import ar.edu.unq.desapp.utils.builder.Builder
import ar.edu.unq.desapp.model.bean.Book
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.beans.factory.annotation.Autowired
import org.junit.Test
import org.springframework.test.context.TestContextManager

@ContextConfiguration( Array("classpath:/META-INF/spring-persistence-context.xml", "classpath:/spring/*.xml"))
class HibernateDAOTest extends FunSpec with ShouldMatchers with GivenWhenThen with Builder {
  
  new TestContextManager(classOf[HibernateDAOTest]).prepareTestInstance(this)
  @Autowired
  var bookRepository: BookRepository = _
  
  describe("Hibernate Repository DAO") {
    it("Book") {

      Given("four users i want load to data base")

      val bookTest: Book = aBook.withTitle("something").withAmount(3).withDescription("nothing").build
      
      When("save users")
      bookRepository.save(bookTest)

      Then("should get loaded the users")
    }

  }
}
