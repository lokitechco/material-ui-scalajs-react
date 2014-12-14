package wav.web.materialui.sampler

import scalajs.js
import org.scalajs.dom
import wav.web.materialui._
import japgolly.scalajs.react._
import vdom.ReactVDom._
import all._
import org.scalajs.dom.HTMLDivElement

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
      div(RaisedButtonU(label = "Open Dialog", onTouchTap = (e: SyntheticTouchEvent[dom.HTMLDivElement]) => B.show).noChildren,
        DialogU(
          ref = "dialogSample--dialog",
          title = "test",
          onDismiss = () => log("Closed"),
          onShow = () => log("Opened"),
          actions = js.Array(
            Dialog.Action("Cancel", B.dismiss _),
            Dialog.Action("OK", B.dismiss _)))
          .withChildren(
            p(IconU("action-done").noChildren, "Works!")))
    })
    .buildU
    .apply()

}