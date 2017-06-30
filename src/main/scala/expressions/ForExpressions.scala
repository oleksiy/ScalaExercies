package expressions
import java.io.File
/**
  * Created by oblavat on 6/30/17.
  */
object ForExpressions extends App {
  val directoryContents = (new File("/")).listFiles()
  for(i <- 0 until directoryContents.length) { //until excludes the last element of the range (0..9 = 0...8)
    println(directoryContents(i))
  }

}
