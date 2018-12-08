import scala.collection.mutable

object DailyTemperatures extends App {
  def dailyTemperatures(T: Array[Int]): Array[Int] = {
    val result = Array.fill(T.length)(0)
    val stack = mutable.Stack[Int]()
    T.indices.foreach(index => {
      while (stack.nonEmpty && T(stack.top) < T(index)) {
        val cursor = stack.pop()
        result(cursor) = index - cursor
      }
      stack.push(index)
    })
    result
  }
}
