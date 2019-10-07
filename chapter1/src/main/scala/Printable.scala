trait Printable[A] {
  def format(value: A) : String
}

object PrintableInstances {
  implicit val stringWriter: Printable[String] = (value: String) => value

  implicit val intWriter: Printable[Int] = (value: Int) => value.toString
}

object Printable {
  def format[A](input: A)(implicit p: Printable[A]): String = p.format(input)
  def print[A](input: A)(implicit p: Printable[A]): Unit = println(format(input))
}

/*
Beer Syntax
Let’s make our printing library easier to use by defining some extension methods to provide beer syntax:
1. Create an object called PrintableSyntax.
2. Inside PrintableSyntax define an implicit class PrintableOps[A] to wrap up a value of type A.
3. In PrintableOps define the following methods:
  • format accepts an implicit Printable[A] and returns a String
  representation of the wrapped A;
  • print accepts an implicit Printable[A] and returns Unit. It
  prints the wrapped A to the console.
4. Use the extension methods to print the example Cat you created in the
previous exercise.
 */
object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit w: Printable[A]): String = {
      w.format(value)
    }

    def print(implicit w: Printable[A]): Unit = {
      println(format(w))
    }
  }

}

final case class Cat(name: String, age: Int, color: String)