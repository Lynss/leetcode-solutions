
object TargetSum extends App {

  // this question is equal to find a sub array P whose element is positive
  // and a sub array N whose element is negative
  // so sum(P) -sum(N) = target
  // sum(P) + sum(N) + sum(P) -sum(N) = target +sum(P) + sum(N)
  // sum(P) = (target + sum(nums))/2
  def findTargetSumWays(nums: Array[Int], S: Int): Int = {
    val sum = nums.sum
    if (sum < S || (sum + S) % 2 != 0) return 0
    //positive integer move right 1 same to divide 2
    val total = (sum + S) >>> 1
    findSubArray(nums, total)

  }
  def findSubArray(nums: Array[Int], s: Int):Int = {
    val dp = Array.fill(s + 1)(0)
    // dp(0) means that the result s  same to the element of n ,so there is at least one sub array that contains only element n
    dp(0) = 1
    nums.foreach(n=> {
      (s to n by -1).foreach(i => {
        dp(i) += dp(i - n)
      })
    })
    dp(s)
  }

  findTargetSumWays(Array(1, 1, 1, 1, 1), 3)
}
