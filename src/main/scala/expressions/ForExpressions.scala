package expressions
import java.io.File

/**
  * Created by oblavat on 6/30/17.
  */
object ForExpressions extends App {

  def forDemo:String = {
    val output:StringBuilder = new StringBuilder
    val directoryContents:Array[File] = new File("/").listFiles()
    for(i <- 0 until directoryContents.length) { //until excludes the last element of the range (0..9 = 0...8)
      output ++= (directoryContents(i) + "\n")
    }
    output.toString()
  }

  def forDemoWithFiltering:String = {
    val output:StringBuilder = new StringBuilder
    val directoryContents:Array[File] = new File("/").listFiles()
    for (fileOrDirectory <- directoryContents if fileOrDirectory.isFile) {
      output ++= (fileOrDirectory + "\n")
    }
    output.toString()
  }


  //demo calls to reduce console noise
  println(forDemo)
  println(Console.GREEN + forDemoWithFiltering)
}
