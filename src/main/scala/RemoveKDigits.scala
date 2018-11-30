import scala.annotation.tailrec
import scala.collection.mutable

object RemoveKDigits extends App {

  @tailrec
  def reduceZero(a: String): String = {
    if (a.isEmpty) "0"
    else if (a.head != '0') a
    else reduceZero(a.tail)
  }

  def removeKdigits(num: String, k: Int): String = {
    if (num.length == k) return "0"
    if (k == 0) return num
    val nh :: nt = num.toList
    val stack = mutable.Stack[Char](nh)
    val before = mutable.ListBuffer[Char]()

    @tailrec
    def fillK(nl: List[Char]): List[Char] = {
      if (nl.isEmpty) return Nil
      if (stack.length == k) return nl
      val nlh :: nlt = nl
      if (stack.top > nlh) {
        stack.push(nlh)
        fillK(nlt)
      } else {
        before.append(stack.pop())
        stack.push(nlh)
        fillK(nlt)
      }
    }

    reduceZero(
      before
        .appendAll(fillK(nt))
        .toString
        .substring(0, num.length - stack.length))
  }

  val temp = removeKdigits("1432219", 3)
  temp
}
