package wav.web.materialui

import scala.scalajs.js
import org.scalajs.dom.{ document, window, HTMLInputElement }

import japgolly.scalajs.react._
import vdom.ReactVDom._
import all._

case class Icon(icon: String) {
  def apply(): ReactComponentU_ =
    mui.Icon(js.Dynamic.literal("icon" -> icon)).asInstanceOf[ReactComponentU_]
}

case class Input(
  `type`: String,
  name: String,
  multiline: js.UndefOr[Boolean] = js.undefined,
  required: js.UndefOr[Boolean] = js.undefined,
  min: js.UndefOr[js.Number] = js.undefined,
  max: js.UndefOr[js.Number] = js.undefined,
  step: js.UndefOr[js.Number] = js.undefined,
  inputStyle: js.UndefOr[String] = js.undefined,
  error: js.UndefOr[js.Number] = js.undefined,
  description: js.UndefOr[js.Number] = js.undefined,
  placeholder: js.UndefOr[js.Number] = js.undefined,
  onChange: js.UndefOr[SyntheticEvent[HTMLInputElement] => Unit] = js.undefined) {

  def toJs: js.Object = {
    val p = js.Dynamic.literal("type" -> `type`, "name" -> name)
    multiline.foreach(v => p.updateDynamic("multiline")(v))
    required.foreach(v => p.updateDynamic("required")(v))
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