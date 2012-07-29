addSbtPlugin("com.typesafe.startscript" % "xsbt-start-script-plugin" % "0.5.1")

//addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.0-RC1")

resolvers += Classpaths.typesafeResolver

addSbtPlugin("com.twitter" %% "sbt11-scrooge" % "1.0.0")

addSbtPlugin("com.twitter" %% "sbt-package-dist" % "1.0.0")

resolvers += "twitter-repo" at "http://maven.twttr.com"

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.1.0-SNAPSHOT")

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
