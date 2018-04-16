package codingdojo.pbt.simple

object SimpleUtils {
  def avg(numbers: Seq[Int]): Int = {
    numbers.sum / numbers.length
  }

  def factoriel(n: Int): Int = {
    def process(acc: Int, n: Int): Int = n match {
      case 0 => acc
      case m => process(acc * m, m - 1)
    }
    process(1, n)
  }

  def nonEmpty(string: String): Boolean = {
    string.trim.nonEmpty
  }

  def isPrimary(n: Int): Boolean = {
    val square = Math.sqrt(n)
    !Range(2, square.toInt).exists(m => n % m == 0)
  }
}
