name := "aws-lambda-demo"

version := "1.0"

scalaVersion := "2.12.4"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

lazy val root = (project in file(".")).
  settings(
    retrieveManaged := true,
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
    "com.amazonaws" % "aws-lambda-java-core" % "1.2.0",
    "com.amazonaws" % "aws-lambda-java-events" % "2.0.2",
    "org.postgresql" % "postgresql" % "42.1.4"
    )
  )
