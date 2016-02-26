package biz.hexworx.notificator

import spray.json.DefaultJsonProtocol
trait Protocols extends DefaultJsonProtocol {
  implicit val messageFormat = jsonFormat7(Message.apply)
  implicit val responseFormat = jsonFormat1(Response.apply)
}
