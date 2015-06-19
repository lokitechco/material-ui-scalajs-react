package wav.web.muiwrapper.sampler.examples

import wav.web.muiwrapper.mui._
import wav.web.muiwrapper.sampler.Syntax._

object IconsAndInputs {

  @inline def materialIcon(id: String) =
    FontIcon(className = s"material-icons")(id)

  def content = RB.static("Icons", materialIcon("check")).buildU

}
