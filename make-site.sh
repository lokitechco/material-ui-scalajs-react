#~!/bin/bash

# run this after `sbt run`

targetDir=sampler/target/scala-2.11
resources=classes
managedResources=resource_managed/main
mkdir -p site/$managedResources site/$resources
cp $targetDir/material-ui-sampler-fastopt.js site/material-ui-sampler-fastopt.js
cp $targetDir/$resources/index.html site/$resources/index.html
cp $targetDir/$managedResources/* site/$managedResources/.
echo "Clone and push to the gh-branch for this site."