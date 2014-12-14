## What's this?

It's a ScalaJS wrapper of [material-ui.com](material-ui.com) for use with [scalajs-react](https://github.com/japgolly/scalajs-react)

Wrappers in this project are simply case classes that represent props in react object. A macro creates the actual `js.Object` and a method that accepts "child props"/elements.

[Demo Site](http://wav.github.io/material-ui-scalajs-react/classes/index.html)

## Status

At this stage, this is an experiment (low priority).

## Development notes

Open the sampler in the browser with `sbt run`.

To update Material UI delete the `material-ui.js` and `material-ui.css` in the resources directory.

If something doesn't work, inspect the underlying js.Object's in the console.

To make the site, run `sbt run && make-site.sh`, then clone and push the `gh-branch` using the `site` directory as the base of the repository