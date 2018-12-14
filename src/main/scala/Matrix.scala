object Matrix extends App {

  def updateMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val row = matrix.length - 1
    val col = matrix(0).length - 1
    val dp = Array.fill(row + 1, col + 1)(0)

    def findMinLeftTopNeighborCells(i: Int, j: Int): Int = {
      val left = if (i - 1 >= 0) dp(i - 1)(j) + 1 else 10000
      val top = if (j - 1 >= 0) dp(i)(j - 1) + 1 else 10000
      math.min(left, top)
    }

    def findMinRightBottomNeighborCells(i: Int, j: Int): Int = {
      val right = if (i + 1 <= row) dp(i + 1)(j) + 1 else 10000
      val bottom = if (j + 1 <= col) dp(i)(j + 1) + 1 else 10000
      math.min(right, bottom)
    }

    for {
      i <- 0 to row
      j <- 0 to col
    } {
      dp(i)(j) =
        if (matrix(i)(j) == 0) 0
        else math.min(findMinLeftTopNeighborCells(i, j), dp(i)(j))
    }

    for {
      i <- row to 0 by -1
      j <- col to 0 by -1
    } {
      dp(i)(j) =
        if (matrix(i)(j) == 0) 0
        else math.min(findMinRightBottomNeighborCells(i, j), dp(i)(j))
    }
    dp
  }

  updateMatrix(
    Array(Array(0, 1, 0, 1, 1), Array(1, 1, 0, 0, 1), Array(0, 0, 0, 1, 0)))
}
