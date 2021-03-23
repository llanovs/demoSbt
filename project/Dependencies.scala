import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.2"

  //add additional dependencies here
  lazy val junit = "junit" % "junit" % "4.13.1" % Test
}
