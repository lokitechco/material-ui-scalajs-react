package wav.web.muiwrapper.mui

import wav.common.scalajs.macros.JS
import japgolly.scalajs.react._
import org.scalajs.dom.Node
import wav.web.muiwrapper.{Mui, Props, SimpleProps}

import scala.scalajs.js, js.{Array, Dynamic, Object, UndefOr, undefined, native}

case class Action(
  text: String,
  onClick: () => Unit,
  ref: UndefOr[String] = undefined // if the actionFocus == ref, then the action will be highlighted.
  ) {
  val toJs = JS[Action].apply(this)
}

case class Avatar(
  className: UndefOr[String] = undefined,
  src: UndefOr[String] = undefined,
  //icon={<FileFolder />}
  color: UndefOr[String] = undefined,
  backgroundColor: UndefOr[String] = undefined,

  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Avatar
  val toJs = JS[Avatar](this)
}

class ClearFix() extends SimpleProps {
  private[muiwrapper] val _c = (c: Mui) => c.ClearFix
  val toJs = new Object()
}

//√
case class Paper(
  circle: Boolean = false,
  rounded: Boolean = true,
  transitionEnabled: Boolean = true,
  zDepth: Int = 1,
  className: UndefOr[String] = undefined,

  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Paper
  val toJs = JS[Paper](this)
}


// Text

//√
trait TextFieldM extends TopNode {
  def blur(): Unit = native

  def clearValue(): Unit = native

  def focus(): Unit = native

  def getValue(): String = native

  def setValue(value: String): Unit = native

  def setErrorText(error: String): Unit = native
}

//√
case class TextField(
  hintText: UndefOr[String] = undefined,
  errorText: UndefOr[String] = undefined,
  floatingLabelText: UndefOr[String] = undefined,
  multiLine: Boolean = false,
  rows: Int = 1,
  fullWidth: UndefOr[Boolean] = undefined,
  inputStyle: UndefOr[Object] = undefined,
  floatingLabelStyle: UndefOr[Object] = undefined,

  onChange: UndefOr[SyntheticEvent[Node] => Unit] = undefined,
  onKeyDown: UndefOr[SyntheticKeyboardEvent[Node] => Unit] = undefined,
  onEnterKeyDown: UndefOr[SyntheticKeyboardEvent[Node] => Unit] = undefined,

  // react
  `type`: UndefOr[String] = undefined,
  id: UndefOr[String] = undefined,
  value: UndefOr[String] = undefined,
  defaultValue: UndefOr[String] = undefined,
  onFocus: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  onBlur: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.TextField
  val toJs = JS[TextField](this)
}

// Icons

//√
case class FontIcon(
  className: String,
  hoverColor: UndefOr[String] = undefined,

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.FontIcon
  val toJs = JS[FontIcon](this)
}

//√
case class SvgIcon(
  viewBox: UndefOr[String] = undefined,

  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.SvgIcon
  val toJs = JS[SvgIcon](this)
}

// Buttons (EnhancedButton)

//case class EnhancedButton(
//  key: UndefOr[String] = undefined,
//  ref: UndefOr[String] = undefined,
//  touchRippleColor: String,
//  disabled: Boolean,
//  onBlur: UndefOr[SyntheticFocusEvent[Node]=> Unit] = undefined,
//  onMouseOver: SyntheticMouseEvent[Node]=> Unit,
//  centerRipple: Boolean,
//  disableFocusRipple: Boolean,
//  onTouchTap: SyntheticTouchEvent[Node]=> Unit,
//  style: UndefOr[Object] = undefined,
//  disableTouchRipple: Boolean,
//  linkButton: Boolean,
//  onKeyboardFocus: UndefOr[SyntheticFocusEvent[Node]=> Unit] = undefined,
//  focusRippleOpacity: Int,
//  className: String,
//  touchRippleOpacity: Int,
//  onMouseOut: SyntheticMouseEvent[Node]=> Unit,
//  onFocus: UndefOr[SyntheticFocusEvent[Node]=> Unit] = undefined,
//  focusRippleColor: String,
//  keyboardFocused: Boolean)

//√
trait EnhancedButtonM extends TopNode {
  def isKeyboardFocused(): Boolean = native
}

//√
case class IconButton(
  className: UndefOr[String] = undefined,
  iconClassName: UndefOr[String] = undefined,
  iconLigature: UndefOr[String] = undefined,
  iconStyle: UndefOr[Object] = undefined,
  linkButton: Boolean = false,
  mini: Boolean = true,
  tooltip: UndefOr[String] = undefined,
  touch: Boolean = false,
  href: UndefOr[String] = undefined,

  onMouseOut: UndefOr[SyntheticMouseEvent[Node] => Unit] = undefined,
  onTouchTap: UndefOr[SyntheticTouchEvent[Node] => Unit] = undefined,
  onMouseOver: UndefOr[SyntheticMouseEvent[Node] => Unit] = undefined,

  // react
  disabled: Boolean = false,
  onBlur: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  onFocus: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.IconButton
  val toJs = JS[IconButton](this)
}

//√
case class FlatButton(
  label: String,
  labelStyle: UndefOr[Object] = undefined,
  iconClassName: UndefOr[Object] = undefined,
  iconStyle: UndefOr[Object] = undefined,
  mini: Boolean = true,
  primary: Boolean = false,
  secondary: Boolean = false,
  linkButton: Boolean = false,
  rippleColor: UndefOr[String] = undefined,
  hoverColor: UndefOr[String] = undefined,

  onTouchTap: UndefOr[SyntheticTouchEvent[Node] => Unit] = undefined,
  onMouseOver: UndefOr[SyntheticMouseEvent[Node] => Unit] = undefined,
  onMouseOut: UndefOr[SyntheticMouseEvent[Node] => Unit] = undefined,

  // react
  disabled: Boolean = false,
  onBlur: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  onFocus: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.FlatButton
  val toJs = JS[FlatButton](this)
}

//√
case class RaisedButton(
  label: String,
  labelStyle: UndefOr[Object] = undefined,
  iconClassName: UndefOr[Object] = undefined,
  iconStyle: UndefOr[Object] = undefined,
  linkButton: Boolean = false,
  mini: Boolean = true,
  primary: Boolean = false,
  secondary: Boolean = false,

  onTouchTap: UndefOr[SyntheticTouchEvent[Node] => Unit] = undefined,
  onMouseOver: UndefOr[SyntheticMouseEvent[Node] => Unit] = undefined,
  onMouseOut: UndefOr[SyntheticMouseEvent[Node] => Unit] = undefined,

  // react
  disabled: Boolean = false,
  onBlur: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  onFocus: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.RaisedButton
  val toJs = JS[RaisedButton](this)
}

//√
case class FloatingActionButton(
  iconClassName: UndefOr[Object] = undefined,
  iconStyle: UndefOr[Object] = undefined,
  linkButton: Boolean = false,
  mini: Boolean = true,
  labelStyle: UndefOr[Object] = undefined,
  secondary: Boolean = false,

  onTouchTap: UndefOr[SyntheticTouchEvent[Node] => Unit] = undefined,
  onMouseOver: UndefOr[SyntheticMouseEvent[Node] => Unit] = undefined,
  onMouseOut: UndefOr[SyntheticMouseEvent[Node] => Unit] = undefined,

  // react
  disabled: Boolean = false,
  onBlur: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  onFocus: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.FloatingActionButton
  val toJs = JS[FloatingActionButton](this)
}

// Switches

object EnhancedSwitch {
  type OnChange = (SyntheticEvent[Node], Boolean) => Unit
}

trait EnhancedSwitchM extends TopNode {
  def isSwitched(): Boolean = native

  def setSwitched(switched: Boolean): Unit = native

  def getValue(): Boolean = native

  def isKeyboardFocused(): Boolean = native
}

//√
trait CheckboxM extends EnhancedSwitchM {
  def isChecked(): Boolean = native

  def setChecked(checked: Boolean): Unit = native
}

object HorizontalPosition extends Enumeration {
  val left  = Value
  val right = Value
}

//√
case class Checkbox(
  label: UndefOr[String] = undefined,
  labelPosition: HorizontalPosition.Value = HorizontalPosition.right,
  defaultChecked: Boolean = false,
  iconStyle: UndefOr[Object] = undefined,
  checkedIcon: UndefOr[ReactElement] = undefined,
  unCheckedIcon: UndefOr[ReactElement] = undefined,

  onCheck: UndefOr[EnhancedSwitch.OnChange] = undefined,

  // react
  name: UndefOr[String] = undefined,
  value: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Checkbox
  val toJs = JS[Checkbox](this)
}


trait RadioButtonM extends EnhancedSwitchM {
  def isChecked(): Boolean = native

  def setChecked(checked: Boolean): Unit = native
}

//√
case class RadioButton(
  label: UndefOr[String] = undefined,
  labelPosition: HorizontalPosition.Value = HorizontalPosition.right,
  defaultChecked: Boolean = false,
  iconStyle: UndefOr[Object] = undefined,
  onCheck: UndefOr[EnhancedSwitch.OnChange] = undefined,

  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.RadioButton
  val toJs = JS[RadioButton](this)
}

trait RadioButtonGroupM extends TopNode {
  def getSelectedValue(): UndefOr[String] = native

  def setSelectedValue(value: String): Unit = native

  def clearValue(): Unit = native
}

//√
case class RadioButtonGroup(
  name: String,

  valueSelected: UndefOr[String] = undefined,
  defaultSelected: UndefOr[String] = undefined,
  labelPosition: HorizontalPosition.Value = HorizontalPosition.right,
  onChange: UndefOr[EnhancedSwitch.OnChange] = undefined,

  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.RadioButtonGroup
  val toJs = JS[RadioButtonGroup](this)
}

trait ToggleM extends TopNode {
  def isToggled(): Boolean = native

  def setToggled(toggled: Boolean): Unit = native
}

//√
case class Toggle(
  defaultToggled: Boolean = false,
  elementStyle: UndefOr[Object] = undefined,
  label: UndefOr[String] = undefined,
  labelPosition: HorizontalPosition.Value = HorizontalPosition.right,

  onToggle: UndefOr[EnhancedSwitch.OnChange] = undefined,

  // react
  name: UndefOr[String] = undefined,
  value: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Toggle
  val toJs = JS[Toggle](this)
}

// Dialogs

//√
trait DialogM extends TopNode {
  def show(): Unit = native

  def dismiss(): Unit = native
}

//√
case class Dialog(
  actions: Array[Action] = new Array(),
  actionFocus: UndefOr[String] = undefined,
  contentClassName: UndefOr[String] = undefined,
  contentInnerStyle: UndefOr[Object] = undefined,
  contentStyle: UndefOr[Object] = undefined,
  openImmediately: Boolean = false,
  modal: Boolean = false,
  title: UndefOr[String] = undefined,
  repositionOnUpdate: Boolean = true,

  onShow: UndefOr[() => Unit] = undefined,
  onDismiss: UndefOr[() => Unit] = undefined,
  onClickAway: UndefOr[() => Unit] = undefined,

  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Dialog
  val toJs = JS[Dialog](this)
}

object DatePicker {

  object Mode extends Enumeration {
    val portrait  = Value
    val landscape = Value
  }

}

trait DatePickerM extends DialogM {
  def getDate(): js.Date = native

  def setDate(d: js.Date): Unit = native
}

case class DatePicker(
  hintText: UndefOr[String] = undefined,
  mode: DatePicker.Mode.Value = DatePicker.Mode.portrait,
  initialDate: UndefOr[js.Date] = undefined,
  formatDate: UndefOr[String] = undefined,
  minDate: UndefOr[js.Date] = undefined,
  maxDate: UndefOr[js.Date] = undefined,
  shouldDisableDate: UndefOr[js.Date => Boolean] = undefined, // day => Boolean
  hideToolbarYearChange: Boolean = false,
  showYearSelector: Boolean = false,
  autoOk: Boolean = false,

  actions: Array[Action] = new Array(),
  actionFocus: UndefOr[String] = undefined,
  contentClassName: UndefOr[String] = undefined,
  contentInnerStyle: UndefOr[Object] = undefined,
  contentStyle: UndefOr[Object] = undefined,
  openImmediately: Boolean = false,
  modal: Boolean = false,
  title: UndefOr[String] = undefined,
  repositionOnUpdate: Boolean = true,

  onAccept: UndefOr[() => Unit] = undefined,
  onShow: UndefOr[() => Unit] = undefined,
  onDismiss: UndefOr[() => Unit] = undefined,
  onClickAway: UndefOr[() => Unit] = undefined,

  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.DatePicker
  val toJs = JS[DatePicker](this)
}

// Menus

object Menu {

  abstract class Item {
    val toJs: Object
  }

}

//√
case class Menu(
  text: String,
  menuItems: Array[Menu.Item],

  autoWidth: Boolean = true,
  visible: Boolean = true,
  zDepth: Int = 1,
  rounded: UndefOr[Boolean] = undefined,

  menuItemClassName: UndefOr[String] = undefined,
  menuItemClassNameSubheader: UndefOr[String] = undefined,
  menuItemClassNameLink: UndefOr[String] = undefined,
  menuItemStyle: UndefOr[Object] = undefined,
  menuItemStyleSubheader: UndefOr[Object] = undefined,
  menuItemStyleLink: UndefOr[Object] = undefined,
  selectedIndex: UndefOr[Int] = undefined,

  onItemTap: UndefOr[(SyntheticEvent[Node], Int, MenuItemM) => Unit] = undefined,
  onToggle: UndefOr[(SyntheticEvent[Node], Int, Boolean) => Unit] = undefined, // how do you know what item was toggled? event.target?

  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Menu
  val toJs = JS[Menu](this)

}

trait MenuItemM extends Object {
  val payload  : String          = native
  val attribute: UndefOr[String] = native
  val data     : UndefOr[String] = native
  val number   : UndefOr[Double] = native
}

// √
case class MenuItem(
  text: String,
  payload: UndefOr[String] = undefined,
  attribute: UndefOr[String] = undefined,
  data: UndefOr[String] = undefined,
  number: UndefOr[Double] = undefined,
  toggle: Boolean = false,

  className: UndefOr[String] = undefined,
  iconClassName: UndefOr[String] = undefined,
  iconStyle: UndefOr[Object] = undefined,
  iconRightClassName: UndefOr[String] = undefined,
  iconRightStyle: UndefOr[String] = undefined,

  onTouchTap: UndefOr[(SyntheticEvent[Node], Int, MenuItemM) => Unit] = undefined,
  onToggle: UndefOr[(SyntheticEvent[Node], Int, Boolean) => Unit] = undefined, // how do you know what item was toggled? event.target?

  // react
  disabled: Boolean = false,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Menu.Item with Props {
  private[muiwrapper] val _c = (c: Mui) => c.Menu
  val toJs = JS[MenuItem](this)
}

case class NestedMenuItem(
  text: String,
  items: Array[Menu.Item],
  menuItemStyle: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Menu.Item with Props {
  private[muiwrapper] val _c = (c: Mui) => c.Menu
  val toJs: Object = {
    val o = JS[NestedMenuItem](this).asInstanceOf[Dynamic with Object]
    o.updateDynamic("type")("NESTED")
    o
  }
}

//√
trait LeftNavM extends TopNode {
  def close(): Unit = native

  def open(): Unit = native

  def toggle(): Unit = native
}

case class LeftNav(
  docked: Boolean = true,
  header: UndefOr[ReactElement] = undefined,
  menuItems: Array[MenuItem],
  selectedIndex: UndefOr[Int] = undefined,
  openRight: Boolean = false,
  isInitaillyOpen: Boolean = true,

  onNavOpen: UndefOr[(SyntheticEvent[Node], Int, Object /* MenuItems */ ) => Unit] = undefined,
  onNavClose: UndefOr[() => Unit] = undefined,
  onChange: UndefOr[() => Unit] = undefined,

  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.LeftNav
  val toJs = JS[LeftNav](this)
}

case class DropDownMenu(
  menuItems: Array[Menu.Item],
  menuItemStyle: UndefOr[Object] = undefined, // the docs say array ?!?
  autoWidth: UndefOr[Boolean] = undefined,
  selectedIndex: Int = 0,

  onChangeTap: UndefOr[(SyntheticEvent[Node], Int, MenuItemM) => Unit] = undefined,

  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.DropDownMenu
  val toJs = JS[DropDownMenu](this)
}

// Other

// from Draggable
trait Position extends Object {
  val top : Int = native
  val left: Int = native
}

case class Slider(
  name: String,
  min: Double = 0,
  max: Double = 1,
  step: UndefOr[Double] = undefined,
  error: UndefOr[String] = undefined,
  description: UndefOr[String] = undefined,
  dragging: Boolean = false,

  onChange: UndefOr[(SyntheticFocusEvent[Node], Double) => Unit] = undefined,

  // react
  defaultValue: Double = 0,
  required: Boolean = true,
  disabled: Boolean = false,
  onFocus: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  onBlur: UndefOr[SyntheticFocusEvent[Node] => Unit] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Slider
  val toJs = JS[Slider](this)
}

case class Tooltip(
  label: String,
  className: UndefOr[String] = undefined,
  touch: Boolean = false,
  show: Boolean = false,

  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Tooltip
  val toJs = JS[Tooltip](this)
}

case class Snackbar(
  message: String,

  action: UndefOr[String] = undefined,
  onActionTouchTap: UndefOr[SyntheticTouchEvent[Node] => Unit] = undefined,
  openOnMount: Boolean = false,

  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Snackbar
  val toJs = JS[Snackbar](this)
}

case class AppCanvas(
  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.AppCanvas
  val toJs = Object()
}

case class AppBar(
  iconClassNameLeft: UndefOr[String] = undefined,
  iconClassNameRight: UndefOr[String] = undefined,
  iconStyleRight: UndefOr[Object] = undefined,
  iconElementRight: UndefOr[ReactElement] = undefined,
  iconElementLeft: UndefOr[ReactElement] = undefined,
  showMenuIconButton: Boolean = true,
  title: UndefOr[String] = undefined,
  zDepth: Int = 1,

  onLeftIconButtonTouchTap: UndefOr[SyntheticTouchEvent[Node] => Unit] = undefined,
  onRightIconButtonTouchTap: UndefOr[SyntheticTouchEvent[Node] => Unit] = undefined,

  // react
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined,
  style: UndefOr[Object] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.AppBar
  val toJs = JS[AppBar](this)
}

case class Tab(
  selected: UndefOr[Boolean],
  handleTouchTap: UndefOr[SyntheticTouchEvent[Node] => Unit] = undefined,
  width: UndefOr[String],

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Tab
  val toJs = JS[Tab](this)
}

case class Tabs(initialSelectedIndex: Int,
  tabWidth: UndefOr[Int] = undefined,
  onActive: UndefOr[Object => Unit] = undefined,

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Tabs
  val toJs = JS[Tabs](this)
}

case class ToolbarTitle(
  text: String,

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.ToolbarTitle
  val toJs = JS[ToolbarTitle](this)
}

case class Toolbar(
  className: String,

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.Toolbar
  val toJs = JS[Toolbar](this)
}

case class ToolbarGroup(
  className: String,
  float: UndefOr[String] = undefined,

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.ToolbarGroup
  val toJs = JS[ToolbarGroup](this)
}

case class ToolbarSeparator(
  style: UndefOr[Object] = undefined) extends SimpleProps {
  private[muiwrapper] val _c = (c: Mui) => c.ToolbarSeparator
  val toJs = JS[ToolbarSeparator](this)
}

case class BeforeAfterWrapper(
  afterStyle: UndefOr[Object] = undefined,
  beforeStyle: UndefOr[Object] = undefined,
  afterElementType: UndefOr[String] = undefined,
  elementType: UndefOr[String] = undefined,
  beforeElementType: UndefOr[String] = undefined,

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.BeforeAfterWrapper
  val toJs = JS[BeforeAfterWrapper](this)
}

case class LinearProgress(
  max: UndefOr[Int] = undefined,
  min: UndefOr[Int] = undefined,
  value: UndefOr[Int] = undefined,

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.LinearProgress
  val toJs = JS[LinearProgress](this)
}

case class CircularProgress(
  max: UndefOr[Int] = undefined,
  min: UndefOr[Int] = undefined,
  value: UndefOr[Int] = undefined,

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.CircularProgress
  val toJs = JS[CircularProgress](this)
}

case class List(
  insetSubheader: UndefOr[Boolean] = undefined,
  subheader: UndefOr[String] = undefined,
  // subheader: UndefOr[ReactElement] = undefined,
  subheaderStyle: UndefOr[Object] = undefined,

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  private[muiwrapper] val _c = (c: Mui) => c.List
  val toJs = JS[List](this)
}

case class ListDivider(
  inset: UndefOr[Boolean] = undefined,
  style: UndefOr[Object] = undefined) extends SimpleProps {
  private[muiwrapper] val _c = (c: Mui) => c.ListDivider
  val toJs = JS[ListDivider](this)
}

case class ListItem(
  disableTouchTap: UndefOr[Boolean] = undefined,
  insetChildren: UndefOr[Boolean] = undefined,
  leftAvatar: UndefOr[ReactElement] = undefined,
  leftCheckbox: UndefOr[ReactElement] = undefined,
  leftIcon: UndefOr[ReactElement] = undefined,
  rightAvatar: UndefOr[ReactElement] = undefined,
  rightToggle: UndefOr[ReactElement] = undefined,
  rightIcon: UndefOr[ReactElement] = undefined,
  secondaryText: UndefOr[ReactElement] = undefined,
  secondaryTextLines: Int = 1,

  onMouseOut: UndefOr[SyntheticMouseEvent[Node] => Unit] = undefined,
  onMouseOver: UndefOr[SyntheticMouseEvent[Node] => Unit] = undefined,

  // react
  style: UndefOr[Object] = undefined,
  key: UndefOr[String] = undefined,
  ref: UndefOr[String] = undefined) extends Props {
  require(secondaryTextLines == 1 || secondaryTextLines == 2)
  private[muiwrapper] val _c = (c: Mui) => c.ListItem
  val toJs = JS[ListItem](this)
}