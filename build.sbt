Common.commonSettings

name := "material-ui"

lazy val root = (project in file("."))

lazy val sampler = (project in file("sampler"))
	.dependsOn(root)

resourceGenerators in Compile <+= Def.task {
	val dir = (resourceManaged in Compile).value
	val targetCss = dir / "material-ui.css"
	val targetJs = dir / "material-ui.js"
	if (!targetCss.exists || !targetJs.exists) {
		"npm install browserify -g" !;
		"npm install reactify" !;
		"npm install material-ui" !;
		"npm install less" !;
		s"lessc src/main/less/material-ui.less ${targetCss.getCanonicalPath}" !;
		("browserify -t reactify -im -s mui -u react/addons -u react" + 
			" --no-bundle-external node_modules/material-ui/src/index.js" + 
			s" -o ${targetJs.getCanonicalPath}") !;
	}
    Seq(targetCss, targetJs)
}

run := (run in sampler).value