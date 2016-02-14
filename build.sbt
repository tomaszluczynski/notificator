name := "notificator"

organization  := "biz.hexworx"

version := "0.0.1"

scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

/* This is jrebel configuration - not used right now */
//javaOptions ++=Seq("-javaagent:/Users/tomek/code/jrebel/jrebel.jar","-Drebel.log=true",
//  "-Drebel.log.file=/Users/tomek/code/jrebel/jrebel.log")


libraryDependencies ++= {
  val akkaStreamVersion = "2.0.3"
  val akkaVersion = "2.4.1"

  Seq(
    "com.typesafe.akka" %% "akka-actor"                           % akkaVersion,
    "com.typesafe.akka" %% "akka-stream-experimental"             % akkaStreamVersion,
    "com.typesafe.akka" %% "akka-http-experimental"               % akkaStreamVersion,
    "com.typesafe.akka" %% "akka-http-core-experimental"          % akkaStreamVersion,
    "com.typesafe.akka" %% "akka-http-testkit-experimental"       % akkaStreamVersion,
    "org.scalatest"     %% "scalatest"                            % "2.2.5" % "test",
    "com.typesafe.akka" %% "akka-testkit"                         % akkaVersion % "test"
  )
}


fork in run := true