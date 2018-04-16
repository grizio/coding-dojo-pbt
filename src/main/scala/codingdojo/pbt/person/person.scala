package codingdojo.pbt

import definiti.native._
import java.time.LocalDateTime

package object person {
  case class Person(firstName: String, lastName: String, phoneNumber: List[String])
  object Person {
    val verification: Verification[Person] = {
      object Person0 extends SimpleVerification[Person]("Is this person crazy???") {
        override def isValid(person: Person): Boolean = {
          person.firstName != person.lastName
        }
      }
      Verification.all(Verification.all(NonEmptyString.verification).from[Person](_.firstName, "firstName"), Verification.all(NonEmptyString.verification).from[Person](_.lastName, "lastName"), Verification.all(NonEmptyList.verification[String], new ListVerification(PhoneNumber.verification)).from[Person](_.phoneNumber, "phoneNumber"), Person0)
    }
  }
  object NonEmptyString {
    val verification: Verification[String] = {
      object NonEmptyString0 extends SimpleVerification[String]("The string should not be empty") {
        override def isValid(string: String): Boolean = StringExtension.nonEmpty(string)
      }
      Verification.all(NonEmptyString0)
    }
  }
  object PhoneNumber {
    val verification: Verification[String] = {
      object PhoneNumber0 extends SimpleVerification[String]("The phone number seems invalid") {
        override def isValid(phoneNumber: String): Boolean = {
          phoneNumber.length == BigDecimal(10)
        }
      }
      Verification.all(PhoneNumber0)
    }
  }
  object NonEmptyList {
    def verification[A](): Verification[List[A]] = {
      object NonEmptyList0 extends SimpleVerification[List[A]]("The list should not be empty") {
        override def isValid(list: List[A]): Boolean = ListExtension.nonEmpty(list)
      }
      Verification.all(NonEmptyList0)
    }
  }
}
