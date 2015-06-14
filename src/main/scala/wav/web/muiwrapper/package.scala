package wav.web

import japgolly.scalajs.react.{ReactNode, ReactComponentU_}
import scala.scalajs.js, js.Dynamic.{global => g}

package object muiwrapper {

  type ReactComponent = js.Dynamic

  trait ComponentB {
    protected val muiUniverse: MuiUniverse
    protected val props: Props

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
    val mui: Mui = g.mui.asInstanceOf[Mui]
    private[muiwrapper] lazy val muiThemeManager = mui.Styles.ThemeManager()
  }

}