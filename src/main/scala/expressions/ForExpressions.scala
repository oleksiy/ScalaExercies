package expressions
import java.io.File
/**
  * Created by oblavat on 6/30/17.
  */
object ForExpressions extends App {
  val directoryContents = (new File("/")).listFiles()
  for(i <- directoryContents) {
    println(i)
  }
}
