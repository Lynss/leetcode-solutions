import scala.collection.mutable

object KeysAndRooms extends App {
  def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
    val originalKeys = rooms.head
    val keys = mutable.Set[Int](0)
    var keyNum = 1
    val totalKeyNum = rooms.length
    val stack = mutable.Stack[Int](originalKeys: _*)
    val roomVector = rooms.toVector
    while (stack.nonEmpty) {
      val tempKey = stack.pop()
      if (!keys(tempKey)) {
        keys.add(tempKey)
        keyNum += 1
        if (keyNum == totalKeyNum) return true
        stack.pushAll(roomVector(tempKey))
      }
    }
    keyNum == totalKeyNum
  }
  canVisitAllRooms(List(List(1), List(2), List(3), List()))
}
