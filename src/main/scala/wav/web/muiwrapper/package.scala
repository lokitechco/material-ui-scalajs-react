package wav.web

import japgolly.scalajs.react.{ReactNode, ReactComponentU_}

import scalajs.js, js.Dynamic.{global => g}

package object muiwrapper {

  private[muiwrapper] val log = (o: js.Any) => g.console.log(o)

  implicit val u = new MuiUniverse {}

  type ReactComponent = js.Dynamic

  trait ComponentB {
    protected val u: MuiUniverse
    val component: ReactComponent

    def toJs: js.Object

    def apply(children: ReactNode*): ReactComponentU_ =
      u.React.createElement(component, toJs, children.toJsArray)
        .asInstanceOf[ReactComponentU_]

    def apply(update: js.Object => js.Object, children: ReactNode*): ReactComponentU_ =
      u.React.createElement(component, update(toJs), children.toJsArray)
        .asInstanceOf[ReactComponentU_]
  }

  trait MuiUniverse {
    val React: js.Dynamic = g.React
    val mui: Mui = g.mui.asInstanceOf[Mui]
    private [muiwrapper] lazy val muiThemeManager = mui.Styles.ThemeManager()
  }

  trait Mui extends js.Object {
    val AppBar: ReactComponent = js.native
    val AppCanvas: ReactComponent = js.native
    val Checkbox: ReactComponent = js.native
    val CircularProgress: ReactComponent = js.native
    val ClearFix: ReactComponent = js.native
    val BeforeAfterWrapper: ReactComponent = js.native
    val DatePicker: ReactComponent = js.native
    val Dialog: ReactComponent = js.native
    val DropDownIcon: ReactComponent = js.native
    val DropDownMenu: ReactComponent = js.native
    val EnhancedButton: ReactComponent = js.native
    val FlatButton: ReactComponent = js.native
    val FloatingActionButton: ReactComponent = js.native
    val FontIcon: ReactComponent = js.native
    val IconButton: ReactComponent = js.native
    val LeftNav: ReactComponent = js.native
    val LinearProgress: ReactComponent = js.native
    val Menu: ReactComponent = js.native
    val MenuItem: ReactComponent = js.native
    val Mixins: ReactComponent = js.native
    val Paper: ReactComponent = js.native
    val RadioButton: ReactComponent = js.native
    val RadioButtonGroup: ReactComponent = js.native
    val RaisedButton: ReactComponent = js.native
    val Slider: ReactComponent = js.native
    val SvgIcon: ReactComponent = js.native
    val Snackbar: ReactComponent = js.native
    val Tab: ReactComponent = js.native
    val Tabs: ReactComponent = js.native
    val Toggle: ReactComponent = js.native
    val TimePicker: ReactComponent = js.native
    val TextField: ReactComponent = js.native
    val Toolbar: ReactComponent = js.native
    val ToolbarGroup: ReactComponent = js.native
    val ToolbarSeparator: ReactComponent = js.native
    val ToolbarTitle: ReactComponent = js.native
    val Tooltip: ReactComponent = js.native

    val Icons: js.Dynamic = js.native
    val Styles: Mui.Styles = js.native
    val Utils: Mui.Util = js.native
  }

  object Mui {

    trait Util extends js.Object {
      val CssEvent: js.Dynamic = js.native
      val Dom: js.Dynamic = js.native
      val Events: js.Dynamic = js.native
      val KeyCode: js.Dynamic = js.native
      val KeyLine: js.Dynamic = js.native
      val ColorManipulator: js.Dynamic = js.native
      val Extend: js.Dynamic = js.native
      val UniqueId: js.Dynamic = js.native
    }

    trait Styles extends js.Object {
      val AutoPrefix: js.Dynamic = js.native
      val Colors: js.Dynamic = js.native
      val Spacing: js.Dynamic = js.native
      val ThemeManager: js.Dynamic = js.native
      val Typography: js.Dynamic = js.native
      val Transitions: js.Dynamic = js.native
    }

  }

}