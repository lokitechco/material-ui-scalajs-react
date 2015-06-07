package wav.web.muiwrapper.sampler

import japgolly.scalajs.react.SyntheticTouchEvent
import org.scalajs.dom._
import wav.web.muiwrapper.mui._

object MuiIcon {
  @inline def apply(name: String) =
    FontIcon("material-icons")(name)
}

object MuiIconButton {
  @inline def apply(name: String)(block: => Unit) =
    IconButton(onTouchTap = handler(_ => block))(MuiIcon(name))
}