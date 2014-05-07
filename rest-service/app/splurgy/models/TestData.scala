package splurgy.models

import play.api.libs.json.Json
import play.api.libs.json.Format
import splurgy.backend.models.DBData

import DAO.profile.simple._ //this makes it possible to insert later
import DAO.DBDatas

case class TestData(foo: String, bar: String) {
  def toJson = Json.toJson(this)

  def toDBData = DBData(foo, bar, None)

  def insert(implicit session: Session): Long = { //notice the returnig
    //THIS means not to return auto inc: DBDatas  += toDBData 
    (DBDatas returning DBDatas.map(_.id)) += toDBData  //executing (!) insert
  }

}

object TestData {
  def fromDBData(dbData: DBData) = TestData(dbData.foo, dbData.bar)

  def getPage(page: Int, pageSize: Int = 100)(implicit session: Session) = {
    val allDBData: List[DBData] = DBDatas //notice types!
      .drop(page) // for pagination
      .take(pageSize) // also for pagination
      .list() //executing (!) list

    allDBData.map(TestData.fromDBData) //same as map{ dbData => TestData.fromDBData(dbData) } ;)
  }

  implicit val format: Format[TestData] = Json.format[TestData]
}
