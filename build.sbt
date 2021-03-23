import Dependencies._

ThisBuild / scalaVersion     := "2.13.4"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

//headers settings/tasks, etc
lazy val dependenciesDiff = taskKey[Classpath]("dependencies diff between Compile and Test scope")
lazy val mySetting = settingKey[String]("My setting")

//setup the projects variables
lazy val domain = project.in(file("domain"))
  //add dependencies to another module
  .dependsOn(boot)

lazy val boot = project.settings(
  //add dependencies to the library(jar)
  libraryDependencies += scalaTest % Test
)

lazy val root = (project in file("."))
  //add modules to project
  .aggregate(domain, boot)
  //enable plugins
  .enablePlugins(spray.revolver.RevolverPlugin)
  .settings(
    name := "playground",
    libraryDependencies += scalaTest % Test,
    //add task algorithms
  )

//Task1
//lazy val root = (project in file("."))
//  .aggregate(domain, boot)
//  .settings(
//    name := "playground",
//    libraryDependencies += scalaTest % Test,
    //task algorithm
    //    dependenciesDiff := Def.task{
    //      val testJar = (Test/fullClasspathAsJars).value
    //      val compileJar = (fullClasspathAsJars in Compile).value
    //      testJar.filterNot(x => compileJar.contains(x))
    //    }.value
//  )
// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.