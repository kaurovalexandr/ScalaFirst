name := "ScalaFirst"

version := "0.1"

scalaVersion := "2.13.1"

val circeVersion = "0.12.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "org.scala-lang.modules" %% "scala-xml" % "2.0.0-M1"
)
