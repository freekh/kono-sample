package splurgy.backend.models

import scala.slick.lifted.Tag
import splurgy.backend.DAO

case class DBData(foo: String, bar: String, id: Option[Long] = None)

trait DBDataComponent { this: DAO => //<- step 1: you must add this "self-type"
  import profile.simple._ //<- step 2: then import the correct Table, ... from the profile

  class DBDataTable(tag: Tag) extends Table[DBData](tag, "DBDATA") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def foo = column[String]("FOO")
    def bar = column[String]("BAR", O.NotNull)

    def * = (foo, bar, id.?) <> (DBData.tupled, DBData.unapply _)
  }
}


