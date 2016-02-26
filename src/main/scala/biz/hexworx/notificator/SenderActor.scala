package biz.hexworx.notificator

import akka.actor.Actor
import akka.event.Logging
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class SenderActor extends Actor with LazyLogging {
  override def receive: Receive = {
    case msg: Message =>
      logger.debug("Received Message send request")
      MailService.send(msg)
    case x =>
      logger.error("Unknown message received in SenderActor")
  }
}
