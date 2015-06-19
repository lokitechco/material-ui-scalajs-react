package wav.web.muiwrapper.sampler

import scalajs.js, js.annotation.JSExport
import org.scalajs.dom
import japgolly.scalajs.react._
import extra.router2._
import wav.web.muiwrapper.mui._
import wav.web.muiwrapper.sampler.Syntax._

@JSExport("SamplerApp")
object App extends js.JSApp {

  @JSExport
  override def main(): Unit = {
    init
    val router = Router(BaseUrl(Browser.currentPage), routerConfig.logToConsole)

    router() render dom.document.body
  }

  sealed trait Page
  case class Examples(eg: Example) extends Page

  val routerConfig = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._

    def default = redirectToPath("#sample/Icons")(Redirect.Replace)

    def exampleRoutes: Rule =
      Example.routes.prefixPath_/("#sample").pmap[Page](Examples) { case Examples(e) => e }

    (emptyRule
      | staticRedirect(root) ~> default
      | exampleRoutes
      )
      .notFound(redirectToPath(root)(Redirect.Replace))
  }

  private def init: Unit = {
    startBuildService
    muiUniverse.install
  }

  private def startBuildService: Unit = {
    import wav.devtools.sbt.httpserver.buildservice.BuildService
    def onBuildEvent(project: String, event: String): Unit =
      if (project == "mui-wrapper-sampler" && event == "compiled")
        dom.location.reload()

    BuildService.configure(_.onBuildEvent = ?(onBuildEvent _))
    BuildService().foreach(_.start())
  }

}