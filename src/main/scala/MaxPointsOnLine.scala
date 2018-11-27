import scala.annotation.tailrec
import scala.collection.mutable

class Point(var x: Int, var y: Int)

object MaxPointsOnLine extends App {
  @tailrec
  private def greatestCommonDivisor(a: Int, b: Int): Int =
    if (b == 0) a else greatestCommonDivisor(b, a % b)

  val getSlope: (Point, Point) => (Int, Int) = (a: Point, b: Point) => {
    val n = a.x - b.x
    val d = a.y - b.y
    if (d == 0) (0, a.y)
    else if (n == 0) (a.x, 0)
    else {
      val x = n / greatestCommonDivisor(math.abs(n), math.abs(d))
      val y = d / greatestCommonDivisor(math.abs(n), math.abs(d))
      if (x < 0) {
        (-x, -y)
      } else {
        (x, y)
      }
    }
  }

  val samePoint: (Point, Point) => Boolean = (a: Point, b: Point) =>
    a.x == b.x && a.y == b.y

  def maxPoints(points: Array[Point]): Int = {
    if (points == null) return 0
    if (points.length <= 2) return points.length
    var mm = mutable.Map[(Int, Int), Int]()

    var result = 0
    for (i <- points.indices) {
      mm = mutable.Map.empty
      var same = 1
      for (j <- i + 1 until points.length) {
        if (samePoint(points(i), points(j))) {
          same += 1
        } else {
          val k = getSlope(points(i), points(j))
          if (mm.contains(k)) {
            mm(k) += 1
          } else {
            mm(k) = 1
          }
        }
      }
      val tempMax = (if (mm.isEmpty) 0 else mm.values.max) + same
      if (result < tempMax) result = tempMax
    }
    result
  }

  val test = Array[Point](new Point(0, 0))
  maxPoints(test)
}
