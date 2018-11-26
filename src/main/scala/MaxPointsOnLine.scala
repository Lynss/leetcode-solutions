import scala.annotation.tailrec
import scala.collection.mutable

class Point(var x: Int, var y: Int)

object MaxPointsOnLine extends App {
  val getSlop: (Point, Point) => (Int, Int) = (a: Point, b: Point) => {
    val n = a.x - b.x
    val d = a.y - b.y
    if (d == 0 && n == 0) (0, 0)
    else if (d == 0) (0, a.y)
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

  val samePoint: (Point, Point) => Boolean = (a: Point, b: Point) => a.x == b.x && a.y == b.y

  @tailrec
  private def greatestCommonDivisor(a: Int, b: Int): Int = if (b == 0) a else greatestCommonDivisor(b, a % b)

  type Result = List[((Int, Int), Point, Int)]

  def findMax(p: List[Point]): Result = p match {
    case x :: y :: Nil => List((getSlop(x, y), x, 2))
    case x :: xs if xs.length >= 2 =>
      val mm = mutable.Map[(Int, Int), Int]()
      var max = 0
      var sames = 0
      xs.foreach(point => {
        val g = getSlop(x, point)
        if (samePoint(x, point)) {
          sames += 1
        } else if (mm.contains(g)) {
          mm(g) += 1
        } else {
          mm(g) = 1
        }
        if (max < mm.getOrElse(g,0)) {
          max = mm(g)
        }
      })
      val tempMaxs: List[((Int, Int), Point, Int)] = mm.filter(_._2 == max).map(item => (item._1, x, item._2 + sames)).toList
      max += sames
      val preMaxs = findMax(xs)
      val preHead = preMaxs.head
      if (preHead._3 < max - 1) {
        tempMaxs
      } else {
        val tempChangedMax = preMaxs.filter(item=>samePoint(x, item._2)||item._1==(0,0)|| getSlop(x, item._2) == item._1 ).map(item => (getSlop(x, item._2), item._2, item._3+1))
        val changedMax = if (tempChangedMax.isEmpty) preMaxs else tempChangedMax
        if (changedMax.head._3 > max) {
          changedMax
        } else if (changedMax.head._3 == max) {
          tempMaxs ::: changedMax
        } else {
          tempMaxs
        }
      }

  }

  def maxPoints(points: Array[Point]): Int = {
    val n = points.length
    if(n<=1){
      n
    }else{
      findMax(points.toList).head._3
    }
  }

  val test = Array[Point](new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2))
  maxPoints(test)
}
