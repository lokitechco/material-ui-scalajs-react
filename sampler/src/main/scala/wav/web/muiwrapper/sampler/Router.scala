package wav.web.muiwrapper.sampler

import japgolly.scalajs.react._
import org.scalajs.dom

class Router[P, S, B, N <: TopNode](path: String, topComponentBs: ReactComponentB[P, S, B, N]*)(implicit ev: Unit =:= P) {
  
  private val base = s"/${path.stripSuffix("/").stripPrefix("/")}/"

  lazy val routes: Map[String, String] =
    topComponentBs.map(c => (c.name, s"${Browser.link(s"goto=$base" + c.name.toLowerCase)}")).toMap

  private val PathPattern = s"""goto=$base([A-Za-z]+)""".r

  private def U(path: String): Option[ReactComponentB[P, S, B, N]] =
    path match {
      case PathPattern(key) if routes.keySet.map(_.toLowerCase).contains(key.toLowerCase) =>
        topComponentBs.find(_.name.equalsIgnoreCase(key))
      case _ => None
    }
  
  private var lastRoute: String = null

  def render(target: String => String)(onChanging: String => Boolean = _ => true): Unit = {
    val hash = Browser.hash.toLowerCase
    U(hash).foreach { c =>
      if (c.name != lastRoute && onChanging(c.name)) {
        React.render(c.buildU.apply(), getElement(target(c.name)))
        lastRoute = c.name
      } else if (c.name == lastRoute) {
        onChanging(c.name)
      }
      dom.location.hash = s"#$base" + c.name
    }
  }

}
