import scala.collection.mutable.ListBuffer

object BinaryTreeInorderTraversal {
  def inorderTraversal(root: TreeNode): List[Int] = {
    val res = ListBuffer[Int]()
    def inorder(root: TreeNode): ListBuffer[Int] = {
      if (root == null) return res
      inorder(root.left)
      res += root.value
      inorder(root.right)
    }
    inorder(root).toList
  }
}
