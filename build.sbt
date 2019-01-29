name := "scala-database-examples"

version := "0.1"

scalaVersion := "2.12.8"

//libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.11"

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "8.0.11",
  "commons-dbcp" % "commons-dbcp" % "1.4",
  "org.springframework" % "spring-core" % "3.1+",
  "org.springframework" % "spring-beans" % "3.1+",
  "org.springframework" % "spring-jdbc" % "3.1+",
  "org.springframework" % "spring-tx" % "3.1+"
)