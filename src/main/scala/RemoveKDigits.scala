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
    val n = num.length
    val stack = mutable.Stack[Char]()
    var i = 0
    @tailrec
    def fillK(nl: List[Char]): Unit= {
      if(nl.nonEmpty){
        while(i != k&& stack.nonEmpty&& stack.top>nl.head ){
          stack.pop()
          i+=1
        }
        stack.push(nl.head)
        fillK(nl.tail)
      }
    }

     fillK(num.toList)
    val temp = stack.drop(k-i).reverse.mkString
    reduceZero(temp)
  }

  val temp = removeKdigits("1432219",3)
  temp
}
