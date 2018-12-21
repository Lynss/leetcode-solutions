import scala.collection.mutable

object BinaryTreeLevelOrderTraversal extends App {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) return Nil
    val queue = mutable.Queue(List(root))
    val result = mutable.ListBuffer[List[Int]]()
    while (queue.nonEmpty) {
      val temp = mutable.ListBuffer[Int]()
      val tempList = queue
        .dequeue()
        .filterNot(_ == null)
        .flatMap(node => {
          temp.append(node.value)
          List(node.left, node.right)
        })
      if (temp.nonEmpty) {
        result.append(temp.toList)
        queue.enqueue(tempList)
      }
    }
    result.toList
  }

  val test = new TreeNode(1,
                          new TreeNode(2, new TreeNode(4)),
                          new TreeNode(3, right = new TreeNode(5)))
  levelOrder(test)
}
