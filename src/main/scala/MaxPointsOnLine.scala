import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Point(var _x: Int, var _y: Int) {
  var x: Int = _x
  var y: Int = _y
}

object MaxPointsOnLine extends App {

  val getSlop: (Point, Point) => (Int, Int) = (a: Point, b: Point) => {
    val n = a.x - b.x
    val d = a.y - b.y
    if (d == 0 && n == 0) (0, 0)
    else (n / greatestCommonDivisor(math.abs(n), math.abs(d)),
      d / greatestCommonDivisor(math.abs(n), math.abs(d)))

  }

  @tailrec
  private def greatestCommonDivisor(a: Int, b: Int): Int = if (b == 0) a else greatestCommonDivisor(b, a % b)

  type Result =  List[((Int, Int), List[Point], Int)]
  def findMax(p: List[Point]):Result= p match {
    case x :: y :: Nil => List((getSlop(x, y), List(x, y), 2))
    case x :: xs if xs.length >= 2 =>
      val tempMaxs = ListBuffer[Result]()
      val mm = mutable.Map[(Int, Int), List[Point]]()
      xs.foreach(point=>{
        val g = getSlop(x,point)
        if(mm.contains(g)) {
          mm(g)= point:: mm(g)
        }else{
          mm(g) = List(point)
        }
      })
      val preMaxs = findMax(xs)
      preMaxs.filter {
        case (slop, ps, m) =>
          slop == getSlop(ps.head, x)
      }.map()
  }

  def maxPoints(points: Array[Point]): Int = {
  }

  val test = Array[Point](new Point(1, 1), new Point(3, 2), new Point(5, 3), new Point(4, 1), new Point(2, 3), new Point(1, 4))
  maxPoints(test)
}
