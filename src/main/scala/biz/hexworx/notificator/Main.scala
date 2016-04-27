package biz.hexworx.notificator

import akka.actor.{ActorSystem, Props}
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext

object Main extends App with Api with LazyLogging {
  Http().bindAndHandle(handler = logRequestResult("log")(routes), interface = "127.0.0.1", port = 9911)
  logger.info("Server has been started.");
}