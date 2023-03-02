package scalaparser.listmethodsnames

import java.io.File
import java.io.IOException
import java.util.Hashtable
import java.util.LinkedList
import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.visitor.VoidVisitorAdapter
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.google.common.base.Strings
import scala.collection.JavaConverters._

object ListMethodsNames {
  def listMethods(projectDir: File): Hashtable[String, LinkedList[String]] = {
    val classes_methods: Hashtable[String, LinkedList[String]] = new Hashtable[String, LinkedList[String]]()

    new DirExplorer((level: Int, path: String, file: File) => path.endsWith("Args.java"), (level: Int, path: String, file: File) => {
      println(path)
      println(Strings.repeat("=", path.length()))

      try {
        new VoidVisitorAdapter[Object]() {
          override def visit(n: ClassOrInterfaceDeclaration, arg: Object): Unit = {
            super.visit(n, arg)

            if(n.getName().toString() == "Builder") {
              val extracted_methods: List[MethodDeclaration] = (n.getMethods()).asScala.toList

              extracted_methods.foreach(x => {
                val cName: String = n.getParentNode.get.getChildNodes.get(2).toString()
                if(!classes_methods.containsKey(x.getName.toString) || !classes_methods.get(x.getName.toString).contains(cName))
                  addToHashtable(x.getName.toString, cName, classes_methods)
              })
            }
          }
        }.visit(StaticJavaParser.parse(file), null)

        println() // empty line
      } catch {
        case e: IOException => throw new RuntimeException(e)
      }
    }).explore(projectDir)

    classes_methods.forEach((k: String, li: LinkedList[String]) => println(k + ": " + classes_methods.get(k).toString))
    classes_methods
  }

  def addToHashtable(key: String, value: String, hashtable: Hashtable[String, LinkedList[String]]): Unit = {
    if(hashtable.containsKey(key)) {
      val list: LinkedList[String] = hashtable.get(key)
      if(!list.contains(value))
        list.add(value)
    } else {
      val list: LinkedList[String] = new LinkedList[String]()
      list.add(value)
      hashtable.put(key, list)
    }
  }
}

