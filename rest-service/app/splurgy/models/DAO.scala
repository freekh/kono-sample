package splurgy.models

import play.api.db.slick.Config

object DAO extends splurgy.backend.DAO(Config.driver) //automatically loads the config