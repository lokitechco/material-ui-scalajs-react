package wav.web.materialui.sampler

import scala.scalajs.js
import js.Dynamic.{ global => g }
import org.scalajs.dom
import dom.{ document, window }

object App extends js.JSApp {

  def main(target: dom.HTMLDivElement): Unit = {
    target.innerHTML = """<div id="nav"></div><div id="content"></div>"""
    e[dom.HTMLElement]("nav").innerHTML = "items"
    dom.onhashchange = (_: dom.Event) => {
      samples.get(hash.toLowerCase).foreach(mount => mount(e("content")))
    }
    if (hash == "") g.window.location.hash = samples.keys.take(1).toSeq(0)
  }
  def main(): Unit =
    main(e("scala"))

  private def hash: String = if (window.location.hash.length > 0) window.location.hash.substring(1) else ""

  private def e[T <: dom.HTMLElement](id: String): T =
    g.document.getElementById(id).asInstanceOf[T]

  private def iconSample(target: dom.HTMLDivElement): Unit =
    japgolly.scalajs.react.React.render(
      wav.web.materialui.Icon("action-done").apply, target)
    
  private val samples = Map[String, dom.HTMLDivElement => Unit](
    "icon" -> iconSample _)
}