object DecodeString extends App {
  def decodeString(s: String): String = {
    val r = """(\d+)\[([^\[\]]*)\]""".r
    var result = s
    while (r.findFirstIn(result).nonEmpty) {
      result = r.replaceAllIn(result, ms => ms.group(2) * ms.group(1).toInt)
    }
    result
  }

  decodeString("3[a]2[bc]")
}
