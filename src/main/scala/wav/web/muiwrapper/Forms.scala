package wav.web.muiwrapper

import macros.JSObjectConverter._
import scala.scalajs.js
import org.scalajs.dom.{ document, window }
import org.scalajs.dom.html.{Div}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

case class InputU(
  name: String,
  `type`: String = "text",
  multiline: Boolean = false,
  required: Boolean = false,
  min: Option[Int] = None,
  max: Option[Int] = None,
  step: Option[Int] = None,
  inputStyle: Option[String] = None,
  error: Option[Int] = None,
  description: Option[Int] = None,
  placeholder: Option[Int] = None,
  onChange: Option[SyntheticEvent[Div] => _] = None)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[InputU] {
  val muiClass = materialUIRefs.mui.Paper
  val toJs = materializeConverter[InputU].apply _
}

object RadioButton {
  def Ref(refName: String) = new MountedRef[Div, RadioButtonM](refName)
}

case class RadioButtonU(
  label: String,
  name: String,
  onClick: Option[SyntheticMouseEvent[Div] => _] = None,
  value: Option[String] = None)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[RadioButtonU] {
  val muiClass = materialUIRefs.mui.RadioButton
  val toJs = materializeConverter[RadioButtonU].apply _
}

trait RadioButtonM extends js.Object {
  def toggle(): Unit = js.native
}

case class RaisedButtonU(
  label: String,
  className: Option[String] = None,
  onTouchTap: Option[SyntheticTouchEvent[Div] => _] = None,
  primary: Option[Boolean] = None)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[RaisedButtonU] {
  val muiClass = materialUIRefs.mui.RaisedButton
  val toJs = materializeConverter[RaisedButtonU].apply _
}

case class FlatButtonU(
  label: String,
  className: Option[String] = None,
  onTouchTap: Option[SyntheticTouchEvent[Div] => _] = None,
  primary: Option[Boolean] = None)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[FlatButtonU] {
  val muiClass = materialUIRefs.mui.FlatButton
  val toJs = materializeConverter[FlatButtonU].apply _
}

case class IconButtonU(
  icon: Option[String],
  disabled: Option[Boolean] = None,
  className: Option[String] = None,
  onTouchTap: Option[SyntheticTouchEvent[Div] => _] = None)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[IconButtonU] {
  val muiClass = materialUIRefs.mui.IconButton
  val toJs = materializeConverter[IconButtonU].apply _
}

case class EnhancedButtonU(
  className: Option[String] = None,
  disabled: Option[Boolean] = None,
  onFocus: Option[SyntheticFocusEvent[Div] => _] = None,
  onBlur: Option[SyntheticFocusEvent[Div] => _] = None,
  onTouchTap: Option[SyntheticTouchEvent[Div] => _] = None)(implicit val materialUIRefs: MaterialUIRefs) extends Builder[EnhancedButtonU] {
  val muiClass = materialUIRefs.mui.EnhancedButton
  val toJs = materializeConverter[EnhancedButtonU].apply _
}