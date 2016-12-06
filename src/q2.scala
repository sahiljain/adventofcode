object q2 {
  def partOne(strings: Array[String]): Unit = {
    val keypad: Array[Array[Int]] = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))
    var pos = (1, 1)
    for (str <- strings) {
      for (c <- str) {
        if (c == 'U') {
          pos = (Math max(0, pos._1 - 1), pos._2)
        } else if (c == 'D') {
          pos = (Math min(2, pos._1 + 1), pos._2)
        } else if (c == 'L') {
          pos = (pos._1, Math max(0, pos._2 - 1))
        } else if (c == 'R') {
          pos = (pos._1, Math min(2, pos._2 + 1))
        } else {
          println("error")
        }
      }
      print(keypad(pos._1)(pos._2))
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    val strings = scala.io.Source.fromFile("src/q2.txt").getLines().toArray
    partOne(strings)
  }
}
