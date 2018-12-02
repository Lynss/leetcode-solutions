class MyCircularQueue(_k: Int) {

  /** Initialize your data structure here. Set the size of the queue to be k. */
  var head: Int = -1
  var tail: Int = -1
  val length: Int = _k
  val data = new Array[Int](length)


  /** Insert an element into the circular queue. Return true if the operation is successful. */
  def enQueue(value: Int): Boolean = {
    if (isFull) return false
    if (isEmpty) head = 0
    tail = (tail + 1) % length
    data(tail) = value
    true
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  def deQueue(): Boolean = {
    if (isEmpty) return false
    if (head == tail) {
      head = -1
      tail = -1
      return true
    }
    head = (head + 1) % length
    true
  }

  /** Get the front item from the queue. */
  def Front(): Int = data(head)

  /** Get the last item from the queue. */
  def Rear(): Int = data(tail)

  /** Checks whether the circular queue is empty or not. */
  def isEmpty: Boolean =  head == -1

  /** Checks whether the circular queue is full or not. */
  def isFull: Boolean = (tail + 1) % length == head

}
