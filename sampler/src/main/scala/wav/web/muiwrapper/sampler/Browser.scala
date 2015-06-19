package wav.web.muiwrapper.sampler

import japgolly.scalajs.react.extra.router2.BaseUrl
import org.scalajs.dom

object Browser {

  def hash: String = if (dom.window.location.hash.length > 0) dom.window.location.hash.substring(1) else ""

  def link(path: String): String =
    dom.window.location.pathname + "#" + path

  def currentPage: String = {
    val loc  = dom.window.location
    loc.href.substring(0, loc.href.length - loc.hash.length)
  }

}
