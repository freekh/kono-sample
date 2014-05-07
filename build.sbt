lazy val restService = project.in(file("rest-service")).dependsOn(dbApi)

lazy val dbApi = project.in(file("db-api"))


