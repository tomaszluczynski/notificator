package biz.hexworx.notificator

import spray.json.DefaultJsonProtocol
trait Protocols extends DefaultJsonProtocol {
  implicit val messageFormat = jsonFormat7(Message.apply)
}
