package biz.hexworx.notificator

import akka.actor.Actor
import akka.event.Logging

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class SenderActor extends Actor {
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case msg: Message =>
      log.info("sending message from actor!")
      def result = MailService.send(msg)
      Await.result(result, Duration.Inf)
      log.info("message sent!")
    case x =>
      log.info("unknown message")
  }
}
