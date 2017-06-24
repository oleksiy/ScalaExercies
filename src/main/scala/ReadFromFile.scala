import scala.collection.mutable
import scala.io.Source

if (args.length > 0) {
  val outputMap = new mutable.TreeMap[Int, String]
  for(line <- Source.fromFile(args(0)).getLines()) {
    outputMap.put(line.length, line)
  }
  val maximumSpaces = outputMap.keySet.max.toString.length
  outputMap.foreach(e =>
    println(e._1 + (" " * (maximumSpaces - e._1.toString.length))+ "| " + e._2)
  )
} else {
  Console.err.println("Error: Enter a filename.")
}