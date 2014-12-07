Common.commonSettings

Common.muiJsDependencies

name := "material-ui-sampler"

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
	val mcss = dir / "material-ui.css"
	IO.copyFile(materialUI / mjs.getName, mjs)
	IO.copyFile(materialUI / mcss.getName, mcss)
	val react: File = getContainer(m => m.organization == "org.webjars" && m.name == "react")
	val reactjs = dir / "react-with-addons.js"
	IO.write(reactjs, readTextFromJar(react, "META-INF/resources/webjars/react/0.12.1/react-with-addons.js"))
	Seq(mjs,mcss,reactjs)
}

run := {
	val url = "file:" + ((crossTarget in Compile).value / "classes" / "index.html").getCanonicalPath
	java.awt.Desktop.getDesktop.browse(new java.net.URI(url))
}

import scala.scalajs.sbtplugin.ScalaJSPlugin.ScalaJSKeys

run <<= run dependsOn(copyResources in Compile, ScalaJSKeys.fastOptJS in Compile)