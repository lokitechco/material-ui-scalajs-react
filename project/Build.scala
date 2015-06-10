import sbt._
import Keys._

import org.scalajs.sbtplugin.ScalaJSPlugin
import ScalaJSPlugin._
import ScalaJSPlugin.autoImport._
import wav.devtools.sbt.httpserver.Import.emitBuildEvent

object Mui extends Build {

    val reactV = "0.13.3"

    val muiV = "0.9.0"

    val commonSettings = Seq(
        organization := "wav.web.wrappers",
        version := muiV + ".1-SNAPSHOT",
        scalaVersion := "2.11.6",
        scalacOptions ++= Seq(
          "-deprecation", "-unchecked", "-feature",
          "-language:implicitConversions",
          "-language:higherKinds"),
        resolvers += Resolver.url("wav", url("https://dl.bintray.com/wav/maven"))(Resolver.ivyStylePatterns))

    val muiSources = Def.task {
      val dir = (resourceDirectory in Compile).value
      if (!dir.exists) dir.mkdirs
      val targets @ Seq(muiJs, reactJs) = Seq("material-ui.js", "react-bundle.js").map(dir / _)
      IO.write(file("package.json"),s"""{"dependencies" : {"material-ui" : "$muiV", "react" : "$reactV"}}""")
      if (!targets.forall(_.exists)) {
        "npm install browserify -g".!;
        "npm install reactify -g".!;
        "npm install".!;
        s"browserify -t reactify -r react -r react/addons -r react-tap-event-plugin -o ${reactJs.getCanonicalPath}".!;
        s"browserify -t reactify -r material-ui -x react -x react/addons -o ${muiJs.getCanonicalPath}".!;
      }
      targets
    }

    lazy val `mui-wrapper` = (project in file("."))
      .enablePlugins(ScalaJSPlugin)
      .dependsOn(`scalajs-react`)
      .settings(commonSettings: _*)
      .settings(
        resourceGenerators in Compile <+= muiSources,
        libraryDependencies ++= Seq(
          "wav.common" %% "scala-macros" % "0.1.0"
        //  "com.github.japgolly.scalajs-react" %%% "core" % "0.9.0"
        ))

    // Caveat: must use modified version that allows a context to be set.
    // lazy val `scalajs-react` = ProjectRef(file("vendor/scalajs-react"), "core")
    lazy val `scalajs-react` = ProjectRef(uri("https://github.com/wav/scalajs-react.git#context-hack"), "core")

    lazy val `mui-wrapper-sampler` = project.in(file("sampler"))
      .enablePlugins(ScalaJSPlugin)
      .settings(commonSettings: _*)
      .dependsOn(`mui-wrapper`)
      .settings(
        emitBuildEvent(fastOptJS in Compile, "compiled"), // Why can't this live in build.sbt ?!?
        libraryDependencies += "wav.devtools" %%% "sbt-httpserver-buildservice" % "0.3.1", // see dev.sbt
        resourceGenerators in Compile <+= Def.task {
          val mui = (resourceDirectory in Compile in `mui-wrapper`).value
          val muiFiles = (mui ** ("*.js" || "*.css" || "*.eot" || "*.svg" || "*.svg" || "*.ttf" || "*.woff")).filter(_.isFile).get
          import Path.rebase
          val mappings = muiFiles pair rebase(Seq(mui), (resourceManaged in Compile).value)
          IO.copy(mappings, true)
          mappings.map(_._2)
        })

}