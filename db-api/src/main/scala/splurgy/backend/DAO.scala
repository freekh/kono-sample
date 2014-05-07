package splurgy.backend

import scala.slick.driver.JdbcProfile
import splurgy.backend.models.DBData
import scala.slick.lifted.TableQuery
import splurgy.backend.models.DBDataComponent

class DAO(val profile: JdbcProfile) extends DBDataComponent {
  val DBDatas = TableQuery[DBDataTable] //expose the table
}
