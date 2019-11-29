package ru.crpt.edi.education.kafka

import io.circe.generic.auto._
import io.circe.parser
import io.circe.syntax._


case class MessageForSD(ownerId: String, partnerId: String, documentId: String,
                        filename: String, `type`: Int, status: Byte, comment: String) {
  def toJson: String = this.asJson.noSpaces
}

object MessageForSD {
  def fromJson(json: String): Unit = {
    val decodeResult = parser.decode[MessageForSD](json)
    decodeResult match {
      case Right(message) => println(message.toString)
      case Left(error) => println(error.toString)
    }
  }
}
