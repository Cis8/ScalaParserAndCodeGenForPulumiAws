import scalaparser.listmethodsnames.ListMethodsNames
import java.io.File
import java.util.LinkedList
import java.util.Hashtable

@main def hello: Unit = 
  println("Hello world!")

  val projectDir = new File("resources\\ec2");

  val listmethodsnames = ListMethodsNames
  val methodsNames: Hashtable[String, LinkedList[String]] = listmethodsnames.listMethods(projectDir)


