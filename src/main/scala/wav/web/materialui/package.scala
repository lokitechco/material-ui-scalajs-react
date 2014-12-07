package wav.web

import scala.scalajs.js
import js.Dynamic.{global => g}

package object materialui {
  
  private[materialui] val log = (o: js.Any) => js.Dynamic.global.console.log(o)
  
  val mui = g.mui

}