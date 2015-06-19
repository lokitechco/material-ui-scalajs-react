## What's this?

It's a ScalaJS wrapper of [material-ui.com](http://material-ui.com) for use with [scalajs-react](https://github.com/japgolly/scalajs-react)

[Demo Site](http://wav.github.io/material-ui-scalajs-react/public/index.html)

## Status

Alpha status. Wrappers are complete. [Some TODOs](TODO.md) before a release.

#### Approach

Use wrappers.

- Define some typings for the mui library
- Define classes that represent react props based on the mui docs
- Define interfaces for the mounted representation mui components based on the mui docs
- Provide a component builder to integrate with scalajs-react

## Usage

Reference this project in your build and use it's resources.

Bootstrapping the application: [material-ui-app.html](src/main/resources/material-ui-app.html) 

See the [example project](example) and the [sampler](sampler/src/main/scala/wav/web/muiwrapper/sampler/)

Open the sampler in the browser with `sbt sampler`.

## Caveats

- `scalajs-react` currently doesn't have a way to define a react context. A fork is used as a hack.

- The react bundle (prepared with browserify) in this project must be used.