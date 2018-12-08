import scala.collection.mutable

object EvaluateReversePolishNotation {
  def evalRPN(tokens: Array[String]): Int = {
    val stack = mutable.Stack[Int]()
    tokens.foreach {
      case "*" =>
        stack.push(stack.pop() * stack.pop())
      case "+" =>
        stack.push(stack.pop() + stack.pop())
      case "-" =>
        stack.push(0 - stack.pop() + stack.pop())
      case "/" =>
        val d = stack.pop()
        val n = stack.pop()
        stack.push(n / d)
      case other: String =>
        stack.push(other.toInt)
    }
    stack.pop()
  }
}
