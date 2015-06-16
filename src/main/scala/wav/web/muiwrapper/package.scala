package wav.web

import japgolly.scalajs.react.{ReactNode, ReactComponentU_}
import scala.scalajs.js, js.{Dynamic, undefined}, js.Dynamic.{global => g}
import org.scalajs.dom

package object muiwrapper {

  type ReactComponent = js.Dynamic

  trait ComponentB {
    protected val muiUniverse: MuiUniverse
    protected val props      : Props

    @inline def apply(children: ReactNode*): ReactComponentU_ =
      muiUniverse.React.createElement(props._c(muiUniverse.mui), props.toJs, children.toJsArray)
        .asInstanceOf[ReactComponentU_]

    @inline def apply(update: js.Object => js.Object, children: ReactNode*): ReactComponentU_ =
      muiUniverse.React.createElement(props._c(muiUniverse.mui), update(props.toJs), children.toJsArray)
        .asInstanceOf[ReactComponentU_]
  }

  trait Props {
    private[muiwrapper] val _c: Mui => ReactComponent

    @inline def toJs: js.Object
  }

  trait MuiUniverse {
    val React: js.Dynamic = g.React
    val mui  : Mui        = g.mui.asInstanceOf[Mui]
    private[muiwrapper] lazy val muiThemeManager = mui.Styles.ThemeManager()
  }

  // Installs the bundled react to the window so that scalajs-react can use it.
  object DefaultMuiUniverse extends MuiUniverse {
    override val React = {
      if (g.React.asInstanceOf[js.UndefOr[js.Function]] != undefined) g.React
      else {
        val r = g.require("react/addons")
        g.window.React = r
        r
      }
    }
    override val mui   = {
      val mui = g.require("material-ui")
      val injectTapPlugin = g.require("react-tap-event-plugin")()
      mui.asInstanceOf[Mui]
    }
  }

}