// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.18")

// web plugins
/*
addSbtPlugin("com.typesafe.sbt" % "sbt-web-build-base" % "1.0.0")

*/

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.1.4")

addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.4")

addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.8")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.0")

addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.4.6")

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

/*
ez asszem nem kell
resolvers ++= Seq(
  Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
  Resolver.sonatypeRepo("snapshots"),
  "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
)
*/

