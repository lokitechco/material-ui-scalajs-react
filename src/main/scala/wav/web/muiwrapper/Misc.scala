package wav.web.muiwrapper

import macros.JSObjectConverter._
import scala.scalajs.js
import org.scalajs.dom.{ document, window }
import org.scalajs.dom.html.{Div}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

object Dialog {
  case class Action(text: String, onClick: () => _) {
    val toJs = materializeConverter[Action].apply(this)
  }
  def Ref(refName: String) = new MountedRef[Div, DialogM](refName)
}

case class DialogU(
  ref: Option[String] = None,
  openImmediately: Boolean = false,
  title: Option[String] = None,
  actions: js.Array[Dialog.Action] = js.Array[Dialog.Action](),
  onDismiss: Option[() => _] = None,
  onShow: Option[() => _] = None)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[DialogU] {
  val muiClass = materialUIRefs.mui.Dialog
  val toJs = materializeConverter[DialogU].apply _
}

trait DialogM extends js.Object {
  def show(): Unit = js.native
  def dismiss(): Unit = js.native
}

case class IconU(icon: String)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[IconU] {
  val muiClass = materialUIRefs.mui.Icon
  val toJs = materializeConverter[IconU].apply _
}

case class PaperU(
  circle: Option[Boolean] = None,
  innerClassName: String = "",
  rounded: Boolean = true,
  zDepth: Int = 1)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[PaperU] {
  val muiClass = materialUIRefs.mui.Paper
  val toJs = materializeConverter[PaperU].apply _
}

// TODO: REVIEW
trait Payload extends js.Object {
  val index: Int = js.native
  val data: Option[String] = js.native
}

object MenuItem {
  object Types extends Enumeration {
    val LINK = Value("LINK")
    val SUBHEADER = Value("SUBHEADER")
    val NESTED = Value("NESTED")
  }
}

case class MenuItem(
  text: String,
  payload: Option[String] = None,
  items: js.Array[MenuItem] = js.Array[MenuItem](),
  `type`: MenuItem.Types.Value = MenuItem.Types.LINK,
  attribute: Option[String] = None,
  icon: Option[String] = None,
  data: Option[String] = None,
  toggle: Option[Boolean] = None,
  number: Option[String] = None,
  onClick: Option[(SyntheticMouseEvent[Div], Int) => _] = None,
  onToggle: Option[(SyntheticMouseEvent[Div], Int, Boolean) => _] = None) {
  val toJs: js.Object = materializeConverter[MenuItem].apply(this)
}

object LeftNav {
  def Ref(refName: String) = new MountedRef[Div, LeftNavM](refName)
}

case class LeftNavU(
  menuItems: js.Array[MenuItem],
  ref: Option[String] = None,
  docked: Boolean = false,
  header: Option[Div] = None,
  onChange: Option[(SyntheticMouseEvent[Div], Int, Payload) => _] = None,
  selectedIndex: Option[Int] = None)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[LeftNavU] {
  val muiClass = materialUIRefs.mui.LeftNav
  val toJs = materializeConverter[LeftNavU].apply _
}

trait LeftNavM extends js.Object {
  def close(): Unit = js.native
  def toggle(): Unit = js.native
}