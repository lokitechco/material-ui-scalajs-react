package wav.web.muiwrapper.sampler

import japgolly.scalajs.react._
import org.scalajs.dom._

import scala.scalajs.js, js.Dynamic.{global => g}

import scala.language.reflectiveCalls

package object examples {

  private[sampler] def log(o: js.Any) = g.console.log(o)

  class Backend(T: BackendScope[Unit, Unit]) {
    def foreach(run: BackendScope[Unit, Unit] => Unit) = run(T)
  }

  implicit class MRef[M <: TopNode](ref: RefSimple[M]) {
    @inline def M(c: ReactComponentM_[_])(run: M => Unit): Unit = run(ref(c).get.asInstanceOf[M])

    @inline def M(sc: ComponentScope_M[_])(run: M => Unit): Unit = run(ref(sc).get.asInstanceOf[M])

    @inline def M[A,B](b: { def foreach(run: BackendScope[A,B] => Unit) })(run: M => Unit): Unit = b.foreach(M(_)(run))
  }

  @inline def handler[E <: SyntheticEvent[Node]](f: E => Unit) = Some(f)

  @inline def handler[E <: SyntheticEvent[Node]](block: => Unit): Option[E => Unit] = handler(_ => block)

  val RB = ReactComponentB

  def SimpleB(name: String) =
    RB[Unit](name)
      .stateless
      .backend(new Backend(_))

}
