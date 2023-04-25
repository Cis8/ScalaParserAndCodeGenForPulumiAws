package codegen

import java.io.FileWriter
import java.io.File
import java.util.Dictionary
import java.util.Hashtable
import java.util.LinkedList
import scala.jdk.CollectionConverters._
import scala.collection.mutable
//import scala.collection.JavaConverters


object PulumiBuilderUtilFunctionsCodegen {
  def currentWorkDir = System.out.println("Working Directory = " + System.getProperty("user.dir"))
  
  val templateBuilders: FileWriter = new FileWriter(new File("src\\main\\scala\\tmp\\PulumiBuilderUtilFunctions.scala"))
  val templateFunctions: FileWriter = new FileWriter(new File("src\\main\\scala\\tmp\\PulumiFunctionUtilFunctions.scala"))
  def closeBuilderFile(): Unit = templateBuilders.close()
  def closeFunctionFile(): Unit = templateFunctions.close()
  def writeContentForBuilders(files: LinkedList[String], builderTypes: Map[String, (String, LinkedList[String])]) : Unit =
    //println("Text to write: " + JavaConverters.asJavaCollection[String](defaultLibs).toString())
    //println(defaultLibs.mkString(sys.props("line.separator")))
    templateBuilders.append("package com.cisotto.myvpc.function\n\n")
    templateBuilders.append(defaultLibs.mkString("\n"))
    templateBuilders.append("\n\n")
    /*template.append(generatedLibraries(files.asScala.toArray).mkString("\n"))
    template.append("\n\n")*/

    val generatedTypesVal = generatedTypes(builderTypes)
    templateBuilders.append(generatedTypesVal.mkString("\n"))
    templateBuilders.append("\n\n")
    templateBuilders.append("def parent(parent: Resource)(using ob: CustomResourceOptions.Builder): Unit = \n\tob.parent(parent)")
    templateBuilders.append("\n\n")
    templateBuilders.append(implicitConversionFunctions())
    templateBuilders.append("\n\n")
    val generatedBuilderMethodsVal = generatedBuilderMethods(builderTypes)
    templateBuilders.append(generatedBuilderMethodsVal.mkString("\n\n"))
    templateBuilders.append("\n\n")
    closeBuilderFile()

  def writeContentForConstructors(extractedConstructors: Array[String]) : Unit =
    templateFunctions.append("package com.cisotto.myvpc.function\n\n")
    templateFunctions.append(defaultLibs.mkString("\n"))
    templateFunctions.append("\n\n")
    templateFunctions.append("def baseOpts(using o: CustomResourceOptions.Builder) : Unit = {} ")
    templateFunctions.append("\n\n")
    val genCons = generateConstructors(extractedConstructors)
    templateFunctions.append(genCons.mkString("\n\n"))
    templateFunctions.append("\n\n")
    templateFunctions.append("def availabilityZonesNames(): Output[com.pulumi.aws.outputs.GetAvailabilityZonesResult] = com.pulumi.aws.AwsFunctions.getAvailabilityZones(com.pulumi.aws.inputs.GetAvailabilityZonesArgs.builder()\n  .state(\"available\")\n  .build())\n\n")
    templateFunctions.append("def routeTableRouteArgs()(init: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder ?=> Unit): com.pulumi.aws.ec2.inputs.RouteTableRouteArgs =\n  given b: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.builder()\n  init\n  b.build()\n\n")
    println("written all")
    closeFunctionFile()

  // default libraries
  val defaultLibs: Array[String] = Array(
    "import com.pulumi.Context",
    "import com.pulumi.Pulumi",
    "import com.pulumi.core.Output",
    "import com.pulumi.resources.{CustomResourceOptions, Resource}",
    "import scala.collection.JavaConverters._",
    "import collection.convert.ImplicitConversionsToScala.`collection AsScalaIterable`",
    "import scala.compiletime.ops.boolean",
    "import scala.compiletime.ops.string",
    "import scala.language.implicitConversions",
    "import com.pulumi.resources.CustomResourceOptions",
    "import com.pulumi.resources.ResourceArgs",
  )

  def genTypes(builderTypes: Map[String, (String, LinkedList[String])]) : Array[String] = {
    //println("BuilderTypes size: " + builderTypes.size())
    //println("BuilderTypes.keySte() size: " + builderTypes.keySet().size())
    val genTypes: Array[String] = generatedTypes(builderTypes)

    //println("size: " + genTypes.size)
    //genTypes.foreach(e => println(e))
    genTypes
  }

  // auto-generated libraries
  def generatedLibraries(files: Array[String]): Array[String] = {
    //var i: Int = 0

    for k <- files
      yield {
        /*i += 1
        println("Size of the types: " + i)*/
        "import com.pulumi.aws.ec2." + k
      }
  }

  // auto-generated type-definitions
  //def generatedTypes: scala.collection.mutable.Set[String] = generateTypes()

  def generatedTypes(builderTypes: Map[String, (String, LinkedList[String])]): Array[String] = {

    builderTypes.toList match
      case m if m.isEmpty => Array.empty
      case (k -> ts) :: tail =>
        ("type " + k + "Owners = " + builderTypes.get(k.toString)
        .get._2
        .asScala
        .mkString(" | "))
        +: generatedTypes(builderTypes.tail)
        //.map(s => s + ".Builder")

    /*if(!builderTypes.isEmpty)
      val k: String = builderTypes.head._1

      Array("type " + k + "Owners = " + builderTypes.get(k.toString).get.asScala
        //.map(s => s + ".Builder")
        .mkString(" | ")) ++ generatedTypes(builderTypes.tail)
    else
      Array.empty*/
  }

  def generateConstructors(extractedConstructors: Array[String]) : Array[String] =
    for con <- extractedConstructors
      yield {
        val functionName = con.drop(con.lastIndexOf('.') + 1)
        val builderCon = s"${con}Args.Builder";
        val funName = functionName.head.toLower + functionName.tail
        s"def $funName (param: String)(init: $builderCon ?=> Unit, " +
          s"initOpt: (CustomResourceOptions.Builder ?=> Unit) = baseOpts): $con =\n" +
        s"\tgiven b: $builderCon = ${con}Args.builder()\n" +
        "\tinit\n" +
        "\tgiven bo: CustomResourceOptions.Builder = CustomResourceOptions.builder()\n" +
        "\tinitOpt\n" +
        s"\tnew ${con}(param, b.build(), bo.build())"
      }

  // auto-generated methods
  def implicitConversionFunctions(): String =
    "implicit def convertScalaListToJavaList[A](scalaList: List[A]): java.util.List[A] =\n" +
      "\tscalaList\n" +
      "\t.asJava\n\n" +
      "implicit def convertScalaMapToJavaMap[A, B](scalaMap: Map[A, B]): java.util.Map[A, B] =\n" +
      "\tscalaMap\n" +
      "\t.asJava\n\n"+
      "given tupleToMap[A, B]: Conversion[(A, B), Map[A, B]] =\n" +
      "\t(tuple: (A, B)) => Map(tuple)\n\n" +
      "given elemToList[A <: ResourceArgs]: Conversion[A, List[A]] =\n" +
      "\t(elem: A) => List(elem)\n"

  def addAwsInputsPackage(pt: String) : String =
    val x = if pt.contains("java.util.") then "[\\[]".r.replaceAllIn(pt, "\\[com.pulumi.aws.ec2.inputs.") else "com.pulumi.aws.ec2.inputs." + pt
    //if x.contains("java.util.") and x.contains(",") then "[,]".r.replaceAllIn(x, ", com.pulumi.aws.ec2.input.") else x
    x

  def useScalaCollectionInsted(paramType: String) : String =
    if paramType.contains("java.util.") then paramType.drop(10) else paramType

  def generatedBuilderMethods(builderTypes: Map[String, (String, LinkedList[String])]): Array[String] =
    //println("Size of builder types:" + builderTypes.head._2.size)
    if(!builderTypes.isEmpty)
      val k0 : String = builderTypes.head._1
      val k: String = if k0 == "type" then "`type`" else k0
      val paramType: Option[String] = "[<].*[>]".r.findFirstIn(builderTypes.head._2._1)
      val pt: String = if paramType.isDefined then paramType.get.drop(1).dropRight(1).replace("<","[").replace(">","]") else builderTypes.head._2._1
      val pt2: String = if "Map|Array|Dictionary|List".r.findFirstIn(pt).isDefined then "java.util." + pt else pt
      val tmpPt = "Boolean|String|Integer".r.findFirstIn(pt2)
      val pt3: String = if tmpPt.isDefined then pt2.replace(tmpPt.get, "java.lang." + tmpPt.get)  else addAwsInputsPackage(pt2)
      val completePt: String = pt3
      Array("def " + k + "(param: " + useScalaCollectionInsted(completePt) + " | Output[" + completePt + "])(using b: " + k + "Owners): Unit =\n" +
        "\tb match\n" +
        (for t <- builderTypes.head._2._2.asScala
          yield "\t\tcase builder: " + t + " =>\n" +
            "\t\t\tparam match\n" +
            "\t\t\t\tcase x: " + useScalaCollectionInsted(completePt) + " => builder." + k + "(x)\n" +
            "\t\t\t\tcase x: Output[" + completePt + "] => builder." + k + "(x)\n").mkString

      ) ++ (if builderTypes.size > 1 then generatedBuilderMethods(builderTypes.tail) else Array(""))
        /*builderTypes.head._2.forEach(t =>
          println("STRING CREATION: " + "\t\tcase builder: " + t + " =>\n" +
            "\t\t\tparam match\n" +
            "\t\t\t\tcase x: String => builder." + k + "(x)\n" +
            "\t\t\t\tcase x: Output[String] => builder." + k + "(x)\n")
          "\t\tcase builder: " + t + " =>\n" +
              "\t\t\tparam match\n" +
              "\t\t\t\tcase x: String => builder." + k + "(x)\n" +
              "\t\t\t\tcase x: Output[String] => builder." + k + "(x)\n"))*/
    else
      Array.empty
}
