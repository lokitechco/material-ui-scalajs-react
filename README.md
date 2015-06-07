## What's this?

It's a ScalaJS wrapper of [material-ui.com](http://material-ui.com) for use with [scalajs-react](https://github.com/japgolly/scalajs-react)

Wrappers in this project are simply case classes that represent props in react object. A macro creates the actual `js.Object` and a method that accepts "child props"/elements.

[Demo Site](http://wav.github.io/material-ui-scalajs-react/classes/index.html)

## Status

At this stage, this is an experiment (low priority).

## Usage

Bootstrap with [resources](src/main/resources/material-ui-template.html)

See the [example build](example)

Reference this project in your build and use it's resources.

## Caveats

- `scalajs-react` currently doesn't have a way to define a react context. A fork is used as a hack.

- The react bundle (prepared with browserify) in this project must be used.

## Sampler

Open the sampler in the browser with `sbt sampler`.

## Development notes

To update Material UI delete the `material-ui.js` in the resources directory.

If something doesn't work, inspect the underlying js.Object's in the console.

To make the site, run `sbt run && make-site.sh`, then clone and push the `gh-branch` using the `site` directory as the base of the repository