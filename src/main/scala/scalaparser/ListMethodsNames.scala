package scalaparser

import java.io.File
import java.io.IOException
import java.util.Hashtable
import java.util.LinkedList
import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.visitor.VoidVisitorAdapter
import com.github.javaparser.ast.body.{ClassOrInterfaceDeclaration, ConstructorDeclaration, MethodDeclaration}
import com.google.common.base.Strings
import com.github.javaparser.ast.expr.SimpleName

import scala.collection.JavaConverters.*



object ListMethodsNames {

  def patternPath(path: String): Boolean =
    path.endsWith("/VpcArgs.java") |
      path.endsWith("/InternetGatewayArgs.java") |
      path.endsWith("/GetAvailabilityZonesArgs.java") |
      path.endsWith("/GetAvailabilityZonesPlainArgs.java") |
      path.endsWith("/SubnetArgs.java") |
      path.endsWith("/RouteTableArgs.java") |
      path.endsWith("/RouteTableRouteArgs.java") |
      path.endsWith("/RouteTableAssociationArgs.java")


  def listFiles(projectDir: File): LinkedList[String] = {
    var arr: LinkedList[String] = LinkedList()
    new DirExplorer((level: Int, path: String, file: File) => patternPath(path), (level: Int, path: String, file: File) => {
      //val startPos: Int = path.lastIndexOf("/")
      println("PTH SUB: " + path.substring(1, path.size - 5).replace("/", "."))
      println(Strings.repeat("=", path.length()))

      arr.add(path.substring(1, path.size - 5).replace("/", "."))
      /*if(!path.contains("inputs") && !path.contains("outputs"))
        arr.add(path.substring(1,path.size-5).replace("/","."))*/
    }).explore(projectDir)
    arr
  }


  def listConstructorMethods(projectDir: File): Array[String] = {
    var constructors: Array[String] = Array.empty

    new DirExplorer((level: Int, path: String, file: File) => !path.endsWith("Args.java") && path.endsWith(".java") && !path.startsWith("/inputs") && !path.startsWith("/outputs") && !path.startsWith("/enum"), (level: Int, path: String, file: File) => {
      println(path)
      println(Strings.repeat("=", path.length()))

      try {
        new VoidVisitorAdapter[Object]() {
          override def visit(n: ClassOrInterfaceDeclaration, arg: Object): Unit = {
            super.visit(n, arg)
            // CUSTOM CODE HERE

            if (!n.getName.toString.contains("Args.java"))
              println("Def cons: " + !n.getConstructors.isEmpty)
              if !n.getConstructors.isEmpty
                then constructors = constructors ++ Array(n.getFullyQualifiedName.get)
              //val extractedMethods: List[ConstructorDeclaration] = n.getConstructors.asScala.toList
              //constructors = constructors ++ extractedMethods.filter(m => m.getName.toString == n.getName.toString).map(m => m.getName.toString())
              println("Constructors found: " + constructors.size)
              /*extractedMethods.foreach(m => {
                val name = m.getName.toString()
                if name == n.getName.toString()
                  then println("It's the builder")
                  else println("Do nothing")
              })*/

            // END CUSTOM CODE
          }
        }.visit(StaticJavaParser.parse(file), null)

        println() // empty line
      } catch {
        case e: IOException => throw new RuntimeException(e)
      }
    }).explore(projectDir)

    //classes_methods.forEach((k: String, li: LinkedList[String]) => println(k + ": " + classes_methods.get(k).toString))
    constructors
  }




  def listBuilderMethods(projectDir: File): Map[String, (String, LinkedList[String])] = {
    var classes_methods: Map[String, (String, LinkedList[String])] = Map[String, (String, LinkedList[String])]()

    new DirExplorer((level: Int, path: String, file: File) => patternPath(path), (level: Int, path: String, file: File) => {
      println(path)
      println(Strings.repeat("=", path.length()))

      try {
        new VoidVisitorAdapter[Object]() {
          override def visit(n: ClassOrInterfaceDeclaration, arg: Object): Unit = {
            super.visit(n, arg)

            if(n.getName().toString() == "Builder") {
              val extracted_methods: List[MethodDeclaration] = (n.getMethods()).asScala.toList

              extracted_methods.foreach(method => {
                val className: String = n.getParentNode.get.getChildNodes.get(2).toString()
                println("Package name:" + n.getFullyQualifiedName.get.split("\\.")(0))
                val fqn = n.getFullyQualifiedName.get
                // if classes_methods doesn't already contain that method or
                if(!classes_methods.contains(method.getName.toString) || !classes_methods.get(method.getName.toString).contains(className))
                {
                  val key = method.getName.toString
                  if (classes_methods.contains(key)) {
                    val list: LinkedList[String] = classes_methods.get(key).get._2
                    if (!list.contains(fqn))
                      list.add(fqn)
                  } else {
                    val list: LinkedList[String] = new LinkedList[String]()
                    list.add(fqn)
                    if (method.getParameters.size() > 0)
                      //val s = method.getParameter(0).resolve().getQualifiedName()
                      //val s = method.getParameter(0).findCompilationUnit().get.getPackageDeclaration().map(pd => pd.getName().toString + ".").orElse("")
                      //val s = method.getParameter(0).getType
                      //val fullyQualifiedName = s.describe();
                      //println("Type: " + method.getParameter(0).getName.getQualifier)
                      classes_methods = classes_methods + (key -> (method.getParameter(0).getTypeAsString, list))
                  }
                }
                  //addToHashtable(x.getName.toString, fqn, classes_methods)
                  //addToHashtable(x.getName.toString, className, classes_methods)
              })
            }
          }
        }.visit(StaticJavaParser.parse(file), null)

        println() // empty line
      } catch {
        case e: IOException => throw new RuntimeException(e)
      }
    }).explore(projectDir)

    //classes_methods.forEach((k: String, li: LinkedList[String]) => println(k + ": " + classes_methods.get(k).toString))
    classes_methods
  }

  /*def addToHashtable(key: String, value: String, hashtable: Map[String, LinkedList[String]]): Unit = {
    if(hashtable.contains(key)) {
      val list: LinkedList[String] = hashtable.get(key).get
      if(!list.contains(value))
        list.add(value)
    } else {
      val list: LinkedList[String] = new LinkedList[String]()
      list.add(value)
      //hashtable = hashtable + (key -> list)
    }
  }*/
}

