import scala.io.Source

if(args.length > 0){
  val lines = Source.fromFile(args(0)).getLines()
  val longestLine = lines.reduceLeft((a,b) =>
    if(a.length > b.length)
      a
    else
      b
  )
  println(Console.GREEN + longestLine)
} else {
  Console.err.println("No dice")
}