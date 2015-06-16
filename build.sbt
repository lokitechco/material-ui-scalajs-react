enablePlugins(SbtHttpServerPlugin)

updateOptions := updateOptions.value.withCachedResolution(true)

import wav.devtools.sbt.httpserver.{SbtHttpServerPlugin,FileServer}
import SbtHttpServerPlugin.autoImport._

def serveProject(project: Project, config: Configuration) = Def.setting {
  FileServer.service(s"${project.id}/${config.name}",
    Seq((classDirectory in config in project).value,
        (classDirectory in config in project).value.getParentFile()))
}

addHttpServices(
//  _ += _dirsToServe(`mui-wrapper`, Test).value,
  _ += serveProject(`mui-wrapper-sampler`, Compile).value //,
//  _ += _dirsToServe(`mui-wrapper-sampler`, Test).value
)

addHttpServices(httpServerBuildServices)

lazy val browse = inputKey[Unit]("open the project in the browser")

def browseProject(project: Project, config: Configuration) =
  browse in project in config := {
    val args: Seq[String] = Def.spaceDelimited("<arg>").parsed
    (fastOptJS in config in project).value
    val target = args match {
      case Seq("http") =>
        HttpServerKeys.httpServerAddress.value + s"/${project.id}/${config.name}/index-sbt.html#"
      case _ =>
        val f = (classDirectory in config in project).value / "index-filesystem.html#"
        "file://" + f.getCanonicalPath
    }
    streams.value.log(s"opening $target")
    java.awt.Desktop.getDesktop.browse(uri(target))
  }

//browseProject(`mui-wrapper`, Test)
browseProject(`mui-wrapper-sampler`, Compile)
//browseProject(`mui-wrapper-sampler`, Test)

addCommandAlias("sampler", "mui-wrapper-sampler/compile:browse http")