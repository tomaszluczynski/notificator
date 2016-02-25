package biz.hexworx.notificator

import akka.actor.{Props, ActorSystem}
import akka.http.scaladsl.server.Directives._
import akka.routing.RoundRobinPool
import akka.stream.ActorMaterializer
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._

import scala.concurrent.{ExecutionContext, Await}
import scala.concurrent.duration.Duration

trait Api extends Protocols {

  implicit val system = ActorSystem()
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executor: ExecutionContext = system.dispatcher

  val senderActor = system.actorOf(Props[SenderActor].withRouter(RoundRobinPool(5)), name = "sender")

  var routes =
    path("") {
      complete("default world")
    } ~ path("hello") {
      complete("hello world")
    } ~ (path("send") & entity(as[Message])) { message =>
      complete {
        println("telling actor")
        senderActor ! message
        senderActor ! message
        senderActor ! message
        senderActor ! message
        senderActor ! message
        println("told actor")
        "ok"
      }
    }
}
