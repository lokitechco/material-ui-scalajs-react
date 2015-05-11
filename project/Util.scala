import sbt._
import Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Util {

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

}