package app

import scalajs.js
import org.scalajs.dom, dom.html
import wav.web.muiwrapper.mui._
import japgolly.scalajs.react._

object App extends js.JSApp {

  val App = ReactComponentB[Unit]("App")
    .stateless
    .noBackend
    .render(_ => FontIcon("material-icons")("menu"))
    // mui requires context properties to be set, this is done on top-level components.
    .hackSpec(installMuiContext)
    .buildU

  def main(): Unit = {
    val target = dom.document.getElementById("app").asInstanceOf[html.Div]
    React.render(App(), target)
  }

}