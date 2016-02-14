package biz.hexworx.notificator

import akka.http.scaladsl.server.Directives._

trait Api {
  var routes =
    path("") {
      complete("default world")
    } ~ path("hello") {
      complete("hello world")
    }
}
