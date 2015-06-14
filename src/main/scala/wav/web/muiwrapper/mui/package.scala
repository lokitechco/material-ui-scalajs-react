package wav.web.muiwrapper

import japgolly.scalajs.react._
import scala.scalajs.js, js.{Function => JFn, Dynamic, Dictionary}


package object mui {

  implicit val muiUniverse = new MuiUniverse {}

  implicit class defaultPropsToB(protected val props: Props)(implicit protected val muiUniverse: MuiUniverse) extends ComponentB

  @inline implicit def builderToComponent(b: ComponentB): ReactComponentU_ = b.apply()

  // React.PropTypes.* || @throws(Error) (props, propName, componentName) => Unit
  @inline def propType(get: Dynamic => Dynamic)(implicit muiUniverse: MuiUniverse): JFn =
    get(muiUniverse.React.PropTypes).asInstanceOf[JFn]

  def installMuiContext[P, S, B, N <: TopNode](implicit muiUniverse: MuiUniverse): ReactComponentSpec[P, S, B, N] => Unit =
    spec => {
      val t = spec.asInstanceOf[Dynamic]
      t.updateDynamic("childContextTypes")(Dictionary("muiTheme" -> propType(_.`object`)))
      t.updateDynamic("getChildContext")((() => Dynamic.literal("muiTheme" -> muiUniverse.muiThemeManager.getCurrentTheme())): JFn)
    }

}