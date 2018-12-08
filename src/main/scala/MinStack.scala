import scala.collection.mutable

class MinStack() extends mutable.Stack[Int] {
  private val mins = mutable.Stack[Int]()
  override def top(): Int = super.top
  def getMin(): Int = mins.top

  override def push(x: Int) = {
    if (mins.isEmpty || mins.top >= x)
      mins.push(x)
    super.push(x)
  }

  override def pop() = {
    if (mins.top == top)
      mins.pop()
    super.pop()
  }
}
