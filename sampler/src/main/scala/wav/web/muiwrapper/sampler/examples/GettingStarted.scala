package wav.web.muiwrapper.sampler.examples

import wav.web.muiwrapper.mui._
import japgolly.scalajs.react._, vdom.prefix_<^._
import wav.web.muiwrapper.sampler.{CodeBlock, Syntax}, Syntax._
import scalajs.js, js.UndefOr._

object GettingStarted {

  val codeBlock = CodeBlock.content

  val gettingStarted = """
                         | import wav.web.muiwrapper.mui._
                         | ...
                         | muiUniverse.install
                         | ...
                         | ReactComponentB[Unit]("TopLevelComponentWithMui")
                         |   .stateless
                         |   .noBackend
                         |   .hackSpec(installMuiContext)
                         |   .buildU
                         |
                       """.stripMargin

  def content = RB
    .static("GettingStarted", codeBlock.withProps(("scala", gettingStarted))())
    .buildU

}
