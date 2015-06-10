package wav.web.muiwrapper.sampler

import scala.scalajs.js
import wav.web.muiwrapper.mui._
import japgolly.scalajs.react._, vdom.prefix_<^._

/**
 * All components are roots. All roots require .hackSpec(installMuiContext)
 */
class Sampler(id: String, route: String) {

  lazy val mainRef = Ref[LeftNavM](id)

  val router = new Router(
    route,
    IconSample,
    DialogSample)

  val Main = SimpleB("Main")
    .render((_, _, B) =>
    <.div(
      MuiIconButton("menu")(mainRef.M(B)(_.toggle)),
      LeftNav(
        ref = mainRef,
        menuItems = router.routes.map { r =>
          val (id, link) = r
          MenuItem(text = id, payload = link)
        }.toArray)()
    )).hackSpec(installMuiContext)

  private lazy val IconSample = SimpleB("Icon")
    .render(_ => MuiIcon("check box"))
    .hackSpec(installMuiContext)

  private val dialogRef = Ref[DialogM]("dialogSample--dialog")

  private lazy val DialogSample = SimpleB("Dialog")
    .render((_, _, B) =>
    <.div(
      RaisedButton(
        label = "Open Dialog",
        onTouchTap = handler(dialogRef.M(B)(_.show)))(),
      Dialog(
        ref = dialogRef,
        onShow = Some(() => log("Opened")),
        onDismiss = Some(() => log("Closed")))(<.p(MuiIcon("check box"), "Works!"))
    )).hackSpec(installMuiContext)

}