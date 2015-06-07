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

  ref: Option[String] = None,
  style: Option[js.Object] = None)

// Icons

//√
case class FontIcon(
  className: String,
  hoverColor: Option[String] = None,

  style: Option[js.Object] = None,
  ref: Option[String] = None)

//√
case class SvgIcon(
  ref: Option[String] = None,
  style: Option[js.Object] = None)

// Buttons

//case class EnhancedButton(
//  ref: Option[String] = None,
//  touchRippleColor: String,
//  disabled: Boolean,
//  onBlur: SyntheticFocusEvent[Node] => _,
//  onMouseOver: SyntheticMouseEvent[Node] => _,
//  centerRipple: Boolean,
//  disableFocusRipple: Boolean,
//  onTouchTap: SyntheticTouchEvent[Node] => _,
//  style: Option[js.Object] = None,
//  disableTouchRipple: Boolean,
//  linkButton: Boolean,
//  onKeyboardFocus: SyntheticFocusEvent[Node] => _,
//  focusRippleOpacity: Int,
//  className: String,
//  touchRippleOpacity: Int,
//  onMouseOut: SyntheticMouseEvent[Node] => _,
//  onFocus: SyntheticFocusEvent[Node] => _,
//  focusRippleColor: String,
//  keyboardFocused: Boolean)

//√
case class IconButton(
  className: Option[String] = None,
  disabled: Boolean = false,
  iconClassName: Option[String] = None,
  iconStyle: Option[js.Object] = None,
  tooltip: Option[String] = None,
  touch: Boolean = false,

  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
  onTouchTap:  Option[SyntheticTouchEvent[Node] => _] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => _] = None,
  onMouseOut: Option[SyntheticMouseEvent[Node] => _] = None,

  ref: Option[String] = None,
  style: Option[js.Object] = None)

//√
case class FlatButton(
  label: String,
  labelStyle: Option[js.Object] = None,
  disabled: Boolean = false,
  primary: Boolean = false,
  secondary: Boolean = false,
  linkButton: Boolean = false,
  rippleColor: Option[String] = None,
  hoverColor: Option[String] = None,

  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
  onTouchTap:  Option[SyntheticTouchEvent[Node] => _] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => _] = None,
  onMouseOut: Option[SyntheticMouseEvent[Node] => _] = None,

  ref: Option[String] = None,
  style: Option[js.Object] = None)

//√
case class RaisedButton(
  label: String,
  labelStyle: Option[js.Object] = None,
  disabled: Boolean = false,
  primary: Boolean = false,
  secondary: Boolean = false,

  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
  onTouchTap:  Option[SyntheticTouchEvent[Node] => _] = None,
  onMouseOver: Option[SyntheticMouseEvent[Node] => _] = None,
  onMouseOut: Option[SyntheticMouseEvent[Node] => _] = None,

  ref: Option[String] = None,
  style: Option[js.Object] = None)

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

  onShow: Option[() => _] = None,
  onDismiss: Option[() => _] = None,
  onClickAway: Option[() => _] = None,
  //  repositionOnUpdate: Boolean,

  ref: Option[String] = None,
  style: Option[js.Object] = None)

// Menus

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

  onNavOpen: Option[(SyntheticEvent[Node], Int, js.Object /* MenuItems */) => _] = None,
  onNavClose: Option[js.Function0[Unit]] = None,
  onChange: Option[js.Function0[Unit]] = None,

  ref: Option[String] = None,
  style: Option[js.Object] = None)
//
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

//
//case class ToolbarGroup(
//  className: String,
//  style: Option[js.Object] = None,
//  ref: Option[String] = None,
//  float: Option[String] = None)
//
//case class DropDownMenu(
//  selectedIndex: Int,
//  // menuItems: Array[???],
//  menuItemStyle: js.Object,
//  style: Option[js.Object] = None,
//  // onChange: js.Function[???, Unit] /*???*/,
//  className: String,
//  ref: Option[String] = None,
//  autoWidth: Option[Boolean] = None)
//
//case class Tab(
//  handleTouchTap: SyntheticTouchEvent[Node] => _,
//  style: Option[js.Object] = None,
//  selected: Boolean,
//  width: String,
//  ref: Option[String] = None)
//
//case class DatePicker(
//  maxDate: js.Object,
//  onTouchTap: SyntheticTouchEvent[Node] => _,
//  style: Option[js.Object] = None,
//  hideToolbarYearChange: Boolean,
//  minDate: js.Object,
//  defaultDate: js.Object,
//  // onShow: js.Function[???, Unit] /*???*/,
//  // onDismiss: js.Function[???, Unit] /*???*/,
//  // onChange: js.Function[???, Unit] /*???*/,
//  // shouldDisableDate: js.Function[???, Unit] /*???*/,
//  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
//  ref: Option[String] = None,
//  autoOk: Option[Boolean] = None,
//  // formatDate: Option[js.Function[???, Unit] /*???*/] = None,
//  showYearSelector: Option[Boolean] = None)

//case class TimePicker(
//  onTouchTap: SyntheticTouchEvent[Node] => _,
//  // onShow: js.Function[???, Unit] /*???*/,
//  // onDismiss: js.Function[???, Unit] /*???*/,
//  // onChange: js.Function[???, Unit] /*???*/,
//  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
//  style: Option[js.Object] = None,
//  ref: Option[String] = None,
//  defaultTime: Option[js.Object] = None)

case class Toggle(
  elementStyle: js.Object,
  // onToggle: js.Function[???, Unit] /*???*/,
  toggled: Boolean,
  style: Option[js.Object] = None,
  ref: Option[String] = None,
  defaultToggled: Boolean)

case class RadioButtonGroup(
  valueSelected: String,
  defaultSelected: String,
  name: String,
  // onChange: js.Function[???, Unit] /*???*/
  ref: Option[String] = None)

//case class Slider(
//  // onDragStop: js.Function[???, Unit] /*???*/,
//  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
//  error: String,
//  description: String,
//  // onChange: js.Function[???, Unit] /*???*/,
//  onDragStart: SyntheticMouseEvent[Node] => _,
//  name: String,
//  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,
//  step: Int,
//  style: Option[js.Object] = None,
//  ref: Option[String] = None,
//  required: Option[Boolean] = None,
//  min: Option[Int] = None,
//  disabled: Option[Boolean] = None,
//  max: Option[Int] = None)

case class Checkbox(
  // onCheck: js.Function[???, Unit] /*???*/,
  style: Option[js.Object] = None,
  iconStyle: js.Object,
  ref: Option[String] = None)

//case class Tooltip(
//  touch: Boolean,
//  show: Boolean,
//  style: Option[js.Object] = None,
//  label: String,
//  className: String,
//  ref: Option[String] = None)

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

case class RadioButton(
  ref: Option[String] = None,
  // onCheck: js.Function[???, Unit] /*???*/,
  style: Option[js.Object] = None,
  iconStyle: js.Object)

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
//case class Snackbar(
//  ref: Option[String] = None,
//  message: String,
//  style: Option[js.Object] = None,
//  onActionTouchTap: SyntheticTouchEvent[Node] => _,
//  openOnMount: Boolean,
//  action: String)
//
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
  errorText: Option[String] = None,
  floatingLabelText: Option[String] = None,
  hintText: Option[String] = None,
  multiLine: Boolean = false,

  // REVIEW: look into passing all react input props
  `type`: Option[String] = None,
  id: String,

  onChange: Option[SyntheticEvent[Node] => _] = None,
  onBlur: Option[SyntheticFocusEvent[Node] => _] = None,
  onKeyDown: Option[SyntheticKeyboardEvent[Node] => _] = None,
  onEnterKeyDown: Option[SyntheticKeyboardEvent[Node] => _] = None,
  onFocus: Option[SyntheticFocusEvent[Node] => _] = None,

  ref: Option[String] = None,
  style: Option[js.Object] = None)

//case class CircularProgress(
//  ref: Option[String] = None,
//  style: Option[js.Object] = None,
//  size: Option[Int] = None,
//  min: Option[Int] = None,
//  value: Option[Int] = None,
//  max: Option[Int] = None)
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