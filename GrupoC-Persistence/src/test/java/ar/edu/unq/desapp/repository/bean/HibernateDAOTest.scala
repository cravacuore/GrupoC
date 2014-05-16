package ar.edu.unq.desapp.repository.bean

import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.specs2.mock.Mockito

import ar.edu.unq.desapp.model.bean.User
import ar.edu.unq.desapp.utils.builder.Builder

class HibernateDAOTest extends FunSpec with ShouldMatchers with GivenWhenThen with Builder {

  describe("Hibernate Repository DAO") {
    it("User") {
      var session = new UserRepository

      Given("four users i want load to data base")
      val userPepe: User =
        anUser.withName("Pepe").withPassword("1234").withEmail("pepe@mail.com").build

      val userJosefina: User =
        anUser.withName("Josefina").withPassword("6542").withEmail("josefina@mail.com").build

      val userSara: User =
        anUser.withName("Sara").withPassword("qieo").withEmail("sara@mail.com").build

      val userCarlo: User =
        anUser.withName("Carlo").withPassword("mnb098").withEmail("carlo@mail.com").build

      When("save users")
      session.save(userPepe)
      session.save(userJosefina)
      session.save(userSara)
      session.save(userCarlo)

      Then("should get loaded the users")
      session.count should be(4)
    }

  }
}
