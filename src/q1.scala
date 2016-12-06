object q1 {
  def main(args: Array[String]): Unit = {
    val strings = scala.io.Source.fromFile("src/q1.txt").mkString.split(",").map(_.trim)
    var positions: Array[(Int, Int)] = Array((0,0))
    var curDirection = Math.PI/2
    var repeatFound = false
    for (str <- strings) {
      val turn = str(0)
      val count = (str substring 1).toInt
      if (turn.equals('L')) curDirection += Math.PI/2
      else curDirection -= Math.PI/2

      for (i <- 1 to count) {
        val xMovement: Int = (Math cos curDirection).toInt
        val yMovement: Int = (Math sin curDirection).toInt

        val newXPos: Int = positions.last._1 + xMovement
        val newYPos: Int = positions.last._2 + yMovement

        if (!repeatFound)
          if (positions.exists(t => t._1 == newXPos && t._2 == newYPos)) {
            println(s"first repeat: ${Math abs newXPos + (Math abs newYPos)}")
            repeatFound = true
          }
        positions :+= (newXPos, newYPos)
      }

    }
    println(Math abs positions.last._1 + (Math abs positions.last._2))
  }
}
