import scala.collection.mutable

object ValidParentheses {
  val validateMap: Map[Char, Char] = Map('(' -> ')', '{' -> '}', '[' -> ']')
  def isValid(s: String): Boolean = {
    val bracketStack = mutable.Stack[Char]()
    s.foreach(i => {
      if (bracketStack.nonEmpty && validateMap
            .get(bracketStack.top)
            .contains(i)) {
        bracketStack.pop()
      } else {
        bracketStack.push(i)
      }
    })
    bracketStack.isEmpty
  }
}
