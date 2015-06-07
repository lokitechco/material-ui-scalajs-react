package wav.web.muiwrapper.sampler

import scalajs.js
import org.scalajs.dom, dom.html.Div
import wav.web.muiwrapper.mui.installMuiContext
import japgolly.scalajs.react._

object App extends js.JSApp {

  private val nav = "nav"

  private def contentId(name: String): String =
    if (name == "Sampler") nav else "content"

  def main(): Unit = {
    val target = getElement[Div]("scala")
    target.innerHTML = s"""<div id="$nav"></div><div id="content"></div>"""
    val sampler = new Sampler(nav, "samples")
    val main = sampler.Main.buildU
    val mainM = React.render(main(), getElement(nav))
    dom.onhashchange = (_: dom.Event) =>
      sampler.router.render(contentId _) { route =>
        sampler.mainRef.M(mainM)(_.close)
        true
      }
  }

}