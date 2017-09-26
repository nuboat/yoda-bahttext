organization := "in.norbor"

name := "yoda-bahttext"

version := "1.0b"

crossPaths := false

autoScalaLibrary := false

javacOptions ++= Seq("-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "org.testng" % "testng" % "6.11" % "test"
)

publishTo := Some(
  if (isSnapshot.value) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging
)
