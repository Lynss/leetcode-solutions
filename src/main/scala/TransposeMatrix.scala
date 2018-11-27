object TransposeMatrix extends App {
  def transpose(A: Array[Array[Int]]): Array[Array[Int]] = {
    A(0).indices.map(col
    => A.map(row => row(col))).toArray
  }

  transpose(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)))
}

