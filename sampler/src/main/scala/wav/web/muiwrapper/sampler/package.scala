package wav.web.muiwrapper

import scalajs.js
import scala.scalajs.js.Dynamic.{global => g}

package object sampler {
  
  private[sampler] def log(o: js.Any) = g.console.log(o)
  
  implicit val materialUIRefs = MaterialUIRefs()
  
}