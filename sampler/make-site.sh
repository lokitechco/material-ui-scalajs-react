#~!/bin/bash

buildDir=sampler/target/scala-2.11
resources=classes
managedResources=resource_managed/main
mkdir -p site/$managedResources site/$resources
sbt "sampler/copyResources; sampler/fastOptJS"
cp $buildDir/material-ui-sampler-fastopt.js site/material-ui-sampler-fastopt.js
cp $buildDir/$resources/index.html site/$resources/index.html
cp $buildDir/$managedResources/* site/$managedResources/.