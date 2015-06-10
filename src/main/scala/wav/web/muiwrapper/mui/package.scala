package wav.web.muiwrapper

import japgolly.scalajs.react.{TopNode, ReactComponentSpec}
import wav.common.scalajs.macros.JS
import scala.scalajs.js

package object mui {

  implicit val Mui = u.mui

  def installMuiContext[P, S, B, N <: TopNode](implicit u: MuiUniverse): ReactComponentSpec[P, S, B, N] => Unit =
    spec => {
      val t = spec.asInstanceOf[js.Dynamic]
      t.updateDynamic("childContextTypes")(js.Dynamic.literal("muiTheme" -> u.React.PropTypes.`object`): js.Object)
      t.updateDynamic("getChildContext")((() => js.Dynamic.literal("muiTheme" -> u.muiThemeManager.getCurrentTheme())): js.Function)
    }

  //  implicit class AppBarB(protected val props: AppBar)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.AppBar
  //    lazy val toJs = JS[AppBar](props)
  //  }
  //
  //  implicit class AppCanvasB(protected val props: AppCanvas)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.AppCanvas
  //    lazy val toJs = JS[AppCanvas](props)
  //  }
  //
  //  implicit class BeforeAfterWrapperB(protected val props: BeforeAfterWrapper)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.BeforeAfterWrapper
  //    lazy val toJs = JS[BeforeAfterWrapper](props)
  //  }
  //
    implicit class CheckboxB(protected val props: Checkbox)(implicit protected val u: MuiUniverse) extends ComponentB {
      val component = u.mui.Checkbox
      lazy val toJs = JS[Checkbox](props)
    }
  //
  //  implicit class CircularProgressB(protected val props: CircularProgress)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.CircularProgress
  //    lazy val toJs = JS[CircularProgress](props)
  //  }
  //
  //  implicit class ClearFixB(protected val props: ClearFix)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.ClearFix
  //    lazy val toJs = JS[ClearFix](props)
  //  }

    implicit class DatePickerB(protected val props: DatePicker)(implicit protected val u: MuiUniverse) extends ComponentB {
      val component = u.mui.DatePicker
      lazy val toJs = JS[DatePicker](props)
    }

  implicit class DialogB(protected val props: Dialog)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.Dialog
    lazy val toJs = JS[Dialog](props)
  }

  //  implicit class DropDownIconB(protected val props: DropDownIcon)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.DropDownIcon
  //    lazy val toJs = JS[DropDownIcon](props)
  //  }
  //
  //  implicit class DropDownMenuB(protected val props: DropDownMenu)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.DropDownMenu
  //    lazy val toJs = JS[DropDownMenu](props)
  //  }

  implicit class FlatButtonB(protected val props: FlatButton)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.FlatButton
    lazy val toJs = JS[FlatButton](props)
  }

    implicit class FloatingActionButtonB(protected val props: FloatingActionButton)(implicit protected val u: MuiUniverse) extends ComponentB {
      val component = u.mui.FloatingActionButton
      lazy val toJs = JS[FloatingActionButton](props)
    }

  implicit class FontIconB(protected val props: FontIcon)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.FontIcon
    lazy val toJs = JS[FontIcon](props)
  }

  implicit class IconButtonB(protected val props: IconButton)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.IconButton
    lazy val toJs = JS[IconButton](props)
  }

  implicit class LeftNavB(protected val props: LeftNav)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.LeftNav
    lazy val toJs = JS[LeftNav](props)
  }

  //  implicit class LinearProgressB(protected val props: LinearProgress)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.LinearProgress
  //    lazy val toJs = JS[LinearProgress](props)
  //  }
  //
  //  implicit class MenuB(protected val props: Menu)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.Menu
  //    lazy val toJs = JS[Menu](props)
  //  }
  //
  //  implicit class MenuItemB(protected val props: MenuItem)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.MenuItem
  //    lazy val toJs = JS[MenuItem](props)
  //  }

  implicit class PaperB(protected val props: Paper)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.Paper
    lazy val toJs = JS[Paper](props)
  }

  implicit class RadioButtonB(protected val props: RadioButton)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.RadioButton
    lazy val toJs = JS[RadioButton](props)
  }

  implicit class RadioButtonGroupB(protected val props: RadioButtonGroup)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.RadioButtonGroup
    lazy val toJs = JS[RadioButtonGroup](props)
  }

  implicit class RaisedButtonB(protected val props: RaisedButton)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.RaisedButton
    lazy val toJs = JS[RaisedButton](props)
  }

  //
  //  implicit class SliderB(protected val props: Slider)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.Slider
  //    lazy val toJs = JS[Slider](props)
  //  }

  implicit class SvgIconB(protected val props: SvgIcon)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.SvgIcon
    lazy val toJs = JS[SvgIcon](props)
  }

  //  implicit class StylesB(protected val props: Styles)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.Styles
  //    lazy val toJs = JS[Styles](props)
  //  }
  //
  //  implicit class SnackbarB(protected val props: Snackbar)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.Snackbar
  //    lazy val toJs = JS[Snackbar](props)
  //  }
  //
  //  implicit class TabB(protected val props: Tab)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.Tab
  //    lazy val toJs = JS[Tab](props)
  //  }
  //
  //  implicit class TabsB(protected val props: Tabs)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.Tabs
  //    lazy val toJs = JS[Tabs](props)
  //  }

  implicit class ToggleB(protected val props: Toggle)(implicit protected val u: MuiUniverse) extends ComponentB {
    val component = u.mui.Toggle
    lazy val toJs = JS[Toggle](props)
  }

  //
  //  implicit class TimePickerB(protected val props: TimePicker)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.TimePicker
  //    lazy val toJs = JS[TimePicker](props)
  //  }

    implicit class TextFieldB(protected val props: TextField)(implicit protected val u: MuiUniverse) extends ComponentB {
      val component = u.mui.TextField
      lazy val toJs = JS[TextField](props)
    }
  //
  //  implicit class ToolbarB(protected val props: Toolbar)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.Toolbar
  //    lazy val toJs = JS[Toolbar](props)
  //  }
  //
  //  implicit class ToolbarGroupB(protected val props: ToolbarGroup)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.ToolbarGroup
  //    lazy val toJs = JS[ToolbarGroup](props)
  //  }
  //
  //  implicit class ToolbarSeparatorB(protected val props: ToolbarSeparator)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.ToolbarSeparator
  //    lazy val toJs = JS[ToolbarSeparator](props)
  //  }
  //
  //  implicit class ToolbarTitleB(protected val props: ToolbarTitle)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.ToolbarTitle
  //    lazy val toJs = JS[ToolbarTitle](props)
  //  }
  //
  //  implicit class TooltipB(protected val props: Tooltip)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.Tooltip
  //    lazy val toJs = JS[Tooltip](props)
  //  }
  //
  //  implicit class UtilsB(protected val props: Utils)(implicit protected val u: MuiUniverse) extends ComponentB {
  //    val component = u.mui.Utils
  //    lazy val toJs = JS[Utils](props)
  //  }


}
