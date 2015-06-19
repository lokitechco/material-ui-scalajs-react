package wav.web.muiwrapper.sampler

import org.scalajs.dom.html.Div

import scalajs.js.Dynamic.{global => g}
import japgolly.scalajs.react._, vdom.prefix_<^._
import Syntax._

object CodeBlock {

  private val ref = Ref[Div]("codeBlockContent")

  val content =
    RB[(String, String)]("CodeBlock")
      .stateless
      .noBackend
      .render { (p, _, _) =>
      val (lang, content) = p
      <.div(^.ref := ref.name, <.pre(<.code(^.className := lang, content)))
    }
      .componentDidMount($ => g.hljs.highlightBlock(ref($).get.getDOMNode()))
      .componentDidUpdate(($, _, _) => g.hljs.highlightBlock(ref($).get.getDOMNode()))
      .propsRequired
      .build


}