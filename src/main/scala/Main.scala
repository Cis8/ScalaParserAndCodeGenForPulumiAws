import java.io.File
import java.util.LinkedList
import java.util.Hashtable
import codegen.PulumiBuilderUtilFunctionsCodegen.*
import scalaparser.*




@main def hello: Unit = 
  println("Hello world!")
  //currentWorkDir
  //val x: MyType = "ciao"
  val dir: File = new File("resources//ec2")

  

  val methods: Map[String, (String, LinkedList[String])] = InferInformation.listBuilderMethods(dir)

  val files: LinkedList[String] = InferInformation.listFiles(dir)

  //val functionsMethods: Map[String, (String, LinkedList[String])] = ListFunctionMethodsNames.listMethods(dir)

  val functionsMethods: Array[String] = InferInformation.listConstructorMethods(dir)

  //println("num of methods: " + methods.size)
  //println("num of files: " + files.size)
  writeContentForBuilders(files, methods)
  writeContentForConstructors(functionsMethods)

  genTypes(methods)


