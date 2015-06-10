package wav.web.muiwrapper.mui

import wav.common.scalajs.macros.JS
import japgolly.scalajs.react._
import org.scalajs.dom.Node

import scala.scalajs.js

//√
case class Paper(
  circle: Boolean = false,
  rounded: Boolean = true,
  transitionEnabled: Boolean = true,
  zDepth: Int = 1,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None)

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

  onChange: Option[SyntheticEvent[Node] => _] = None,
  onKeyDown: Option[SyntheticKeyboardEvent[Node] => _] = None,
  onEnterKeyDown: Option[SyntheticKeyboardEvent[Node] => _] = None,

  // react
  `type`: Option[String] = None,
  id: Option[String] = None,
  value: Option[String] = None,
  defaultValue: Option[String] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None)

// Icons

//√
case class FontIcon(
  className: String,
  hoverColor: Option[String] = None,

  // react
  style: Option[js.Object] = None,
  ref: Option[String] = None)

//√
case class SvgIcon(
  viewBox: Option[String] = None,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None)

// Buttons (EnhancedButton)

//case class EnhancedButton(
//  ref: Option[String] = None,
//  touchRippleColor: String,
//  disabled: Boolean,
//  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
//  onMouseOver: SyntheticMouseEvent[Node] => _,
//  centerRipple: Boolean,
//  disableFocusRipple: Boolean,
//  onTouchTap: SyntheticTouchEvent[Node] => _,
//  style: Option[js.Object] = None,
//  disableTouchRipple: Boolean,
//  linkButton: Boolean,
//  onKeyboardFocus: Option[SyntheticFocusEvent[Node] => _] = None,
//  focusRippleOpacity: Int,
//  className: String,
//  touchRippleOpacity: Int,
//  onMouseOut: SyntheticMouseEvent[Node] => _,
//  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
//  focusRippleColor: String,
//  keyboardFocused: Boolean)

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

  onMouseOut: Option[SyntheticMouseEvent[Node] => _] = None,
  onTouchTap: Option[SyntheticTouchEvent[Node] => _] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => _] = None,

  // react
  disabled: Boolean = false,
  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None)

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

  onTouchTap: Option[SyntheticTouchEvent[Node] => _] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => _] = None,
  onMouseOut: Option[SyntheticMouseEvent[Node] => _] = None,

  // react
  disabled: Boolean = false,
  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None)

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

  onTouchTap: Option[SyntheticTouchEvent[Node] => _] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => _] = None,
  onMouseOut: Option[SyntheticMouseEvent[Node] => _] = None,

  // react
  disabled: Boolean = false,
  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None)

case class FloatingActionButton(
  iconClassName: Option[js.Object] = None,
  iconStyle: Option[js.Object] = None,
  linkButton: Boolean = false,
  mini: Boolean = true,
  labelStyle: Option[js.Object] = None,
  secondary: Boolean = false,

  onTouchTap: Option[SyntheticTouchEvent[Node] => _] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => _] = None,
  onMouseOut: Option[SyntheticMouseEvent[Node] => _] = None,

  // react
  disabled: Boolean = false,
  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None)

// Switches

object EnhancedSwitch {
  type OnChange = (SyntheticEvent[Node], Boolean) => _
}

trait EnhancedSwitchM extends TopNode {
  def isSwitched(): Boolean = js.native

  def setSwitched(switched: Boolean): Unit = js.native

  def getValue(): Boolean = js.native

  def isKeyboardFocused(): Boolean = js.native
}


trait CheckboxM extends EnhancedSwitchM {
  def isChecked(): Boolean = js.native

  def setChecked(checked: Boolean): Unit = js.native
}

object HorizontalPosition extends Enumeration {
  val left = Value
  val right = Value
}

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
  ref: Option[String] = None)


trait RadioButtonM extends EnhancedSwitchM {
  def isChecked(): Boolean = js.native

  def setChecked(checked: Boolean): Unit = js.native
}

case class RadioButton(
  label: Option[String] = None,
  labelPosition: HorizontalPosition.Value = HorizontalPosition.right,
  defaultChecked: Boolean = false,
  iconStyle: Option[js.Object] = None,
  onCheck: Option[EnhancedSwitch.OnChange] = None,

  ref: Option[String] = None,
  style: Option[js.Object] = None)

trait RadioButtonGroupM extends TopNode {
  def getSelectedValue(): js.UndefOr[String] = js.native

  def setSelectedValue(value: String): Unit = js.native

  def clearValue(): Unit = js.native
}

case class RadioButtonGroup(
  name: String,

  valueSelected: Option[String] = None,
  defaultSelected: Option[String] = None,
  labelPosition: HorizontalPosition.Value = HorizontalPosition.right,
  onChange: Option[EnhancedSwitch.OnChange] = None,

  ref: Option[String] = None)

trait ToggleM extends TopNode {
  def isToggled(): Boolean = js.native

  def setToggled(toggled: Boolean): Unit = js.native
}

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
  ref: Option[String] = None)

// Menus

case class MenuAction(text: String, onClick: () => _) {
  val toJs = JS[MenuAction].apply(this)
}

//√
trait DialogM extends TopNode {
  def show(): Unit = js.native

  def dismiss(): Unit = js.native
}

//√
case class Dialog(
  actions: Option[js.Array[MenuAction]] = None,
  actionFocus: Option[String] = None,
  contentClassName: Option[String] = None,
  contentInnerStyle: Option[js.Object] = None,
  contentStyle: Option[js.Object] = None,
  openImmediately: Boolean = false,
  modal: Boolean = false,
  title: Option[String] = None,
  repositionOnUpdate: Boolean = true,

  onShow: Option[() => _] = None,
  onDismiss: Option[() => _] = None,
  onClickAway: Option[() => _] = None,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None)

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

  actions: Option[js.Array[MenuAction]] = None,
  actionFocus: Option[String] = None,
  contentClassName: Option[String] = None,
  contentInnerStyle: Option[js.Object] = None,
  contentStyle: Option[js.Object] = None,
  openImmediately: Boolean = false,
  modal: Boolean = false,
  title: Option[String] = None,
  repositionOnUpdate: Boolean = true,

  onAccept: Option[() => _] = None,
  onShow: Option[() => _] = None,
  onDismiss: Option[() => _] = None,
  onClickAway: Option[() => _] = None,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None)

// Menus


//√
trait LeftNavM extends TopNode {
  def close(): Unit = js.native

  def toggle(): Unit = js.native
}

case class LeftNav(
  docked: Boolean = true,
  header: Option[String] = None,
  menuItems: js.Array[js.Object], // TODO.
  selectedIndex: Option[Int] = None,
  openRight: Boolean = false,

  onNavOpen: Option[(SyntheticEvent[Node], Int, js.Object /* MenuItems */ ) => _] = None,
  onNavClose: Option[js.Function0[Unit]] = None,
  onChange: Option[js.Function0[Unit]] = None,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None)

//case class MenuItem(
//  // onToggle: js.Function[???, Unit] /*???*/,
//  attribute: String,
//  number: String,
//  onTouchTap: SyntheticTouchEvent[Node] => _,
//  style: Option[js.Object] = None,
//  selected: Boolean,
//  iconClassName: String,
//  index: Int,
//  iconRightStyle: js.Object,
//  onClick: SyntheticMouseEvent[Node] => _,
//  data: String,
//  className: String,
//  iconRightClassName: String,
//  iconStyle: js.Object,
//  ref: Option[String] = None,
//  toggle: Option[Boolean] = None,
//  disabled: Option[Boolean] = None)

//case class DropDownIcon(
//  // menuItems: Array[???],
//  style: Option[js.Object] = None,
//  iconClassName: String,
//  // onChange: js.Function[???, Unit] /*???*/,
//  iconStyle: js.Object,
//  ref: Option[String] = None,
//  closeOnMenuItemClick: Option[Boolean] = None)


//case class Menu(
//  selectedIndex: Int,
//  // onToggle: js.Function[???, Unit] /*???*/,
//  // menuItems: Array[???],
//  menuItemStyleSubheader: js.Object,
//  menuItemStyle: js.Object,
//  style: Option[js.Object] = None,
//  menuItemClassNameLink: String,
//  menuItemClassNameSubheader: String,
//  menuItemClassName: String,
//  onItemClick: SyntheticMouseEvent[Node] => _,
//  // onItemTap: js.Function[???, Unit] /*???*/,
//  menuItemStyleLink: js.Object,
//  ref: Option[String] = None,
//  autoWidth: Option[Boolean] = None,
//  zDepth: Option[Int] = None,
//  hideable: Option[Boolean] = None,
//  visible: Option[Boolean] = None)

//case class DropDownMenu(
//  selectedIndex: Int,
//  // menuItems: Array[???],
//  menuItemStyle: js.Object,
//  style: Option[js.Object] = None,
//  // onChange: js.Function[???, Unit] /*???*/,
//  className: String,
//  ref: Option[String] = None,
//  autoWidth: Option[Boolean] = None)

// Other

trait Position extends js.Object { // Draggable
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

  onChange: Option[(SyntheticFocusEvent[Node], Double) => _] = None,

  // react
  defaultValue: Double = 0,
  required: Boolean = true,
  disabled: Boolean = false,
  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
  ref: Option[String] = None,
  style: Option[js.Object] = None)

case class Tooltip(
  label: String,
  className: Option[String] = None,
  touch: Boolean = false,
  show: Boolean = false,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None)

case class Snackbar(
  message: String,

  action: Option[String] = None,
  onActionTouchTap: Option[SyntheticTouchEvent[Node] => _] = None,
  openOnMount: Boolean = false,

  // react
  ref: Option[String] = None,
  style: Option[js.Object] = None)

//case class AppBar(
//  ref: Option[String] = None,
//  iconClassNameRight: String,
//  style: Option[js.Object] = None,
//  onRightIconButtonTouchTap: SyntheticTouchEvent[Node] => _,
//  iconClassNameLeft: String,
//  onLeftIconButtonTouchTap: SyntheticTouchEvent[Node] => _,
//  // iconElementRight: /*??? 'element*/,
//  iconStyleRight: js.Object,
//  // iconElementLeft: /*??? 'element*/,
//  showMenuIconButton: Option[Boolean] = None,
//  zDepth: Option[Int] = None
//  // title: Option[/*??? 'node*/] = None
//  )

//
//case class Tab(
//  handleTouchTap: SyntheticTouchEvent[Node] => _,
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
