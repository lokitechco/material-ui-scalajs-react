package wav.web.materialui

import scalajs.js
import scala.scalajs.js.Dynamic.{ global => g }
import japgolly.scalajs.react._

trait Builder[T] {
  this: T =>
  implicit val materialUIRefs: MaterialUIRefs
  val muiClass: js.Dynamic
  val toJs: T => js.Object
  def withChildren(children: ReactNode*): ReactComponentU_ =
    materialUIRefs.reactJS.createElement(muiClass, toJs(this), children.toJsArray)
      .asInstanceOf[ReactComponentU_]
  lazy val noChildren: ReactComponentU_ =
    materialUIRefs.reactJS.createElement(muiClass, toJs(this))
      .asInstanceOf[ReactComponentU_]
}

class MountedRef[TElem <: TopNode, TComponent](val refName: String) {
  val ref = Ref[TElem](refName)
  def apply(scope: ComponentScope_M[_]): TComponent =
    ref(scope).asInstanceOf[TComponent]
}

case class MaterialUIRefs(reactJS: js.Dynamic = g.React, mui: js.Dynamic = g.mui)