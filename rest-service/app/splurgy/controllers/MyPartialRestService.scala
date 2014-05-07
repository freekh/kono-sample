package splurgy.controllers

import play.api._
import play.api.mvc._
import splurgy.models.TestData
import play.api.libs.json.Json
import play.api.db.slick._
import splurgy.backend.models.DBData

object MyPartialRestService extends Controller { //split your controllers into meaningful names!
  import splurgy.models.DAO._
  
  def write = DBAction(BodyParsers.parse.json) { implicit rs => //notice the implicit? we use it for the insert later on!
    Json.fromJson[TestData](rs.body).fold(
      error => BadRequest(Json.parse("""{"message": "could not parse"}""")),
      testData => { //open brace sine there are more than 2 lines
        val id = testData.insert
        Ok(Json.parse(s"""{"message": "inserted data:${id}"}""")) //notice the s? it means interpolated string! JUST KNOW: it is not safe to return a internal DB id like this, but we do it for this sample
      })
  }

  def read(page: Int) = DBAction {  implicit rs => //testdata is the name of your end point
    Ok(Json.toJson(TestData.getPage(page))) //we have a format in TestData companion object so we can convert this List to Json automatically. Also json is typed so you get the right MIME type
  }

}