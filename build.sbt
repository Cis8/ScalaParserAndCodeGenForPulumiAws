val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scalaparserandcodegen",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,
    
    scalacOptions ++= Seq(
      "-Xcheck-macros"
    ),

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies += "com.github.javaparser" % "javaparser-core" % "3.25.1",
    libraryDependencies += "com.google.guava" % "guava" % "31.0.1-jre",
    libraryDependencies += "com.pulumi" % "aws" % "5.32.0"

  )
