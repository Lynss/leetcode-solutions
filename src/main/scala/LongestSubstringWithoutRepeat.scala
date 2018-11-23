object LongestSubstringWithoutRepeat extends App {
  def lengthOfLongestSubstring(s: String): Int = {
    val a = s.toList

    def findMaxLength(m: Int, p: List[Char], l: List[Char]): Int = l match {
      case Nil => m
      case x :: xs =>
        val newPrefix = p.drop(p.indexOf(x) + 1) :+ x
        findMaxLength(m max newPrefix.length, newPrefix, xs)
    }

    findMaxLength(0, Nil, a)
  }
  println(lengthOfLongestSubstring("dvdf"))
}
