## What's this?

It's a ScalaJS wrapper of [material-ui.com](material-ui.com) for use with [scalajs-react](https://github.com/japgolly/scalajs-react)

## Development notes

Open the sampler in the browser with `sbt run`.

To update Material UI delete the `material-ui.js` and `material-ui.css` in the resources directory.

Wrappers are simply case classes that represent the React Props object. A macro creates the actual `js.Object` and method that accepts child props/elements.

If something doesn't work, inspect the underlying js.Object in the console.