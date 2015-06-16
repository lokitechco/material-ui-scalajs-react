package wav.web.muiwrapper.sampler.examples

import wav.web.muiwrapper.mui._
import japgolly.scalajs.react._, vdom.prefix_<^._

object Dialogs {

  private val dialogRef = Ref[DialogM]("dialogSample--dialog")

  def content = SimpleB("Dialog")
    .render { (_, _, B) =>
    <.div(
      RaisedButton(
        label = "Open Dialog",
        onTouchTap = handler(dialogRef.M(B)(_.show)))(),
      Dialog(
        ref = Some(dialogRef.name),
        onShow = Some(() => log("Opened")),
        onDismiss = Some(() => log("Closed")))
        (<.p(FontIcon("material icons")("check box"), "Works!"))
    )
  }.buildU

}
