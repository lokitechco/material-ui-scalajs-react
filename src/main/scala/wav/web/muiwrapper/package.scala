package wav.web

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}

package object muiwrapper {

  private[muiwrapper] val log = (o: js.Any) => js.Dynamic.global.console.log(o)

}