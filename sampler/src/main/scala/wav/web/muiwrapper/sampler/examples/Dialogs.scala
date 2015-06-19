package wav.web.muiwrapper.sampler.examples

import wav.web.muiwrapper.mui._
import japgolly.scalajs.react._, vdom.prefix_<^._
import wav.web.muiwrapper.sampler.Syntax._
import scalajs.js, js.UndefOr._

object Dialogs {

  private val dialogRef = Ref[DialogM]("dialogRef")

  def content = simpleB[Unit]("Dialogs") { (_, b) =>
    <.div(
      // Windows
      RaisedButton(
        label = "Open Dialog",
        onTouchTap = ?(_ => dialogRef.M(b)(_.show))),
      Dialog(
        ref = dialogRef.name,
        onShow = ?(() => log.debug("Opened")),
        onDismiss = ?(() => log.debug("Closed")))
        (<.p(FontIcon("material-icons")("checkbox"), "Works!")),

      // Pickers
      DatePicker(
        hintText = "Portrait Dialog"),
      DatePicker(
        hintText = "Landscape Dialog",
        mode = DatePicker.Mode.portrait))
  }
    .buildU

}
