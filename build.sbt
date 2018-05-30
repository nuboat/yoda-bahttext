organization := "in.norbor"

name := "yoda-bahttext"

version := "1.0.1"

crossPaths := false

autoScalaLibrary := false

javacOptions ++= Seq("-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % "test"
  , "junit" % "junit" % "4.12" % "test"
  , "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)

publishTo := Some(
  if (isSnapshot.value) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging
)
