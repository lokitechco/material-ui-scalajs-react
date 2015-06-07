enablePlugins(ScalaJSPlugin)

scalaVersion := "2.11.6"

lazy val `mui-wrapper` = ProjectRef(uri("https://github.com/wav/material-ui-scalajs-react.git"), "mui-wrapper")

lazy val app = project.in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(`mui-wrapper`)
  .settings(
    persistLauncher in Compile := true,
    persistLauncher in Test := false,
    resourceGenerators in Compile <+= Def.task {
      val log = streams.value.log
      log.info(s"APP: ${((classDirectory in Compile).value / "material-ui-app.html").getCanonicalPath}")
      val mui = (resourceDirectory in Compile in `mui-wrapper`).value
      val muiFiles = (mui ** ("*.js" || "*.css" || "*.eot" || "*.svg" || "*.svg" || "*.ttf" || "*.woff" || "*.html")).filter(_.isFile).get
      import Path.rebase
      val mappings = muiFiles pair rebase(Seq(mui), (resourceManaged in Compile).value)
      IO.copy(mappings, true)
      mappings.map(_._2)
    })

updateOptions := updateOptions.value.withCachedResolution(true)