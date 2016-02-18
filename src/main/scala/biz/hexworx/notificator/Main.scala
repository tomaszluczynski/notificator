package biz.hexworx.notificator

import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.stream.ActorMaterializer


import scala.concurrent.ExecutionContext

object Main extends App with Protocols with Api {
  private implicit val system = ActorSystem()
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected val log: LoggingAdapter = Logging(system, getClass)
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()

  Console.println("Server started...")

  Http().bindAndHandle(handler = logRequestResult("log")(routes), interface = "127.0.0.1", port = 9911)
}