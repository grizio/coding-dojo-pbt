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

  val validPerson = for {
    firstName <- Gen.alphaStr
    lastName <- Gen.alphaStr
    phonesNumber <- Gen.listOf(Gen.alphaStr)
  } yield {
    Person(firstName, lastName, phonesNumber)
  }
}
