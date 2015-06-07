import org.scalajs.core.ir.ScalaJSVersions.{current => currentScalaJSVersion}

enablePlugins(ScalaJSPlugin)

scalaVersion in ThisBuild := "2.11.6"

organization in ThisBuild := "wav.web.wrappers"

val reactV = "0.13.3"

val muiV = "0.8.0"

version := muiV + ".1-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.6"

val muiSourceNames = Seq("material-ui.js", "react-bundle.js")

val muiSources = Def.task {
  val dir = (resourceDirectory in Compile).value
  if (!dir.exists) dir.mkdirs
  val targets @ Seq(muiJs, reactJs) = muiSourceNames.map(dir / _)
  IO.write(file("package.json"),s"""{"dependencies" : {"material-ui" : "$muiV", "react" : "$reactV"}}""")
  if (!targets.forall(_.exists)) {
    "npm install browserify -g" !;
    "npm install reactify -g" !;
    "npm install" !;
    s"browserify -t reactify -r react -r react/addons -r react-tap-event-plugin -o ${reactJs.getCanonicalPath}" !;
    s"browserify -t reactify -r material-ui -x react -x react/addons -o ${muiJs.getCanonicalPath}" !;
  }
  targets
}

lazy val `mui-wrapper` = (project in file("."))
  .dependsOn(`scalajs-react`)
  .settings(
    resourceGenerators in Compile <+= muiSources,
    resolvers ++= Seq(
      Resolver.url("wav", url("https://dl.bintray.com/wav/maven"))(Resolver.ivyStylePatterns)),
    libraryDependencies ++= Seq(
      "wav.common" %% "scala-macros" % "0.1.0"
    //  "com.github.japgolly.scalajs-react" %%% "core" % "0.9.0"
    ))

// Caveat: must use modified version that allows a context to be set.
// lazy val `scalajs-react` = ProjectRef(file("vendor/scalajs-react"), "core")
lazy val `scalajs-react` = ProjectRef(uri("https://github.com/wav/scalajs-react.git#context-hack"), "core")

lazy val `mui-wrapper-sampler` = project.in(file("sampler"))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(`mui-wrapper`)
  .settings(
    defaultLocation := "index.html#",
    resourceGenerators in Compile <+= Def.task {
      val mui = (resourceDirectory in Compile in `mui-wrapper`).value
      val muiFiles = (mui ** ("*.js" || "*.css" || "*.eot" || "*.svg" || "*.svg" || "*.ttf" || "*.woff")).filter(_.isFile).get
      import Path.rebase
      val mappings = muiFiles pair rebase(Seq(mui), (resourceManaged in Compile).value)
      IO.copy(mappings, true)
      mappings.map(_._2)
    })

lazy val defaultLocation = settingKey[String]("The target html,query and hash to open the sampler to in the browser")

lazy val sampler = taskKey[Unit]("open the sampler in the browser")

sampler in ThisBuild := {
  (fastOptJS in Compile in `mui-wrapper-sampler`).value
  val wrapper = (crossTarget in Compile in `mui-wrapper-sampler`).value / "classes" / s"${(defaultLocation in `mui-wrapper-sampler`).value}"
  java.awt.Desktop.getDesktop.browse(uri(s"file:${wrapper.getCanonicalPath}"))
}

scalacOptions in ThisBuild ++= Seq(
  "-deprecation", "-unchecked", "-feature",
  "-language:implicitConversions",
  "-language:higherKinds")

updateOptions := updateOptions.value.withCachedResolution(true)