object FriendsOfAppropriateAges extends App {
  def wontRequestFriend(a: Int, b: Int): Boolean =
    b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100)
  def numFriendRequests(ages: Array[Int]): Int = {
    val a = new Array[Int](121)
    ages.foreach(age => {
      a(age) += 1
    })
    val situations = a.zipWithIndex.filter(_._1 > 0)
    (0 /: situations)((result, situation) => {
      var sum = result
      val (count, age) = situation
      for ((jCount, jAge) <- situations) {
        if (!wontRequestFriend(age, jAge)) {
          val realCount = if (jAge == age) jCount - 1 else jCount
          sum += count * realCount
        }
      }
      sum
    })
  }
}
