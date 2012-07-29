import sbt._
import Keys._
import com.twitter.sbt._
import com.typesafe.startscript.StartScriptPlugin

name            := "foo"

version         := "0.1"

organization    := "com.foo"

scalaVersion    := "2.9.1"

// Add Twitter's Repository
resolvers += "twitter.com" at "http://maven.twttr.com/"

// Add multiple dependencies
libraryDependencies ++= Seq(
    "org.apache.thrift" % "libthrift" % "0.8.0" intransitive,
    "com.twitter" %% "finagle-core" % "3.0.0",
    "com.twitter" %% "finagle-thrift" % "3.0.0",
    "org.jboss.netty" % "netty" % "3.2.6.Final",
    "com.twitter" %% "scrooge-runtime" % "1.1.3",
    "org.scalatest" %% "scalatest" % "1.8" % "test"
)

seq(StartScriptPlugin.startScriptForJarSettings: _*)

seq(CompileThriftScrooge.newSettings: _*)

CompileThriftScrooge.scroogeVersion := "2.5.4"

CompileThriftScrooge.scroogeBuildOptions := List("--finagle")

PackageDist.packageDistConfigFilesValidationRegex := Some(".*")

mainClass in Compile := Some("com.foo.EchoServer")

