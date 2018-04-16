package codingdojo.pbt.simple

import org.scalatest.{FlatSpec, Matchers}

class SimpleUtilsSpec extends FlatSpec with Matchers {
  "SimpleUtils" should "have a valid avg function" in {
    SimpleUtils.avg(Seq(1, 3)) should ===(2)
  }

  it should "have a valid factoriel function" in {
    SimpleUtils.factoriel(5) should ===(120)
  }

  it should "accept a non empty string" in {
    SimpleUtils.nonEmpty("a") should ===(true)
  }

  it should "refuse an empty string" in {
    SimpleUtils.nonEmpty("") should ===(false)
  }

  it should "know if a number is primary" in {
    SimpleUtils.isPrimary(7) should ===(true)
  }

  it should "know if a number is not primary" in {
    SimpleUtils.isPrimary(12) should ===(false)
  }

  /*
  it should "check a lot of cases" in {
    forAll(Gen.posNum[Int].filter(_ > 1)) { n =>
      SimpleUtils.isPrimary(n * 5) should ===(false)
    }
  }
  */
}
