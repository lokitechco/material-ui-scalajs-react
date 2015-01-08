package wav.web.materialui

import wav.web.materialui.muimacros.JSObjectConverter._
import scala.scalajs.js
import org.scalajs.dom.{ document, window, HTMLInputElement, HTMLDivElement }
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

case class InputU(
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
  onChange: js.UndefOr[SyntheticEvent[HTMLDivElement] => _] = js.undefined)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[InputU] {
  val muiClass = materialUIRefs.mui.Paper
  val toJs = materializeConverter[InputU].apply _
}

object RadioButton {
  def Ref(refName: String) = new MountedRef[HTMLDivElement, RadioButtonM](refName)
}

case class RadioButtonU(
  label: String,
  name: String,
  onClick: js.UndefOr[SyntheticMouseEvent[HTMLDivElement] => _] = js.undefined,
  value: js.UndefOr[String] = js.undefined)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[RadioButtonU] {
  val muiClass = materialUIRefs.mui.RadioButton
  val toJs = materializeConverter[RadioButtonU].apply _
}

trait RadioButtonM extends js.Object {
  def toggle(): Unit = ???
}

case class RaisedButtonU(
  label: String,
  className: js.UndefOr[String] = js.undefined,
  onTouchTap: js.UndefOr[SyntheticTouchEvent[HTMLDivElement] => _] = js.undefined,
  primary: js.UndefOr[Boolean] = js.undefined)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[RaisedButtonU] {
  val muiClass = materialUIRefs.mui.RaisedButton
  val toJs = materializeConverter[RaisedButtonU].apply _
}

case class FlatButtonU(
  label: String,
  className: js.UndefOr[String] = js.undefined,
  onTouchTap: js.UndefOr[SyntheticTouchEvent[HTMLDivElement] => _] = js.undefined,
  primary: js.UndefOr[Boolean] = js.undefined)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[FlatButtonU] {
  val muiClass = materialUIRefs.mui.FlatButton
  val toJs = materializeConverter[FlatButtonU].apply _
}

case class IconButtonU(
  icon: js.UndefOr[String],
  disabled: js.UndefOr[Boolean] = js.undefined,
  className: js.UndefOr[String] = js.undefined,
  onTouchTap: js.UndefOr[SyntheticTouchEvent[HTMLDivElement] => _] = js.undefined)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[IconButtonU] {
  val muiClass = materialUIRefs.mui.IconButton
  val toJs = materializeConverter[IconButtonU].apply _
}

case class EnhancedButtonU(
  className: js.UndefOr[String] = js.undefined,
  disabled: js.UndefOr[Boolean] = js.undefined,
  onFocus: js.UndefOr[SyntheticFocusEvent[HTMLDivElement] => _] = js.undefined,
  onBlur: js.UndefOr[SyntheticFocusEvent[HTMLDivElement] => _] = js.undefined,
  onTouchTap: js.UndefOr[SyntheticTouchEvent[HTMLDivElement] => _] = js.undefined)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[EnhancedButtonU] {
  val muiClass = materialUIRefs.mui.EnhancedButton
  val toJs = materializeConverter[EnhancedButtonU].apply _
}