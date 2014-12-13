package wav.web.materialui

import wav.web.materialui.muimacros.JSObjectConverter._
import scala.scalajs.js
import org.scalajs.dom.{ document, window, HTMLInputElement, HTMLDivElement }
import japgolly.scalajs.react._
import vdom.ReactVDom._
import all._

trait Builder[T] {
  this: T =>
  val muiClass: js.Dynamic
  val toJs: T => js.Object
  def apply(children: ReactNode*): ReactComponentU_ =
    reactJS.createElement(muiClass, toJs(this), children.toJsArray)
      .asInstanceOf[ReactComponentU_]
}

class MountedRef[TElem <: TopNode, TComponent](val refName: String) {
    val ref = Ref[TElem](refName)
    def apply(scope: ComponentScope_M[_]): TComponent =
      ref(scope).asInstanceOf[TComponent]
  }

object Dialog {
  case class Action(text: String, onClick: () => _) {
    val toJs: js.Object =
      js.Dynamic.literal("text" -> text, "onClick" -> onClick)
  }
  def Ref(refName: String) = new MountedRef[HTMLDivElement, DialogM](refName)
}

trait DialogM extends js.Object {
  def show(): Unit = ???
  def dismiss(): Unit = ???
}

case class Dialog(
  ref: js.UndefOr[String] = js.undefined,
  openImmediately: Boolean = false,
  title: js.UndefOr[String] = js.undefined,
  actions: js.Array[Dialog.Action] = js.Array[Dialog.Action](),
  onDismiss: js.UndefOr[() => _] = js.undefined,
  onShow: js.UndefOr[() => _] = js.undefined) extends Builder[Dialog] {
  val muiClass = mui.Dialog
  val toJs = materializeConverter[Dialog].apply _
}

case class Icon(icon: String) extends Builder[Icon] {
  val muiClass = mui.Icon
  val toJs = materializeConverter[Icon].apply _
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
  zDepth: Int = 1) extends Builder[Paper] {
  val muiClass = mui.Paper
  val toJs = materializeConverter[Paper].apply _
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
  ) extends Builder[PaperButton] {
  val muiClass = mui.PaperButton
  val toJs = materializeConverter[PaperButton].apply _
}

