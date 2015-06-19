package wav.web

import japgolly.scalajs.react.{ReactNode, ReactComponentU_}
import scala.scalajs.js, js.{Dynamic, Object, UndefOr, undefined}, Dynamic.{global => g}

package object muiwrapper {

  type ReactComponent = js.Dynamic

  trait ComponentB {
    protected val muiUniverse: MuiUniverse
    protected val props      : Props

    private val allProps: js.Object = {
      val o = props.toJs.asInstanceOf[Dynamic with Object]
      props.ref.foreach(o.updateDynamic("ref")(_))
      props.key.foreach(o.updateDynamic("key")(_))
      o
    }

    @inline def apply(children: ReactNode*): ReactComponentU_ =
      muiUniverse.React.createElement(props._c(muiUniverse.mui), allProps, children.toJsArray)
        .asInstanceOf[ReactComponentU_]
  }

  trait Props {
    private[muiwrapper] val _c: Mui => ReactComponent
    val key: UndefOr[String]
    val ref: UndefOr[String]

    @inline def toJs: js.Object
  }

  trait SimpleProps extends Props {
    val key: UndefOr[String] = undefined
    val ref: UndefOr[String] = undefined
  }

  trait MuiUniverse {

    def install(): Unit = {
      requireDef(React, "React must available")
      requireDef(mui, "mui must be available")
    }

    lazy                     val React: Dynamic  = g.React
    lazy                     val mui  : Mui      = g.mui.asInstanceOf[Mui]
    private[muiwrapper] lazy val muiThemeManager = mui.Styles.ThemeManager()
  }

  // Installs the bundled react to the window so that scalajs-react can use it.
  object DefaultMuiUniverse extends MuiUniverse {
    override lazy val React =
      if (g.React.asInstanceOf[UndefOr[js.Function]] != undefined) g.React
      else {
        val r = g.require("react/addons")
        g.window.React = r
        r
      }
    override lazy val mui   = {
      val mui = g.require("material-ui")
      val injectTapPlugin = g.require("react-tap-event-plugin")()
      mui.asInstanceOf[Mui]
    }
  }

  private[muiwrapper] def requireDef(v: js.Any, message: => String) = require(v.asInstanceOf[js.UndefOr[js.Any]] != undefined)

}