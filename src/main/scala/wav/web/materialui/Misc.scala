package wav.web.materialui

import wav.web.materialui.muimacros.JSObjectConverter._
import scala.scalajs.js
import org.scalajs.dom.{ document, window, HTMLInputElement, HTMLDivElement }
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

object Dialog {
  case class Action(text: String, onClick: () => _) {
    val toJs = materializeConverter[Action].apply(this)
  }
  def Ref(refName: String) = new MountedRef[HTMLDivElement, DialogM](refName)
}

case class DialogU(
  ref: js.UndefOr[String] = js.undefined,
  openImmediately: Boolean = false,
  title: js.UndefOr[String] = js.undefined,
  actions: js.Array[Dialog.Action] = js.Array[Dialog.Action](),
  onDismiss: js.UndefOr[() => _] = js.undefined,
  onShow: js.UndefOr[() => _] = js.undefined)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[DialogU] {
  val muiClass = materialUIRefs.mui.Dialog
  val toJs = materializeConverter[DialogU].apply _
}

trait DialogM extends js.Object {
  def show(): Unit = ???
  def dismiss(): Unit = ???
}

case class IconU(icon: String)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[IconU] {
  val muiClass = materialUIRefs.mui.Icon
  val toJs = materializeConverter[IconU].apply _
}

case class PaperU(
  circle: js.UndefOr[Boolean] = js.undefined,
  innerClassName: String = "",
  rounded: Boolean = true,
  zDepth: Int = 1)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[PaperU] {
  val muiClass = materialUIRefs.mui.Paper
  val toJs = materializeConverter[PaperU].apply _
}

// TODO: REVIEW
trait Payload extends js.Object {
  val index: js.Number
  val data: js.UndefOr[String] // payload?
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
  payload: js.UndefOr[String] = js.undefined,
  items: js.Array[MenuItem] = js.Array[MenuItem](),
  `type`: MenuItem.Types.Value = MenuItem.Types.LINK,
  attribute: js.UndefOr[String] = js.undefined,
  icon: js.UndefOr[String] = js.undefined,
  data: js.UndefOr[String] = js.undefined,
  toggle: js.UndefOr[Boolean] = js.undefined,
  number: js.UndefOr[String] = js.undefined,
  onClick: js.UndefOr[(SyntheticMouseEvent[HTMLDivElement], Int) => _] = js.undefined,
  onToggle: js.UndefOr[(SyntheticMouseEvent[HTMLDivElement], Int, Boolean) => _] = js.undefined) {
  val toJs: js.Object = materializeConverter[MenuItem].apply(this)
}

object LeftNav {
  def Ref(refName: String) = new MountedRef[HTMLDivElement, LeftNavM](refName)
}

case class LeftNavU(
  menuItems: js.Array[MenuItem],
  ref: js.UndefOr[String] = js.undefined,
  docked: Boolean = false,
  header: js.UndefOr[HTMLDivElement] = js.undefined,
  onChange: js.UndefOr[(SyntheticMouseEvent[HTMLDivElement], Int, Payload) => _] = js.undefined,
  selectedIndex: js.UndefOr[js.Number] = js.undefined)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[LeftNavU] {
  val muiClass = materialUIRefs.mui.LeftNav
  val toJs = materializeConverter[LeftNavU].apply _
}

trait LeftNavM extends js.Object {
  def close(): Unit = ???
  def toggle(): Unit = ???
}