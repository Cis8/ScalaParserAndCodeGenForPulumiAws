package scalamacro

import scala.quoted.*
import scala.reflect.*
import scala.quoted.quotes
import scalamacro.TypeGenMacro.defineNewType


object TypeGenMacroImpl {
  def defineNewTypeImpl(name: Expr[String], types: Expr[Seq[String]])(using ctx: Quotes) : Expr[Any] = 
      //val typesStr = '{${ types }.mkString(" | ")}
    '{ type $name = String | Boolean }

  /*def getTypeFromName(name: String): Type[_] = {
    val fullName = name.replace('/', '.')
    val classSymbol = Symbol(fullName)
    val classMirror = Reflection.getClass(classSymbol)
    classMirror.tree.asInstanceOf[ClassDef]
      .body.asInstanceOf[Template].parents.head.asInstanceOf[TypeTree].tpe
  }*/
}
