package biz.hexworx.notificator

import com.typesafe.scalalogging.LazyLogging
import javax.mail.internet.InternetAddress
import courier._, Defaults._

import scala.util.{Failure, Success}

object MailService extends LazyLogging {
  logger.info("Building SMTP client...")

  val mailer = Mailer(AppConfig.SmtpConfig.host, AppConfig.SmtpConfig.port)
    .auth(true)
    .as(AppConfig.SmtpConfig.login, AppConfig.SmtpConfig.password)
    .startTtls(true)()

  def send(message: Message) = {
    logger.info(s"Sending e-mail message to ${message.to}")

    mailer(
      Envelope.from(new InternetAddress(message.from))
        .to(new InternetAddress(message.to))
        .subject(message.subject)
        .content(Text(message.content))
    ) onComplete {
      case Success(_) => println("success")
      case Failure(t) => println("fail: " + t.getMessage)
    }
  }
}

