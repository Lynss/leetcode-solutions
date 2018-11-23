/**
  * program: leetcode-solutions
  * author: longyun
  * update 2018-11-23 14:23
  * create: 2018-11-23 14:23
  **/
object AddTwoNumbers extends App {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = _
    var x: Int = _x
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var a = l1.x + l2.x
    val b = a >= 10
    var c: ListNode = new ListNode(0)
    if (b) {
      a -= 10
      c = new ListNode(1)
    }
    val result = new ListNode(a)
    result.next = (l1.next, l2.next) match {
      case (null, null) => if (b) c else null
      case (_, null) => addTwoNumbers(l1.next, c)
      case (null, _) => addTwoNumbers(c, l2.next)
      case _ => addTwoNumbers(addTwoNumbers(l1.next, l2.next), c)
    }
    result
  }
}
