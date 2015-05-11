enablePlugins(ScalaJSPlugin)

organization in ThisBuild := "wav.web"

scalaVersion in ThisBuild := "2.11.6"

scalacOptions in ThisBuild ++= Seq(
	"-deprecation", "-unchecked", "-feature", 
	"-language:implicitConversions",
	"-language:higherKinds", 
	"-language:existentials")

val muiVersion = "0.5.0"

libraryDependencies in ThisBuild ++= {
	val (react, reactV) = ("com.github.japgolly.scalajs-react", "0.8.4")
	Seq(
		"org.scala-js" %%% "scalajs-dom" % "0.8.0",
		react %%% "core" % reactV,
		react %%% "test" % reactV % "test",
		react %%% "ext-scalaz71" % reactV,
		react %%% "ext-monocle" % reactV)
}

lazy val `mui-wrapper-macros` = project.in(file("macros"))
	.settings(
		libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value % "compile")

lazy val `mui-wrapper` = (project in file("."))
	.dependsOn(`mui-wrapper-macros`)
	.settings(
		resourceGenerators in Compile <+= Def.task {
			val dir = (resourceDirectory in Compile).value
			val targets @ Seq(muiCss, muiJs, reactJs) = Seq("material-ui.css", "material-ui.js", "react-bundle.js").map(dir / _)
			if (!targets.forall(_.exists)) {
				"npm install browserify -g" !;
				"npm install reactify" !;
				"npm install less" !;
				s"npm install material-ui@${muiVersion}" !;
				s"lessc src/main/less/material-ui.less ${muiCss.getCanonicalPath}" !;
				// tap must be contained in the react bundle!
				s"browserify -t reactify -r react -r react/addons -r react-tap-event-plugin -o ${reactJs.getCanonicalPath}" !;
				s"browserify -t reactify -r material-ui -x react -x react/addons -o ${muiJs.getCanonicalPath}" !;
			}
			targets
	    })

lazy val `mui-wrapper-sampler` = project.in(file("sampler"))
	.enablePlugins(ScalaJSPlugin)
	.dependsOn(`mui-wrapper-macros`, `mui-wrapper`)
	.settings(
		defaultLocation := "index.html#",
		resourceGenerators in Compile <+= Def.task {
			val dir = (resourceManaged in Compile).value
			val mk = AttributeKey[ModuleID]("module-id")
			def getContainer(f: ModuleID => Boolean): File =
				(dependencyClasspath in Compile).value.find(_.get(mk).map(f).getOrElse(false)).get.data
			val materialUI = getContainer(m => m.organization == organization.value && m.name == "mui-wrapper")
			val targets @ Seq(muiCss, muiJs, reactJs) = Seq("material-ui.css", "material-ui.js", "react-bundle.js").map(dir / _)
			targets.foreach(f => IO.copyFile(materialUI / f.getName, f))
			targets
		})

lazy val defaultLocation = settingKey[String]("The target html,query and hash to open the sampler to in the browser")

lazy val sampler = taskKey[Unit]("open the sampler in the browser")

sampler in ThisBuild := {
	(copyResources in Compile in `mui-wrapper-sampler`).value
	(fastOptJS in Compile in `mui-wrapper-sampler`).value
	val wrapper = (crossTarget in Compile in `mui-wrapper-sampler`).value / "classes" / s"${(defaultLocation in `mui-wrapper-sampler`).value}"
	java.awt.Desktop.getDesktop.browse(uri(s"file:${wrapper.getCanonicalPath}"))
}