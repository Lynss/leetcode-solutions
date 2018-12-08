import scala.annotation.tailrec
import scala.collection.mutable

object OpenTheLock extends App {

  val begin = "0000"

  def upWheel(c: Char): Char = if (c == '9') '0' else (c + 1).toChar

  def downWheel(c: Char): Char = if (c == '0') '9' else (c - 1).toChar

  def openLock(deadends: Array[String], target: String): Int = {
    var found = false
    if (target == begin) return 0
    if (deadends.contains(begin)) return -1
    var step = 0
    val resultQueue = mutable.Queue[Set[String]](Set(begin))
    val mm = mutable.Set[String](begin)

    def produceWheelSet(wheel: String): Set[String] = {
      val Array(a, b, c, d) = wheel.toCharArray
      Set(
        Array(downWheel(a), b, c, d),
        Array(upWheel(a), b, c, d),
        Array(a, downWheel(b), c, d),
        Array(a, upWheel(b), c, d),
        Array(a, b, downWheel(c), d),
        Array(a, b, upWheel(c), d),
        Array(a, b, c, downWheel(d)),
        Array(a, b, c, upWheel(d))
      ).filterNot(ca =>
          deadends.contains(new String(ca)) || mm(new String(ca)))
        .map(ca => {
          val wheel = new String(ca)
          mm += wheel
          if (wheel == target) {
            found = true
          }
          wheel
        })
    }

    def tryAndChange(wheels: Set[String]): Unit = {
      val temp = wheels.flatMap(produceWheelSet)
      if (temp.nonEmpty) resultQueue.enqueue(temp)
    }

    @tailrec
    def beginStep(): Unit = {
      if (resultQueue.nonEmpty && !found) {
        val wheels = resultQueue.dequeue()
        step += 1
        tryAndChange(wheels)
        beginStep()
      }
    }

    beginStep()
    if (found) step else -1
  }

  openLock(
    Array("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"),
    "8888")

}
