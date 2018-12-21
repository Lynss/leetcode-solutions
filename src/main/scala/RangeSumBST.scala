class TreeNode(val value: Int,
               val left: TreeNode = null,
               val right: TreeNode = null)

object TreeNode {
  def unapply(arg: TreeNode): Option[Int] =
    if (arg == null) None else Some(arg.value)
}

object RangeSumBST {
  def rangeSumBST(root: TreeNode, L: Int, R: Int): Int =
    TreeNode.unapply(root) match {
      case Some(value) if value >= L && value <= R =>
        value + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
      case Some(value) if value > R => rangeSumBST(root.left, L, R)
      case Some(value) if value < L => rangeSumBST(root.right, L, R)
      case None                     => 0
    }
}
