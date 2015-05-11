package wav.web.muiwrapper.sampler

import scalajs.js
import org.scalajs.dom, dom.html.{Div}
import wav.web.muiwrapper._
import japgolly.scalajs.react._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

object Samples {

  val IconSample = IconU("action-done").noChildren

  class DialogSampleBackend(T: BackendScope[Unit, Unit]) {
    private val dialogRef = Dialog.Ref("dialogSample--dialog")
    def dismiss = dialogRef(T).dismiss
    def show = dialogRef(T).show
  }

  val DialogSample = ReactComponentB[Unit]("DialogSample")
    .stateless
    .backend(new DialogSampleBackend(_))
    .render((_, _, B) => {
      div(RaisedButtonU(label = "Open Dialog", onTouchTap = Some((e: SyntheticTouchEvent[Div]) => B.show)).noChildren,
        DialogU(
          ref = Some("dialogSample--dialog"),
          title = Some("test"),
          onDismiss = Some(() => log("Closed")),
          onShow = Some(() => log("Opened")),
          actions = js.Array(
            Dialog.Action("Cancel", B.dismiss _),
            Dialog.Action("OK", B.dismiss _)))
          .withChildren(
            p(IconU("action-done").noChildren, "Works!")))
    })
    .buildU
    .apply()

}