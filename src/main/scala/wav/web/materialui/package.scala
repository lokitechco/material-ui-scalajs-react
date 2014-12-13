package wav.web

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}

package object materialui {

  private[materialui] val log = (o: js.Any) => js.Dynamic.global.console.log(o)

  private[materialui] val reactJS = g.React

  private[materialui] val mui = g.mui

}