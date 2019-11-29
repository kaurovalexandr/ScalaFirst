package ru.crpt.edi.education.kafka

import io.circe.generic.auto._
import io.circe.parser
import io.circe.syntax._
import com.typesafe.scalalogging.StrictLogging

case class MessageForSD(ownerId: String, partnerId: String, documentId: String,
                        filename: String, `type`: Int, status: Byte, comment: String) extends StrictLogging {
  def toJson: String = {
    val json = this.asJson.noSpaces
    logger.info(s"to json: $json")
    json
  }
}

object MessageForSD extends StrictLogging {
  def fromJson(json: String): Unit = {
    val decodeResult = parser.decode[MessageForSD](json)
    decodeResult match {
      case Right(message) => logger.info(s"from json: $message")
      case Left(error) => logger.error(s"from json : $error")
    }
  }
}
