package scalamacro

import scala.quoted.*
import scala.reflect.*

object TypeGenMacro {

  inline def defineNewType(inline name: String, inline types: String*): Any =
    ${ TypeGenMacroImpl.defineNewTypeImpl('name, 'types) }

  //def defineNewTypeImpl(ctx: Quotes, name: Expr[String], types: Expr[Seq[String]]) : Expr[Any] = ???


}
