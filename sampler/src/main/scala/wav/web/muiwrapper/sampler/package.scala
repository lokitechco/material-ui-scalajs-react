package wav.web.muiwrapper

import japgolly.scalajs.react._
import org.scalajs.dom, dom.{Node, Element}

import scalajs.js, js.Dynamic.{global => g}, js.JSConverters._

package object sampler {

  def getElement[T <: Element](id: String): T =
    g.document.getElementById(id).asInstanceOf[T]

  implicit def `f1->undefjs`[P1, R](f: P1 => R) =
    Some(f: js.Function1[P1, R]).orUndefined

  implicit def `f2->undefjs`[P1, P2, R](f: (P1, P2) => R) =
    Some(f: js.Function2[P1, P2, R]).orUndefined

  @inline def handler[E <: SyntheticEvent[Node]](f: E => Unit) = Some(f)

  @inline def handler[E <: SyntheticEvent[Node]](block: => Unit): Option[E => Unit] = handler(_ => block)

  implicit class MRef[M <: TopNode](ref: RefSimple[M]) {
    @inline def M(c: ReactComponentM_[_])(run: M => Unit): Unit = run(ref(c).get.asInstanceOf[M])

    @inline def M(sc: ComponentScope_M[_])(run: M => Unit): Unit = run(ref(sc).get.asInstanceOf[M])

    @inline def M[A,B](b: { def foreach(run: BackendScope[A,B] => Unit) })(run: M => Unit): Unit = b.foreach(M(_)(run))
  }

}