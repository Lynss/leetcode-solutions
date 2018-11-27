object MinimumTimeDifference extends App {

  val DAY_MINUTES: Int = 24 * 60

  def compareAsTime(a: String, b: String): Int = {
    val Array(ah, am) = a.split(":")
    val Array(bh, bm) = b.split(":")
    val ami = 60 * ah.toInt + am.toInt
    val bmi = 60 * bh.toInt + bm.toInt
    val tmp = math.abs(ami - bmi)
    if (tmp < DAY_MINUTES - tmp) tmp
    else DAY_MINUTES - tmp
  }

  def findMinDifference(timePoints: List[String]): Int = {
    val n = timePoints.length
    if (n > DAY_MINUTES) return 0
    val timePointsV = timePoints.toArray
    def work(index: Int): Int = {
      (DAY_MINUTES /: (index + 1 until n))((result, i) => {
        val temp = compareAsTime(timePointsV(index), timePointsV(i))
        if (temp < result) temp else result
      })
    }

    timePoints.indices.par.map(i => if (i < n - 1) work(i) else DAY_MINUTES).min
  }
}
