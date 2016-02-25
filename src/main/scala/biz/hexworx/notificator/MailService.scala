package biz.hexworx.notificator

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object MailService {
  def send(message: Message): Future[String] = Future {
    Thread.sleep(5000)
    "OK"
  }
}
