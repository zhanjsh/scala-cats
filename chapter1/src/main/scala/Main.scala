import PrintableInstances._
import PrintableSyntax._

object Main extends App {
  val cat = Cat("mittens", 12, "black")

  implicit val catPrintable: Printable[Cat] = new Printable[Cat] {
    def format(cat: Cat): String = {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val color = Printable.format(cat.color)
      s"$name is a $age year old $color cat."
    }
  }

  Printable.print(cat)

  Cat("captain", 2, "ginger").print
}

