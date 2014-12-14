Common.commonSettings

name := "material-ui-sampler"

lazy val defaultLocation = settingKey[String]("The default query/hash to open in the run task")

defaultLocation := "#"

def readTextFromJar(jar: File, path: String): String = {
    import java.io._
    import java.util.jar._
    import java.util.zip._
    val jarFile = new JarFile(jar.getCanonicalPath)
    val entry = jarFile.getEntry(path)
    val inStream = new BufferedInputStream(jarFile.getInputStream(entry))
    var s = ""
    var bytesRead = 0
    val buffer = new Array[Byte](2048)
    do {
      s += new String(buffer, 0, bytesRead)
      bytesRead = inStream.read(buffer)
    } while (bytesRead != -1)
    s
}

resourceGenerators in Compile <+= Def.task {
	val dir = (resourceManaged in Compile).value
	val mk = AttributeKey[ModuleID]("module-id")
	def getContainer(f: ModuleID => Boolean): File =
		(dependencyClasspath in Compile).value.find(_.get(mk).map(f).getOrElse(false)).get.data
	val materialUI: File = getContainer(m => m.organization == organization.value && m.name == "material-ui")
	val mjs = dir / "material-ui.js"
	IO.copyFile(materialUI / mjs.getName, mjs)
	val mcss = dir / "material-ui.css"
	IO.copyFile(materialUI / mcss.getName, mcss)
	val reactjs = dir / "react-bundle.js"
	IO.copyFile(materialUI / reactjs.getName, reactjs)
	// val modernizr: File = getContainer(m => m.organization == "org.webjars" && m.name == "modernizr")
	// val modernizrjs = dir / "modernizr.js"
	// IO.write(modernizrjs, readTextFromJar(modernizr, "META-INF/resources/webjars/modernizr/2.8.3/modernizr.js"))
	Seq(mjs,mcss,reactjs)
}

run := {
	val url = "file:" + ((crossTarget in Compile).value / "classes" / s"index.html${defaultLocation.value}").getCanonicalPath
	java.awt.Desktop.getDesktop.browse(new java.net.URI(url))
}

import scala.scalajs.sbtplugin.ScalaJSPlugin.ScalaJSKeys

run <<= run dependsOn(copyResources in Compile, ScalaJSKeys.fastOptJS in Compile)