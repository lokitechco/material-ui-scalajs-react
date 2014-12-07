package wav.web.materialui.sampler

import scalajs.js
import org.scalajs.dom
import wav.web.materialui._
import japgolly.scalajs.react._
import vdom.ReactVDom._
import all._

object Samples {

  def icon(target: dom.HTMLDivElement): Unit =
    React.render(
      Icon("action-done")(), target)

  class DialogBackend(T: BackendScope[Unit, Unit]) {
    private val dialog = Mounted[DialogM](Dialog.makeRef("test")) _
    def dismiss(): Unit =
      dialog(T).dismiss
    def show(): Unit =
      dialog(T).show
  }

  type MouseEv = SyntheticMouseEvent[dom.HTMLDivElement]

  val MyDialog = ReactComponentB[Unit]("MyDialog")
    .stateless
    .backend(new DialogBackend(_))
    .render((_, _, B) => {
      div(PaperButton(label = "Open Dialog", onClick = (e: MouseEv) => B.show).apply,
        Dialog(
          ref = "test",
          title = "test",
          onDismiss = () => log("Closed"),
          onShow = () => log("Opened"),
          actions = js.Array(
            Dialog.Action("Cancel", B.dismiss _),
            Dialog.Action("OK", B.dismiss _)))(
            p(Icon("action-done")(), "Works!")))
    })
    .buildU

  def dialog(target: dom.HTMLDivElement): Unit =
    React.render(
      MyDialog(), target)

}