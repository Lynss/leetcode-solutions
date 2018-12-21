import scala.annotation.tailrec

object SymmetricTree {
  def symmetry(left: Option[TreeNode], right: Option[TreeNode]): Boolean =
    (left, right) match {
      case (None, None) => true
      case (Some(leftTree), Some(rightTree)) =>
        leftTree.value == rightTree.value && symmetry(
          Option(leftTree.left),
          Option(rightTree.right)) && symmetry(Option(leftTree.right),
                                               Option(rightTree.left))
      case _ => false
    }
  def isSymmetric(root: TreeNode): Boolean = {
    if (root == null) return true
    symmetry(Option(root.left), Option(root.right))
  }
}
