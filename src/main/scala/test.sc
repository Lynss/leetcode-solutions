//regex
val r =
  """(\d+)\[([^\[\]])*\]""".r
val rt = "3[a2[c]]"
r.findAllMatchIn(rt) foreach (a => println(a.group(1), a.group(2)))
"a" * 3
//char to int
val a = '3'
a.toInt
//subString
val b = "123123"
b.substring(0, b.length)
//toInt
val ints = "01321"
ints.splitAt(0)
ints.splitAt(5)
ints.toInt
//sort
ints.sortWith(_.toString.toInt < _.toString.toInt)
//prefixLength
ints.prefixLength(_.toString.toInt < 4)
//char add
"a" + '1'
//string tail
"1".tail
//span
ints.span(_.toString.toInt < 3)
//char reduce
'1' - 48
//intToChar
'0' - 48

new String(Array('1')) == "1"
48.toChar == '0'

//sqrt
math.sqrt(3).toInt

val test = "aa"

1 == 1.00000000000000000000001

//map
val m = Map(1 -> 2)
ints.prefixLength(_.toString.toInt < 4)
//char add
"a" + '1'
//string tail
"1".tail
//span
ints.span(_.toString.toInt < 3)

(0 to 0 by -1) foreach println
