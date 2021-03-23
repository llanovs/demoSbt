import Dependencies._

ThisBuild / scalaVersion     := "2.13.4"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val dependenciesDiff = taskKey[Classpath]("dependencies diff between Compile and Test scope")

lazy val root = (project in file("."))
  .settings(
    name := "playground",
    libraryDependencies += scalaTest % Test,
    dependenciesDiff := Def.task{
      val testJar = (Test/fullClasspathAsJars).value
      val compileJar = (fullClasspathAsJars in Compile).value
      testJar.filterNot(x => compileJar.contains(x))
    }.value
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.