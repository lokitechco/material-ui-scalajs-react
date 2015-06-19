#!/bin/bash

app=mui-wrapper-sampler
baseDir=`pwd`
targetDir=sampler/target/scala-2.11

opt=$1

if [[ "$opt" == "full" ]]; then
  sbt $app/fullOptJS
    resources=(
    $app-jsdeps.min.js
    $app-opt.js
    $app-opt.js.map
    classes/start.js
  )
elif [[ "$opt" == "fast" ]]; then
  sbt $app/fastOptJS
  resources=(
    classes/react-bundle.js
    classes/material-ui.js
    $app-fastopt.js
    $app-fastopt.js.map
    classes/start.js
  )
elif [[ "$opt" == "skip" ]]; then
  # do nothing.
 echo "skipping sbt step"
else
  echo "Usage: make-site.sh full|fast|skip" 1>&2 && exit 1
fi

rm -Rf site
mkdir site

links=""
for res in ${resources[@]}; do
  name=`basename $res`
  cp "$targetDir/$res" "site/`basename $name`" || exit 1
  if [[ "$res" == *.js ]] && [[ "$name" != "start.js" ]]; then
    links+="    <script type=\"text/javascript\" src=\"$name\"></script>
"
  fi
done

git add site

cat<<HTML>site/index.html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Material UI - ScalaJS sampler</title>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.6/styles/default.min.css">
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.6/highlight.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/8.6/languages/scala.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
$links
</head>
<body>
    <script type="text/javascript" src="start.js"></script>
</body>
</html>
HTML

echo 'before `git push` to gh-pages, check `open ../'$app'-gh-pages/public/index.html`'
echo "More steps: clone the repo, switch to the gh-pages branch, copy the site/* resources then push."
