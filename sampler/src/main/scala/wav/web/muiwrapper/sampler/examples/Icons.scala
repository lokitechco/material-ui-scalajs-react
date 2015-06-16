package wav.web.muiwrapper.sampler.examples

import wav.web.muiwrapper.mui._
import japgolly.scalajs.react._

object Icons {

  def content = ReactComponentB[Unit]("Icons example")
    .render(_ => FontIcon("material-icons")("check"))
    .buildU

}
