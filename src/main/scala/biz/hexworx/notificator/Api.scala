package biz.hexworx.notificator

import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

trait Api {
  var routes =
    path("") {
      complete("default world")
    } ~ path("hello") {
      complete("hello world")
    } ~ (path("send") & entity(as[Message])) { message =>
      complete {
        ("send to " + message.to)
      }
    }
}
