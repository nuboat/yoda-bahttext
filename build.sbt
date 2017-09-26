organization := "in.norbor"

name := "yoda-bahttext"

version := "1.0b"

crossPaths := false

autoScalaLibrary := false

javacOptions ++= Seq("-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % "test"
  , "junit" % "junit" % "4.12" % "test"
)

publishTo := Some(
  if (isSnapshot.value) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging
)
