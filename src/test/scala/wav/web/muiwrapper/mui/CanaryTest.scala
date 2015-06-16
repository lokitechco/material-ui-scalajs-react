package wav.web.muiwrapper.mui

import japgolly.scalajs.react._
import vdom.prefix_<^._
import utest._
import test._
import scalajs.js.RegExp

object CanaryTest extends TestSuite {

  val toHtml = React.renderToStaticMarkup _

  def assertRender(expected: RegExp, actual: String) = assert(expected.test(actual))

  val tests = TestSuite {

    'componentCanBeRendered {
       val icon = ReactComponentB[Unit]("Icons example")
        .render(_ => FontIcon("material-icons")("check"))
        .hackSpec(installMuiContext)
        .buildU

      assertRender(new RegExp("^<span .*>check</span>$"), toHtml(icon()))

    }

  }

}
