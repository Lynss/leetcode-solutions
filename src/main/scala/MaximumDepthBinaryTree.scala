object MaximumDepthBinaryTree {
  def maxDepth(root: TreeNode): Int = {
    if (root == null) return 0
    1 + math.max(maxDepth(root.left), maxDepth(root.right))
  }
}
