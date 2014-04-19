class Rational(n: Int, d: Int) {
  require(d != 0)

  val g = gcd(n,d)  // Reduce.
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational = 
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

// Companion Object
object Rational {
  def main(args: Array[String]){

    var r1 = new Rational(4,7)
    println(r1.toString)

    var r2 = new Rational(17,4)
    println(r2.toString)

    println(r1 + r2)
  }
}
