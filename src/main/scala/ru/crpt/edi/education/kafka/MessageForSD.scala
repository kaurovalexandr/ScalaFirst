package ru.crpt.edi.education.kafka

import akka.actor.ActorSystem
import akka.event.Logging
import io.circe.generic.auto._
import io.circe.parser
import io.circe.syntax._

case class MessageForSD(ownerId: String, partnerId: String, documentId: String,
                        filename: String, `type`: Int, status: Byte, comment: String) {
  val log = Logging(ActorSystem(), getClass)
  def toJson: String = {
    val json = this.asJson.noSpaces
    log.info(s"to json: $json")
    json
  }
}

object MessageForSD  {
  val log = Logging(ActorSystem(), getClass)
  def fromJson(json: String): Unit = {
    parser.decode[MessageForSD](json) match {
      case Right(message) => log.info(s"from json : $message")
      case Left(error) => log.error(s"from json : $error")
    }
  }
}
