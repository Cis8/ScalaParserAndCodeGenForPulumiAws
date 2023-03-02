val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scalaparserandcodegen",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies += "com.github.javaparser" % "javaparser-core" % "3.24.10",
    libraryDependencies += "com.google.guava" % "guava" % "31.0.1-jre"

  )
