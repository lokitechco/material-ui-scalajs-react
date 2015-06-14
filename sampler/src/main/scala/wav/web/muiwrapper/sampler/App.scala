package wav.web.muiwrapper.sampler

import scala.scalajs.js.annotation.JSExport
import scalajs.js
import org.scalajs.dom, dom.html.Div
import japgolly.scalajs.react._

@JSExport("SamplerApp")
object App extends js.JSApp {

  private val nav = "nav"

  private def contentId(name: String): String =
    if (name == "Sampler") nav else "content"

  def main(): Unit = {
    startBuildService()

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

  def startBuildService(): Unit = {
    import wav.devtools.sbt.httpserver.buildservice.BuildService
    def onBuildEvent(project: String, event: String): Unit =
      if (project == "mui-wrapper-sampler" && event == "compiled")
        dom.location.reload()

    BuildService.configure(_.onBuildEvent = onBuildEvent _)
    BuildService().foreach(_.start())
  }

}