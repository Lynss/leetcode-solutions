//char to int
val a = '3'
a.toInt
//subString
val b = "123123"
b.substring(0,b.length)
//toInt
val ints = "01321"
ints.splitAt(0)
ints.splitAt(5)
ints.toInt
//sort
ints.sortWith(_.toString.toInt < _.toString.toInt)
//prefixLength
ints.prefixLength(_.toString.toInt <4)
//char add
"a"+'1'
//string tail
"1".tail
//span
ints.span(_.toString.toInt<3)