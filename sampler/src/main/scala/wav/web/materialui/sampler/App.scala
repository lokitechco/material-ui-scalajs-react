package wav.web.materialui.sampler

import scalajs.js
import js.Dynamic.{ global => g }
import org.scalajs.dom
import wav.web.materialui._
import japgolly.scalajs.react._
import vdom.ReactVDom._
import all._

object App extends js.JSApp {

  def main(target: dom.HTMLDivElement): Unit = {
    target.innerHTML = """<div id="nav"></div><div id="content"></div>"""
    val samplerM = React.render(Sampler, el[dom.HTMLDivElement]("nav"))
    val navRef = LeftNav.Ref("nav")
    dom.onhashchange = (_: dom.Event) => {
      navRef(samplerM).close
      samples.get(hash.toLowerCase).foreach(rel => React.render(rel, el("content")))
    }
  }

  def main(): Unit =
    main(el("scala"))

  private def hash: String = if (dom.window.location.hash.length > 0) dom.window.location.hash.substring(1) else ""

  private def pathname(location: String): String =
    dom.window.location.pathname + "#" + location

  private def el[T <: dom.HTMLElement](id: String): T =
    g.document.getElementById(id).asInstanceOf[T]

  val samples = {
    import Samples._
    Map[String, ReactElement](
      "/samples/icon" -> IconSample,
      "/samples/dialog" -> DialogSample)
  }

  class SamplerBackend(T: BackendScope[_, Map[String, ReactElement]]) {
    private val navRef = LeftNav.Ref("nav")
    def toggle = {
      log("Toggled")
      navRef(T).toggle
    }
    def close = {
      log("Closed")
      navRef(T).close
    }
  }

  val Sampler: ReactElement = {
    ReactComponentB[Unit]("Sampler")
      .initialState(samples)
      .backend(new SamplerBackend(_))
      .render((_, S, B) =>
        div(
          IconButtonU(
            "navigation-menu",
            onTouchTap = (ev: SyntheticTouchEvent[dom.HTMLDivElement]) => B.toggle).noChildren,
          LeftNavU(
            ref = "nav",
            menuItems = S.map { e =>
              val (id, _) = e
              MenuItem(
                text = id,
                payload = pathname(id))
            }.toJsArray)
            .noChildren))
      .buildU
      .apply()
  }
}