package wav.web.muiwrapper.mui

import wav.common.scalajs.macros.JS
import japgolly.scalajs.react._
import org.scalajs.dom.Node
import wav.web.muiwrapper.{Mui, Props}

import scala.scalajs.js

case class Action(text: String, onClick: () => Unit) {
  val toJs = JS[Action].apply(this)
}

//√
case class Paper(
  circle: Boolean = false,
  rounded: Boolean = true,
  transitionEnabled: Boolean = true,
  zDepth: Int = 1,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Paper
  val toJs = JS[Paper](this)
}

// Text

//√
trait TextFieldM extends TopNode {
  def blur(): Unit = js.native

  def clearValue(): Unit = js.native

  def focus(): Unit = js.native

  def getValue(): String = js.native

  def setValue(value: String): Unit = js.native

  def setErrorText(error: String): Unit = js.native
}

//√
case class TextField(
  hintText: Option[String] = None,
  errorText: Option[String] = None,
  floatingLabelText: Option[String] = None,
  multiLine: Boolean = false,
  rows: Int = 1,

  onChange: Option[SyntheticEvent[Node] => Unit] = None,
  onKeyDown: Option[SyntheticKeyboardEvent[Node] => Unit] = None,
  onEnterKeyDown: Option[SyntheticKeyboardEvent[Node] => Unit] = None,

  // react
  `type`: Option[String] = None,
  id: Option[String] = None,
  value: Option[String] = None,
  defaultValue: Option[String] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => Unit] = None,
  onBlur: Option[SyntheticFocusEvent[Node] => Unit] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.TextField
  val toJs = JS[TextField](this)
}

// Icons

//√
case class FontIcon(
  className: String,
  hoverColor: Option[String] = None,

  // react
  style: Option[js.Object] = None,
  ref: Option[String] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.FontIcon
  val toJs = JS[FontIcon](this)
}

//√
case class SvgIcon(
  viewBox: Option[String] = None,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.SvgIcon
  val toJs = JS[SvgIcon](this)
}

// Buttons (EnhancedButton)

//case class EnhancedButton(
//  ref: Option[String] = None,
//  touchRippleColor: String,
//  disabled: Boolean,
//  onBlur: Option[SyntheticFocusEvent[Node]=> Unit] = None,
//  onMouseOver: SyntheticMouseEvent[Node]=> Unit,
//  centerRipple: Boolean,
//  disableFocusRipple: Boolean,
//  onTouchTap: SyntheticTouchEvent[Node]=> Unit,
//  style: Option[js.Object] = None,
//  disableTouchRipple: Boolean,
//  linkButton: Boolean,
//  onKeyboardFocus: Option[SyntheticFocusEvent[Node]=> Unit] = None,
//  focusRippleOpacity: Int,
//  className: String,
//  touchRippleOpacity: Int,
//  onMouseOut: SyntheticMouseEvent[Node]=> Unit,
//  onFocus: Option[SyntheticFocusEvent[Node]=> Unit] = None,
//  focusRippleColor: String,
//  keyboardFocused: Boolean)

//√
trait EnhancedButtonM extends TopNode {
  def isKeyboardFocused(): Boolean = js.native
}

//√
case class IconButton(
  className: Option[String] = None,
  iconClassName: Option[String] = None,
  iconStyle: Option[js.Object] = None,
  linkButton: Boolean = false,
  mini: Boolean = true,
  tooltip: Option[String] = None,
  touch: Boolean = false,

  onMouseOut: Option[SyntheticMouseEvent[Node] => Unit] = None,
  onTouchTap: Option[SyntheticTouchEvent[Node] => Unit] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => Unit] = None,

  // react
  disabled: Boolean = false,
  onBlur: Option[SyntheticFocusEvent[Node] => Unit] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => Unit] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.IconButton
  val toJs = JS[IconButton](this)
}

//√
case class FlatButton(
  label: String,
  labelStyle: Option[js.Object] = None,
  iconClassName: Option[js.Object] = None,
  iconStyle: Option[js.Object] = None,
  mini: Boolean = true,
  primary: Boolean = false,
  secondary: Boolean = false,
  linkButton: Boolean = false,
  rippleColor: Option[String] = None,
  hoverColor: Option[String] = None,

  onTouchTap: Option[SyntheticTouchEvent[Node] => Unit] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => Unit] = None,
  onMouseOut: Option[SyntheticMouseEvent[Node] => Unit] = None,

  // react
  disabled: Boolean = false,
  onBlur: Option[SyntheticFocusEvent[Node] => Unit] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => Unit] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.FlatButton
  val toJs = JS[FlatButton](this)
}

//√
case class RaisedButton(
  label: String,
  labelStyle: Option[js.Object] = None,
  iconClassName: Option[js.Object] = None,
  iconStyle: Option[js.Object] = None,
  linkButton: Boolean = false,
  mini: Boolean = true,
  primary: Boolean = false,
  secondary: Boolean = false,

  onTouchTap: Option[SyntheticTouchEvent[Node] => Unit] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => Unit] = None,
  onMouseOut: Option[SyntheticMouseEvent[Node] => Unit] = None,

  // react
  disabled: Boolean = false,
  onBlur: Option[SyntheticFocusEvent[Node] => Unit] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => Unit] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.RaisedButton
  val toJs = JS[RaisedButton](this)
}

//√
case class FloatingActionButton(
  iconClassName: Option[js.Object] = None,
  iconStyle: Option[js.Object] = None,
  linkButton: Boolean = false,
  mini: Boolean = true,
  labelStyle: Option[js.Object] = None,
  secondary: Boolean = false,

  onTouchTap: Option[SyntheticTouchEvent[Node] => Unit] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => Unit] = None,
  onMouseOut: Option[SyntheticMouseEvent[Node] => Unit] = None,

  // react
  disabled: Boolean = false,
  onBlur: Option[SyntheticFocusEvent[Node] => Unit] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => Unit] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.FloatingActionButton
  val toJs = JS[FloatingActionButton](this)
}

// Switches

object EnhancedSwitch {
  type OnChange = (SyntheticEvent[Node], Boolean) => Unit
}

trait EnhancedSwitchM extends TopNode {
  def isSwitched(): Boolean = js.native

  def setSwitched(switched: Boolean): Unit = js.native

  def getValue(): Boolean = js.native

  def isKeyboardFocused(): Boolean = js.native
}

//√
trait CheckboxM extends EnhancedSwitchM {
  def isChecked(): Boolean = js.native

  def setChecked(checked: Boolean): Unit = js.native
}

object HorizontalPosition extends Enumeration {
  val left = Value
  val right = Value
}

//√
case class Checkbox(
  label: Option[String] = None,
  labelPosition: HorizontalPosition.Value = HorizontalPosition.right,
  defaultChecked: Boolean = false,
  iconStyle: Option[js.Object] = None,

  onCheck: Option[EnhancedSwitch.OnChange] = None,

  // react
  name: Option[String] = None,
  value: Option[String] = None,
  style: Option[js.Object] = None,
  ref: Option[String] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Checkbox
  val toJs = JS[Checkbox](this)
}


trait RadioButtonM extends EnhancedSwitchM {
  def isChecked(): Boolean = js.native

  def setChecked(checked: Boolean): Unit = js.native
}

//√
case class RadioButton(
  label: Option[String] = None,
  labelPosition: HorizontalPosition.Value = HorizontalPosition.right,
  defaultChecked: Boolean = false,
  iconStyle: Option[js.Object] = None,
  onCheck: Option[EnhancedSwitch.OnChange] = None,

  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.RadioButton
  val toJs = JS[RadioButton](this)
}

trait RadioButtonGroupM extends TopNode {
  def getSelectedValue(): js.UndefOr[String] = js.native

  def setSelectedValue(value: String): Unit = js.native

  def clearValue(): Unit = js.native
}

//√
case class RadioButtonGroup(
  name: String,

  valueSelected: Option[String] = None,
  defaultSelected: Option[String] = None,
  labelPosition: HorizontalPosition.Value = HorizontalPosition.right,
  onChange: Option[EnhancedSwitch.OnChange] = None,

  ref: Option[String] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.RadioButtonGroup
  val toJs = JS[RadioButtonGroup](this)
}

trait ToggleM extends TopNode {
  def isToggled(): Boolean = js.native

  def setToggled(toggled: Boolean): Unit = js.native
}

//√
case class Toggle(
  defaultToggled: Boolean = false,
  elementStyle: Option[js.Object] = None,
  label: Option[String] = None,
  labelPosition: HorizontalPosition.Value = HorizontalPosition.right,

  onToggle: Option[EnhancedSwitch.OnChange] = None,

  // react
  name: Option[String] = None,
  value: Option[String] = None,
  style: Option[js.Object] = None,
  ref: Option[String] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Toggle
  val toJs = JS[Toggle](this)
}

// Dialogs

//√
trait DialogM extends TopNode {
  def show(): Unit = js.native

  def dismiss(): Unit = js.native
}

//√
case class Dialog(
  actions: Array[Action] = Array.empty,
  actionFocus: Option[String] = None,
  contentClassName: Option[String] = None,
  contentInnerStyle: Option[js.Object] = None,
  contentStyle: Option[js.Object] = None,
  openImmediately: Boolean = false,
  modal: Boolean = false,
  title: Option[String] = None,
  repositionOnUpdate: Boolean = true,

  onShow: Option[() => Unit] = None,
  onDismiss: Option[() => Unit] = None,
  onClickAway: Option[() => Unit] = None,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Dialog
  val toJs = JS[Dialog](this)
}

object DatePicker {

  object Mode extends Enumeration {
    val portrait = Value
    val landscape = Value
  }

}

trait DatePickerM extends DialogM {
  def getDate(): js.Date = js.native

  def setDate(d: js.Date): Unit = js.native
}

case class DatePicker(
  mode: DatePicker.Mode.Value = DatePicker.Mode.portrait,
  initialDate: Option[js.Date] = None,
  formatDate: Option[String] = None,
  minDate: Option[js.Date] = None,
  maxDate: Option[js.Date] = None,
  shouldDisableDate: Option[js.Date => Boolean] = None, // day => Boolean
  hideToolbarYearChange: Boolean = false,
  showYearSelector: Boolean = false,
  autoOk: Boolean = false,

  actions: Array[Action] = Array.empty,
  actionFocus: Option[String] = None,
  contentClassName: Option[String] = None,
  contentInnerStyle: Option[js.Object] = None,
  contentStyle: Option[js.Object] = None,
  openImmediately: Boolean = false,
  modal: Boolean = false,
  title: Option[String] = None,
  repositionOnUpdate: Boolean = true,

  onAccept: Option[() => Unit] = None,
  onShow: Option[() => Unit] = None,
  onDismiss: Option[() => Unit] = None,
  onClickAway: Option[() => Unit] = None,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.DatePicker
  val toJs = JS[DatePicker](this)
}

// Menus

object Menu {

  trait Item {
    val toJs: js.Object
  }

  object Types extends Enumeration {
    val LINK = Value
    val SUBHEADER = Value
    val NESTED = Value
  }

}

//√
case class Menu(
  text: String,
  menuItems: Array[Menu.Item],

  `type`: Menu.Types.Value = Menu.Types.LINK,
  autoWidth: Boolean = true,
  hidable: Boolean = false,
  visible: Boolean = false,
  zDepth: Int = 1,

  menuItemClassName: Option[String] = None,
  menuItemClassNameSubheader: Option[String] = None,
  menuItemClassNameLink: Option[String] = None,
  menuItemStyle: Option[js.Object] = None,
  menuItemStyleSubheader: Option[js.Object] = None,
  menuItemStyleLink: Option[js.Object] = None,
  selectedIndex: Int = 0,

  onItemTap: Option[(SyntheticEvent[Node], Int, MenuItemM) => Unit] = None,
  onToggle: Option[(SyntheticEvent[Node], Int, Boolean) => Unit] = None, // how do you know what item was toggled? event.target?

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props with Menu.Item {
  private[muiwrapper] val _c = (c: Mui) => c.Menu
  val toJs = JS[Menu](this)

}

trait MenuItemM extends js.Object {
  val payload: String = js.native
  val attribute: js.UndefOr[String] = js.native
  val data: js.UndefOr[String] = js.native
  val number: js.UndefOr[Double] = js.native
}

// √
case class MenuItem(
  text: String,
  payload: String,
  attribute: Option[String] = None,
  data: Option[String] = None,
  number: Option[Double] = None,
  toggle: Boolean = false,
  `type`: Menu.Types.Value = Menu.Types.LINK,

  className: Option[String] = None,
  iconClassName: Option[String] = None,
  iconStyle: Option[js.Object] = None,
  iconRightClassName: Option[String] = None,
  iconRightStyle: Option[String] = None,

  onTouchTap: Option[(SyntheticEvent[Node], Int, MenuItemM) => Unit] = None,
  onToggle: Option[(SyntheticEvent[Node], Int, Boolean) => Unit] = None, // how do you know what item was toggled? event.target?

  // react
  disabled: Boolean = false,
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props with Menu.Item {
  private[muiwrapper] val _c = (c: Mui) => c.MenuItem
  val toJs = JS[MenuItem](this)
}

//√
trait LeftNavM extends TopNode {
  def close(): Unit = js.native

  def toggle(): Unit = js.native
}

case class LeftNav(
  docked: Boolean = true,
  header: Option[String] = None,
  menuItems: Array[MenuItem],
  selectedIndex: Option[Int] = None,
  openRight: Boolean = false,

  onNavOpen: Option[(SyntheticEvent[Node], Int, js.Object /* MenuItems */ ) => Unit] = None,
  onNavClose: Option[js.Function0[Unit]] = None,
  onChange: Option[js.Function0[Unit]] = None,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.LeftNav
  val toJs = JS[LeftNav](this)
}

case class DropDownMenu(
  menuItems: Array[Menu.Item],
  menuItemStyle: Option[js.Object] = None, // the docs say array ?!?
  autoWidth: Option[Boolean] = None,
  selectedIndex: Int = 0,

  onChangeTap: Option[(SyntheticEvent[Node], Int, MenuItemM) => Unit] = None,

  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.DropDownMenu
  val toJs = JS[DropDownMenu](this)
}

// Other

// from Draggable
trait Position extends js.Object {
  val top: Int = js.native
  val left: Int = js.native
}

case class Slider(
  name: String,
  min: Double = 0,
  max: Double = 1,
  step: Option[Double] = None,
  error: Option[String] = None,
  description: Option[String] = None,
  dragging: Boolean = false,

  onChange: Option[(SyntheticFocusEvent[Node], Double) => Unit] = None,

  // react
  defaultValue: Double = 0,
  required: Boolean = true,
  disabled: Boolean = false,
  onFocus: Option[SyntheticFocusEvent[Node] => Unit] = None,
  onBlur: Option[SyntheticFocusEvent[Node] => Unit] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Slider
  val toJs = JS[Slider](this)
}

case class Tooltip(
  label: String,
  className: Option[String] = None,
  touch: Boolean = false,
  show: Boolean = false,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Tooltip
  val toJs = JS[Tooltip](this)
}

case class Snackbar(
  message: String,

  action: Option[String] = None,
  onActionTouchTap: Option[SyntheticTouchEvent[Node] => Unit] = None,
  openOnMount: Boolean = false,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Snackbar
  val toJs = JS[Snackbar](this)
}

class AppCanvas extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.AppCanvas
  val toJs = js.Object()
}

case class AppBar(
  iconClassNameLeft: Option[String] = None,
  iconClassNameRight: Option[String] = None,
  iconStyleRight: Option[js.Object] = None,
  iconElementRight: Option[ReactElement] = None,
  iconElementLeft: Option[ReactElement] = None,
  showMenuIconButton: Boolean = true,
  title: Option[String] = None,
  zDepth: Int = 1,

  onLeftIconButtonTouchTap: Option[SyntheticTouchEvent[Node] => Unit] = None,
  onRightIconButtonTouchTap: Option[SyntheticTouchEvent[Node] => Unit] = None,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.AppBar
  val toJs = JS[AppBar](this)
}


//
//case class Tab(
//  handleTouchTap: SyntheticTouchEvent[Node]=> Unit,
//  style: Option[js.Object] = None,
//  selected: Boolean,
//  width: String,
//  ref: Option[String] = None)

//case class Tabs(
//  ref: Option[String] = None,
//  tabWidth: Int,
//  style: Option[js.Object] = None,
//  initialSelectedIndex: Int
//  // onActive: js.Function[???, Unit] /*???*/
//  )

//case class ToolbarTitle(
//  ref: Option[String] = None,
//  text: String,
//  style: Option[js.Object] = None)
//
//case class Toolbar(
//  ref: Option[String] = None,
//  className: String,
//  style: Option[js.Object] = None)

//
//case class ToolbarGroup(
//  className: String,
//  style: Option[js.Object] = None,
//  ref: Option[String] = None,
//  float: Option[String] = None)
//
//
//case class ToolbarSeparator(
//  ref: Option[String] = None,
//  style: Option[js.Object] = None)
//
//case class BeforeAfterWrapper(
//  ref: Option[String] = None,
//  style: Option[js.Object] = None,
//  afterStyle: js.Object,
//  beforeStyle: js.Object,
//  afterElementType: Option[String] = None,
//  elementType: Option[String] = None,
//  beforeElementType: Option[String] = None)
//
//case class LinearProgress(
//  ref: Option[String] = None,
//  style: Option[js.Object] = None,
//  max: Option[Int] = None,
//  min: Option[Int] = None,
//  value: Option[Int] = None)

//case class CircularProgress(
//  ref: Option[String] = None,
//  style: Option[js.Object] = None,
//  size: Option[Int] = None,
//  min: Option[Int] = None,
//  value: Option[Int] = None,
//  max: Option[Int] = None)
