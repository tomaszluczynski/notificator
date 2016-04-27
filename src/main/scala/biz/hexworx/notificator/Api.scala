package biz.hexworx.notificator

import akka.actor.{Props, ActorSystem}
import akka.http.scaladsl.server.Directives._
import akka.routing.RoundRobinPool
import akka.stream.ActorMaterializer
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.{ExecutionContext, Await}
import scala.concurrent.duration.Duration

trait Api extends Protocols with LazyLogging {

  implicit val system = ActorSystem()
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executor: ExecutionContext = system.dispatcher

  val senderActor = system.actorOf(Props[SenderActor].withRouter(RoundRobinPool(5)), name = "sender")

  var routes =
    (path("send") & entity(as[Message])) { message =>
      complete {
        logger.debug("Telling SenderActor to send message")
        senderActor ! message
        Response("ok")
      }
    }
}
