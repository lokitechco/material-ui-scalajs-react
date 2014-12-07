import sbt._
import Keys._
import scala.scalajs.sbtplugin.ScalaJSPlugin._
import scala.scalajs.sbtplugin.ScalaJSPlugin.ScalaJSKeys._

object Common {

	lazy val commonSettings = scalaJSSettings ++ Seq(
		organization in ThisBuild := "wav.web",
		scalaVersion in ThisBuild := "2.11.4",
		scalacOptions in ThisBuild ++= Seq("-deprecation", "-unchecked", "-feature",
			"-language:postfixOps", "-language:implicitConversions",
			"-language:higherKinds", "-language:existentials"),
		muiDependencies) 
	
	lazy val muiDependencies = libraryDependencies ++= Seq(
		"com.github.japgolly.scalajs-react" %%% "core" % "0.6.0",
		"com.github.japgolly.scalajs-react" %%% "test" % "0.6.0" % "test",
		"com.github.japgolly.scalajs-react" %%% "ext-scalaz71" % "0.6.0",
		"org.scala-lang.modules.scalajs" %%% "scalajs-dom" % "0.6",
		"com.scalatags" %%% "scalatags" % "0.4.2")

	lazy val muiJsDependencies = jsDependencies += "org.webjars" % "react" % "0.12.1" % "compile" / "react-with-addons.js" commonJSName "React"

}