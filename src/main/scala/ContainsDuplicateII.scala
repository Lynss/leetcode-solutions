import scala.annotation.tailrec
import scala.collection.mutable

object ContainsDuplicateII extends App {
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    var result = false
    val mm = mutable.Map[Int, Int]()
    val n = nums.length
    if(n==0)return false
    @tailrec
    def find(i: Int): Unit = {
      if (mm.contains(nums(i))&&math.abs(mm(nums(i)) - i) <= k) {
        result = true
      }else{
        mm(nums(i)) = i
        if (i < n - 1) find(i + 1)
      }
    }

    find(0)
    result
  }
  containsNearbyDuplicate(Array(1,0,1,1),1)
}
