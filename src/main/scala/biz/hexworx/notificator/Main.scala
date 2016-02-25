package biz.hexworx.notificator

import akka.actor.{Props, ActorSystem}
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._


import scala.concurrent.ExecutionContext

object Main extends App with Api {


  val log: LoggingAdapter = Logging(system, getClass)

  Console.println("Server started...")



  Http().bindAndHandle(handler = logRequestResult("log")(routes), interface = "127.0.0.1", port = 9911)
}