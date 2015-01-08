import sbt._
import Keys._
import scala.scalajs.sbtplugin.ScalaJSPlugin._
import scala.scalajs.sbtplugin.ScalaJSPlugin.ScalaJSKeys._

object Common {

	val muiVersion = "0.5.0"

	lazy val commonSettings = scalaJSSettings ++ Seq(
		organization in ThisBuild := "wav.web",
		scalaVersion in ThisBuild := "2.11.4",
		scalacOptions in ThisBuild ++= Seq(
			"-deprecation", "-unchecked", "-feature",
			"-language:postfixOps", "-language:implicitConversions",
			"-language:higherKinds", "-language:existentials"),
		muiDependencies) 
	
	lazy val muiDependencies = libraryDependencies ++= Seq(
		"org.scala-lang.modules.scalajs" %%% "scalajs-dom" % "0.6",
		"com.github.japgolly.scalajs-react" %%% "core" % "0.7.1",
		"com.github.japgolly.scalajs-react" %%% "test" % "0.7.1" % "test",
		"com.github.japgolly.scalajs-react" %%% "ext-scalaz71" % "0.7.1",
		"com.github.japgolly.scalajs-react" %%% "ext-monocle" % "0.7.1")
}