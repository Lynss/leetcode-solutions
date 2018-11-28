object BestTimeBuyAndSellStock extends App {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.isEmpty) return 0
    ((0, prices.head) /: prices.tail) {
      case ((maxProfix, minPrice), price) =>
        (math.max(maxProfix, price - minPrice), math.min(minPrice, price))
    }._1
  }

  maxProfit(Array(7, 6, 4, 3, 2, 1))
}
