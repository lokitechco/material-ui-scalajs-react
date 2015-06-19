package wav.web.muiwrapper.sampler.examples

import scalajs.js
import japgolly.scalajs.react._, vdom.prefix_<^._
import wav.web.muiwrapper.mui._
import wav.web.muiwrapper.sampler.Syntax._

object ListsAndMenus {

  import IconsAndInputs.materialIcon

  @inline def iconItem(text: String, id: String): ReactElement =
    ListItem(leftIcon = materialIcon(id))(text)

  @inline def divider: ReactElement =
    ListDivider(inset = true)


  val menuExample =
    (new ClearFix())(
      Menu(
        autoWidth = false,
        text = "Top menu",
        onItemTap = ?((_, _, item) => log.debug("Selected menu item", item)),
        menuItems = js.Array(
          MenuItem(
            text = "Top 1",
            payload = "1"),
          MenuItem(
            text = "Top 2",
            payload = "1"),
          NestedMenuItem(
            text = "Nested menu",
            items = js.Array(
              MenuItem(
                text = "Nested 1",
                number = 1d),
              NestedMenuItem(
                text = "Nested menu",
                items = js.Array(
                  MenuItem(
                    text = "Nested 1",
                    payload = "1"))))),
          MenuItem(
            text = "Top 2",
            payload = "1"))))

  //width:

  val listExample1 =
    Paper()(
      List(
        style = js.Dictionary[String](
          "padding-right" -> "16px"))(
          iconItem("Grade", "grade"),
          divider,
          iconItem("Help", "help"),
          iconItem("History", "history"),
          List(
            subheader = "Settings")(
              iconItem("Assistant", "assistant"),
              iconItem("Flags", "assistant photo")
            )))

  def content() =
    <.div(
      <.div(^.margin := "10px", ^.float.left, listExample1),
      <.div(^.margin := "10px", ^.float.left, menuExample))

}