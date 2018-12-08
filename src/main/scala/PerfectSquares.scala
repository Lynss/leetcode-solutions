object PerfectSquares extends App {
  def numSquares(n: Int): Int = {
    val dp: Array[Int] = Array.fill(n + 1)(Int.MaxValue)
    dp(0) = 0
    (1 to n).foreach(i => {
      (1 to math.sqrt(i).toInt).foreach(j => {
        dp(i) = math.min(dp(i), dp(i - math.pow(j, 2).toInt) + 1)
      })
    })
    dp(n)
  }
  numSquares(12)
}
