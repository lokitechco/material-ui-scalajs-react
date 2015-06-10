enablePlugins(SbtHttpServerPlugin)

updateOptions := updateOptions.value.withCachedResolution(true)

import wav.devtools.sbt.httpserver.{SbtHttpServerPlugin,FileServer}
import SbtHttpServerPlugin.autoImport._

// Host the app at "http://localhost:8083/app/index.html"
addHttpServices(
  _ += FileServer.service("app",Seq(
    (classDirectory in Compile in `mui-wrapper-sampler`).value,
    (classDirectory in Compile in `mui-wrapper-sampler`).value.getParentFile())))

addHttpServices(httpServerBuildServices)

lazy val sampler = inputKey[Unit]("open the sampler in the browser")

sampler in ThisBuild := {
  (fastOptJS in Compile in `mui-wrapper-sampler`).value
  val args: Seq[String] = Def.spaceDelimited("<arg>").parsed
  val target = args match {
    case Seq("http") =>
        HttpServerKeys.httpServerAddress.value + "/app/index-sbt.html#"
    case _ =>
        val f = (classDirectory in Compile in `mui-wrapper-sampler`).value / "index-filesystem.html#"
        "file://" + f.getCanonicalPath
  }
  streams.value.log(s"opening $target")
  java.awt.Desktop.getDesktop.browse(uri(target))
}