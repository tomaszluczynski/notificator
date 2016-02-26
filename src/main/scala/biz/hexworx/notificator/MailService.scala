package biz.hexworx.notificator

import com.typesafe.scalalogging.LazyLogging
import courier._, Defaults._

import scala.util.{Failure, Success}

object MailService extends LazyLogging {
  logger.info("Building SMTP client...")
  val mailer = Mailer("smtp.gmail.com", 587)
    .auth(true)
    .as("tluczynski@gmail.com", "p@$$w3rd")
    .startTtls(true)()

  def send(message: Message) = {
    logger.info(s"Sending e-mail message to ${message.to}")
    mailer(
      Envelope.from("you" `@` "gmail.com")
        .to("tluczynki" `@` "gmail.com")
        .subject(message.subject)
        .content(Text(message.content))
    ) onComplete {
      case Success(_) => println("success")
      case Failure(t) => println("fail: " + t.getMessage)
    }
  }
}

