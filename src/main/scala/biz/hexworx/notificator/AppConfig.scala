package biz.hexworx.notificator

import com.typesafe.config.ConfigFactory

object AppConfig {
  private val config = ConfigFactory.load()

  object SmtpConfig {
    private val smtp = config.getConfig("smtp")

    lazy val host = smtp.getString("host")
    lazy val port = smtp.getInt("port")
    lazy val login = smtp.getString("login")
    lazy val password = smtp.getString("password")
  }
}
