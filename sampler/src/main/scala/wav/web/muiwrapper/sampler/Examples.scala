package wav.web.muiwrapper.sampler

import scalaz.Equal
import scalaz.syntax.equal._
import japgolly.scalajs.react._, vdom.prefix_<^._
import japgolly.scalajs.react.extra._
import japgolly.scalajs.react.extra.router2.{RouterConfigDsl, RouterCtl}
import wav.web.muiwrapper.mui._

import scala.scalajs.js

sealed abstract class Example(val title: String,
  val routerPath: String,
  val render: () => ReactElement)

object Example {

  case object Icons extends Example("Icons", "Icons", () => examples.Icons.content())
  case object Dialogs extends Example("Dialogs", "Dialogs", () => examples.Dialogs.content())

  implicit val equality   : Equal[Example]       = Equal.equalA
  implicit val reusability: Reusability[Example] = Reusability.byEqual

  val values = Vector[Example](Icons, Dialogs)

  def default: Example =
    values.head

  def routes = RouterConfigDsl[Example].buildRule { dsl =>
    import dsl._
    import ExamplesPage._
    values.map(e =>
      staticRoute(e.routerPath, e) ~> renderR(r => component(Props(e, r)))
    ).reduce(_ | _)
  }

}

object ExamplesPage {

  case class Props(current: Example, router: RouterCtl[Example])

  implicit val propsReuse = Reusability.caseclass2(Props.unapply)

  class Backend($: BackendScope[Props, Unit]) {
    def foreach(run: BackendScope[Props, Unit] => Unit) = run($)
  }

  val menuRef = Ref[LeftNavM]("Example menu")

  val menu = ReactComponentB[Props]("Example menu")
    .render { p =>
    LeftNav(
      ref = Some(menuRef.name),
      openRight = true,
      menuItems = Example.values.map { eg =>
        MenuItem(
          text = eg.title,
          payload = p.router.urlFor(eg).value)
      }.toArray)()
  }
    .hackSpec(installMuiContext)
    .configure(Reusability.shouldComponentUpdate)
    .build

//  <.div(
//    "style".reactAttr := js.Dictionary(
//      "float" -> "right",
//      "top" -> "0px",
//      "right" -> "0px",
//      "padding" -> "8px").asInstanceOf[js.Object],
//    IconButton(onTouchTap = handler(_ => menuRef.M(B)(_.toggle)))("menu")())
//    .build

  val component = ReactComponentB[Props]("Examples")
    .stateless
    .backend(new Backend(_))
    .render { (p, _, b) =>
    <.div(
      AppBar(
        title = Some("Components"),
        onLeftIconButtonTouchTap = Some(_ => menuRef.M(b)(_.toggle)))(),
      menu(p),
      p.current.render())
  }.build

}