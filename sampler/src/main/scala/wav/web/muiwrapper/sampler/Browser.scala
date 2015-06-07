package wav.web.muiwrapper.sampler

import org.scalajs.dom

object Browser {

  def hash: String = if (dom.window.location.hash.length > 0) dom.window.location.hash.substring(1) else ""

  def link(path: String): String =
    dom.window.location.pathname + "#" + path

}
