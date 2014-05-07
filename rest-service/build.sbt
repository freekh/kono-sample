name := "rest-service"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  Dependencies.playSlick
)     

play.Project.playScalaSettings
