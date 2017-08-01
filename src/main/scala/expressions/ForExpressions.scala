package expressions
import java.io.File

import scala.collection.mutable.ListBuffer

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

  def forNestedLoops:String = {
    val output:StringBuilder = new StringBuilder
    val directoryContents:Array[File] = new File("/Users/oblavat/Documents").listFiles()
    for (
      files <- directoryContents
      if files.isFile;
      if files.getName.endsWith("rtf");
      fileContents <- scala.io.Source.fromFile(files).getLines().toList
    ) {
      output ++= files + "\n"
      output ++= fileContents + "\n"
    }
    output.toString()
  }

  def forBlockExpression:List[String] = {
    val res:ListBuffer[String] = new ListBuffer[String]
    val directoryContents:Array[File] = new File("/").listFiles()
    for {
      file <- directoryContents
      if file.getName.endsWith("e")
      if file.isDirectory
      numFilesInside = file.listFiles().toList.length
    } yield {
      res.append(file.getName)
      res.append(numFilesInside.toString)
    }
    res.toList
  }



  //demo calls to reduce console noise
  println(forDemo)
  println(Console.GREEN + forDemoWithFiltering)
  println(Console.YELLOW + forNestedLoops)
  println(Console.BLUE + forBlockExpression)
}
