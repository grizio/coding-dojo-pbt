package codingdojo.pbt.simple

import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks
import org.scalatest.{ FlatSpec, Matchers }

class SimpleUtilsSpec extends FlatSpec with Matchers with PropertyChecks {
  "SimpleUtils" should "have a valid avg function" in {
    SimpleUtils.avg(Seq(1, 3)) should ===(2)
  }
  it should "have a valid avg function 2" in {
    SimpleUtils.avg(Seq()) should ===(7)
  }

  it should "have a valid factoriel function" in {
    SimpleUtils.factoriel(5) should ===(120)
  }

  it should "have a valid factoriel function 2" in {
    SimpleUtils.factoriel(200) should ===(3)
  }

  it should "accept a non empty string" in {
    SimpleUtils.nonEmpty("a") should ===(true)
  }

  it should "accept a non empty string 2" in {
    SimpleUtils.nonEmpty("") should ===(false)
  }

  it should "accept a non empty string 3" in {
    SimpleUtils.nonEmpty(" ") should ===(true)
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

  it should "primary 1" in {
    SimpleUtils.isPrimary(1) should ===(false)
  }

  it should "primary 2" in {
    SimpleUtils.isPrimary(2) should ===(true)
  }

  it should "primary 3" in {
    SimpleUtils.isPrimary(3) should ===(true)
  }

  it should "primary 53" in {
    SimpleUtils.isPrimary(53) should ===(true)
  }

  it should "primary 13157" in {
    SimpleUtils.isPrimary(13157) should ===(false)
  }

  it should "check a lot of cases" in {
    forAll(Gen.posNum[Int].filter(_ > 1)) { n =>
      SimpleUtils.isPrimary(n * 5) should ===(false)
    }
  }

  it should "check a lot of cases 2" in {
    forAll(for{
      n <- Gen.posNum[Int].filter(_ > 1)
      m <- Gen.posNum[Int].filter(_ > 1)
      //if n != m
    } yield (n, m)) { case (n, m) =>
      SimpleUtils.isPrimary(n * m) should ===(false)
    }
  }
}
