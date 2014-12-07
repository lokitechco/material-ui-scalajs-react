package wav.web.materialui

import scala.scalajs.js
import org.scalajs.dom.{ document, window, HTMLInputElement, HTMLDivElement }
import japgolly.scalajs.react._
import vdom.ReactVDom._
import all._

object Mounted {
  def apply[T](ref: Ref[_])(scope: ComponentScope_M[_]): T =
    ref(scope).asInstanceOf[T]
}

object Dialog {
  case class Action(text: String, onClick: () => _) {
    def toJs: js.Object =
      js.Dynamic.literal("text" -> text, "onClick" -> onClick)
  }
  def makeRef(id: String) = Ref[HTMLDivElement](id) 
}

trait DialogM extends js.Object {
  def show(): Unit = ???
  def dismiss(): Unit = ???
}

case class Dialog(
  ref: js.UndefOr[String] = js.undefined,
  openImmediately: Boolean = false,
  title: js.UndefOr[String] = js.undefined,
  actions: js.Array[Dialog.Action],
  onDismiss: js.UndefOr[() => _] = js.undefined,
  onShow: js.UndefOr[() => _] = js.undefined) {

  def toJs: js.Object = {
    val p = js.Dynamic.literal(
      "openImmediately" -> openImmediately,
      "actions" -> actions.map((a: Dialog.Action) => a.toJs))
    ref.foreach(v => p.updateDynamic("ref")(v))
    title.foreach(v => p.updateDynamic("title")(v))
    onDismiss.foreach(v => p.updateDynamic("onDismiss")(v))
    onShow.foreach(v => p.updateDynamic("onShow")(v))
    p
  }

  def apply(children: ReactNode*): ReactComponentU_ =
    mui.Dialog(toJs, children.toJsArray).asInstanceOf[ReactComponentU_]

}

case class Icon(icon: String) {
  def apply(): ReactComponentU_ =
    mui.Icon(js.Dynamic.literal("icon" -> icon)).asInstanceOf[ReactComponentU_]
}

case class Input(
  name: String,
  `type`: String = "text",
  multiline: Boolean = false,
  required: Boolean = false,
  min: js.UndefOr[js.Number] = js.undefined,
  max: js.UndefOr[js.Number] = js.undefined,
  step: js.UndefOr[js.Number] = js.undefined,
  inputStyle: js.UndefOr[String] = js.undefined,
  error: js.UndefOr[js.Number] = js.undefined,
  description: js.UndefOr[js.Number] = js.undefined,
  placeholder: js.UndefOr[js.Number] = js.undefined,
  onChange: js.UndefOr[SyntheticEvent[HTMLDivElement]] = js.undefined) {

  def toJs: js.Object = {
    val p = js.Dynamic.literal(
      "type" -> `type`,
      "name" -> name,
      "multiline" -> multiline,
      "type" -> `type`)
    min.foreach(v => p.updateDynamic("min")(v))
    max.foreach(v => p.updateDynamic("max")(v))
    step.foreach(v => p.updateDynamic("step")(v))
    inputStyle.foreach(v => p.updateDynamic("inputStyle")(v))
    error.foreach(v => p.updateDynamic("error")(v))
    description.foreach(v => p.updateDynamic("description")(v))
    placeholder.foreach(v => p.updateDynamic("placeholder")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    p
  }

  def apply(): ReactComponentU_ =
    mui.Input(toJs).asInstanceOf[ReactComponentU_]
}

case class Paper(
  circle: js.UndefOr[Boolean] = js.undefined,
  innerClassName: String = "",
  rounded: Boolean = true,
  zDepth: Int = 1) {

  def toJs: js.Object = {
    val p = js.Dynamic.literal(
      "openImmediately" -> innerClassName,
      "rounded" -> rounded,
      "zDepth" -> zDepth)
    circle.foreach(v => p.updateDynamic("circle")(v))
    p
  }

}

object PaperButton {
  object Types extends Enumeration {
    val FLAT = Value("Flat")
    val RAISED = Value("RAISED")
    val FAB = Value("FAB")
    val FAB_MINI = Value("FAB_MINI")
  }
}

case class PaperButton(
  primary: Boolean = false,
  disabled: Boolean = false,
  href: js.UndefOr[String] = js.undefined,
  label: js.UndefOr[String] = js.undefined,
  `type`: PaperButton.Types.Value = PaperButton.Types.RAISED,
  icon: js.UndefOr[String] = js.undefined,
  onClick: js.UndefOr[SyntheticMouseEvent[HTMLDivElement] => Unit] = js.undefined // div from Paper
  ) {

  def toJs: js.Object = {
    val p = js.Dynamic.literal(
      "primary" -> primary,
      "diabled" -> disabled,
      "type" -> `type`.toString)
    label.foreach(v => p.updateDynamic("label")(v))
    href.foreach(v => p.updateDynamic("href")(v))
    icon.foreach(v => p.updateDynamic("icon")(v))
    onClick.foreach(v => p.updateDynamic("onClick")(v))
    p
  }

  def apply(): ReactComponentU_ =
    mui.PaperButton(toJs).asInstanceOf[ReactComponentU_]

}

