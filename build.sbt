name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test

/*
libraryDependencies += "org.webjars.npm" % "atob" % "2.0.0"
libraryDependencies += "org.webjars.npm" % "minimist" % "0.0.10"
libraryDependencies += "org.webjars.npm" % "liftoff" % "2.5.0"
libraryDependencies += "org.webjars.npm" % "tildify" % "1.2.0"
libraryDependencies += "org.webjars.npm" % "pretty-hrtime" % "1.0.3"
libraryDependencies += "org.webjars.npm" % "archy" % "1.0.0"
libraryDependencies += "org.webjars.npm" % "interpret" % "1.1.0"

libraryDependencies += "org.webjars.npm" % "gulp" % "3.8.7"

dependencyOverrides += "org.webjars.npm" % "atob" % "2.0.0"
dependencyOverrides += "org.webjars.npm" % "minimist" % "0.0.10"
dependencyOverrides += "org.webjars.npm" % "liftoff" % "2.5.0"
dependencyOverrides += "org.webjars.npm" % "tildify" % "1.2.0"
dependencyOverrides += "org.webjars.npm" % "pretty-hrtime" % "1.0.3"
dependencyOverrides += "org.webjars.npm" % "archy" % "1.0.0"
dependencyOverrides += "org.webjars.npm" % "interpret" % "1.1.0"

addSbtJsEngine("1.1.4")
*/
