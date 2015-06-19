package wav.web.muiwrapper.sampler

import japgolly.scalajs.react._
import scala.scalajs.js, js.{Object, UndefOr, Dictionary, Function, undefined}, js.Dynamic.{global => g}, js.JSConverters._
import org.scalajs.dom._

object Syntax {

  object log {
    @inline def info(args: js.Any*) = g.console.log(args.toJsArray)
    @inline def debug(args: js.Any*) = g.console.debug(args.toJsArray)
    @inline def warn(args: js.Any*) = g.console.warn(args.toJsArray)
  }

  val RB = ReactComponentB

  def dynamicB[P](name: String)(content: P => ReactElement) =
    RB[P](name)
      .stateless
      .noBackend
      .render((p, _, _) => content(p))

  def simpleB[P](name: String)(content: (P, SimpleBackend[P, Unit]) => ReactElement) =
    RB[P](name)
      .stateless
      .backend(SimpleBackend[P, Unit](_))
      .render((p, _, b) => content(p, b))

  case class SimpleBackend[P, S](T: BackendScope[P, S]) extends RunnableBackendScope[P, S]

  trait RunnableBackendScope[A, B] {
    val T: BackendScope[A, B]

    def foreach(run: BackendScope[A, B] => Unit): Unit = run(T)
  }

  implicit class MRef[M <: TopNode](ref: RefSimple[M]) {
    @inline def M(c: ReactComponentM_[_])(run: M => Unit): Unit = run(ref(c).get.asInstanceOf[M])

    @inline def M(sc: ComponentScope_M[_])(run: M => Unit): Unit = run(ref(sc).get.asInstanceOf[M])

    @inline def M[A, B](b: RunnableBackendScope[A, B])(run: M => Unit): Unit = b.foreach(M(_)(run))
  }

  @inline implicit def stringDictToObject(d: Dictionary[String]): UndefOr[Object] = d.asInstanceOf[Object]

  def ?[T](v: T): UndefOr[T] = v

  @inline def handler[E <: SyntheticEvent[Node]](f: E => Unit) = Some(f)

  @inline def handler[E <: SyntheticEvent[Node]](block: => Unit): Option[E => Unit] = handler(_ => block)

}
