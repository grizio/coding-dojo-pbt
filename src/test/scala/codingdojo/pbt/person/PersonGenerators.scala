package codingdojo.pbt.person

import org.scalacheck.Gen

object PersonGenerators {
  val anyPerson = for {
    firstName <- Gen.alphaStr
    lastName <- Gen.alphaStr
    phonesNumber <- Gen.listOf(Gen.alphaStr)
  } yield {
    Person(firstName, lastName, phonesNumber)
  }

  val nonEmptyString = for {
    firstChar <- Gen.alphaChar
    str <- Gen.alphaStr
  } yield firstChar + str

  val numberPhone = for {
    n <- Gen.listOfN(10, Gen.alphaChar)
  } yield n.mkString

  val validPerson = for {
    firstName <- nonEmptyString
    lastName <- nonEmptyString
    phonesNumber <- Gen.nonEmptyListOf(numberPhone)
  } yield {
    Person(firstName, lastName, phonesNumber)
  }

  val personWithInvalPerson = for {
    person <- validPerson
    invalidPhone <- Gen.alphaStr
  } yield {
    person.copy(phoneNumber = List(invalidPhone))
  }
}
