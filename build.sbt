ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.0.0"

lazy val root = (project in file("."))
  .settings(
    name := "adventofcode2021"
  )
  .settings(libraryDependencies ++= dependencies)

lazy val dependencies = Seq(
  "org.scalatest"  %% "scalatest"     % "3.2.10"  % "test"
)