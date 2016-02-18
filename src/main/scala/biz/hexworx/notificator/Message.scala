package biz.hexworx.notificator

case class Message(from: String,
                   to: String,
                   bcc: String,
                   replyTo: String,
                   tags: String,
                   subject: String,
                   content: String) {

}
