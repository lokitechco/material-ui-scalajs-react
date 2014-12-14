Common.commonSettings

name := "material-ui"

lazy val root = (project in file("."))
	.dependsOn(macros)

lazy val macros = (project in file("macros"))

lazy val sampler = (project in file("sampler"))
	.dependsOn(root)

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value % "compile" // macros for root and macros.

resourceGenerators in Compile <+= Def.task {
	val dir = (resourceDirectory in Compile).value
	val muiCss = dir / "material-ui.css"
	val muiJs = dir / "material-ui.js"
	val reactJs = dir / "react-bundle.js"
	if (!muiCss.exists || !muiJs.exists || !reactJs.exists) {
		"npm install browserify -g" !;
		"npm install reactify" !;
		"npm install less" !;
		s"npm install material-ui@${Common.muiVersion}" !;
		s"lessc src/main/less/material-ui.less ${muiCss.getCanonicalPath}" !;
		// tap must be contained in the react bundle!
		s"browserify -t reactify -r react -r react/addons -r react-tap-event-plugin -o ${reactJs.getCanonicalPath}" !;
		s"browserify -t reactify -r material-ui -x react -x react/addons -o ${muiJs.getCanonicalPath}" !;
	}
    Seq(muiCss, muiJs, reactJs)
}

run := (run in sampler).evaluated

import scala.scalajs.sbtplugin.ScalaJSPlugin.ScalaJSKeys

(ScalaJSKeys.fastOptJS in Compile in sampler) <<= (ScalaJSKeys.fastOptJS in Compile in sampler) dependsOn (ScalaJSKeys.fastOptJS in Compile in root)