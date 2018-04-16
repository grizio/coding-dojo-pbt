package codingdojo.pbt.person

import codingdojo.pbt.simple.SimpleUtils
import definiti.native.Valid
import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class PersonSpec extends FlatSpec with Matchers with PropertyChecks {
  "Person" should "be valid" in {
    val person = Person("John", "Doe", List("0123456789"))
    Person.verification.verify(person) should ===(Valid(person))
  }

  /*
  it should "be valid for any valid Person" in {
    forAll(PersonGenerators.validPerson) { person =>
      Person.verification.verify(person) should ===(Valid(person))
    }
  }
  */
}
