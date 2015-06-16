package wav.web.muiwrapper.sampler

import scalajs.js, js.annotation.JSExport
import org.scalajs.dom
import japgolly.scalajs.react._, vdom.prefix_<^._
import japgolly.scalajs.react.extra.router2._

@JSExport("SamplerApp")
object App extends js.JSApp {

  sealed trait Page
  case class Examples(eg: Example) extends Page

  def layout(c: RouterCtl[Page], r: Resolution[Page]) =
    <.div(^.cls := "container", r.render())

  val routerConfig = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._

    def default = redirectToPage(Examples(Example.Icons))(Redirect.Replace)

    def exampleRoutes: Rule =
      Example.routes.prefixPath("#").pmap[Page](Examples) { case Examples(e) => e }

    (emptyRule
      | staticRoute(root, Examples(Example.Icons)) ~> default
      | exampleRoutes
      )
      .notFound(???)
      .renderWith(layout)
  }

  @JSExport
  override def main(): Unit = {
    startBuildService

    val router = Router(BaseUrl.fromWindowOrigin_/, routerConfig.logToConsole)
    router() render dom.document.body
  }

  def startBuildService: Unit = {
    import wav.devtools.sbt.httpserver.buildservice.BuildService
    def onBuildEvent(project: String, event: String): Unit =
      if (project == "mui-wrapper-sampler" && event == "compiled")
        dom.location.reload()

    BuildService.configure(_.onBuildEvent = onBuildEvent _)
    BuildService().foreach(_.start())
  }

}