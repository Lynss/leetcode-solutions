import scala.collection.mutable

object FloodFill {
  def floodFill(image: Array[Array[Int]],
                sr: Int,
                sc: Int,
                newColor: Int): Array[Array[Int]] = {
    val originalColor = image(sr)(sc)
    if (newColor == originalColor) return image
    val row = image.length
    val col = image(0).length
    val set = mutable.Set[(Int, Int)]()
    def changeColor(coordinate: (Int, Int)): Unit = {
      val (x, y) = coordinate
      if (!(x >= 0 && y >= 0 && x < row && y < col && !set(x, y) && image(x)(y) == originalColor))
        return
      image(x)(y) = newColor
      set.add(x, y)
      changeColor(x - 1, y)
      changeColor(x + 1, y)
      changeColor(x, y - 1)
      changeColor(x, y + 1)
    }
    changeColor(sr, sc)
    image
  }
  floodFill(Array(Array(0, 0, 0), Array(0, 1, 1)), 1, 1, 1)
}
