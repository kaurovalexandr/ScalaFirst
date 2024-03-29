package ru.crpt.edi.education.kafka

import io.circe.generic.auto._
import io.circe.parser
import io.circe.syntax._

case class MessageForSD(ownerId: String, partnerId: String, documentId: String,
                        filename: String, `type`: Int, status: Byte, comment: String) {
  def toJson: String = {
    val value = this.asJson.noSpaces
    println("to json: " + value)
    value
  }

  def toXml = {
    val value =
      <Запись>
        <Отправитель> {ownerId} </Отправитель>
        <Получатель> {partnerId} </Получатель>
        <ИдДокумента> {documentId} </ИдДокумента>
        <ИмяФайла> {filename} </ИмяФайла>
        <Тип> {`type`} </Тип>
        <Статус> {status} </Статус>
        <Комментарий> {comment} </Комментарий>
      </Запись>
    println("to xml: " + value)
    value
  }
}

object MessageForSD {
  def fromJson(value: String): Unit = {
    parser.decode[MessageForSD](value) match {
      case Right(message) => println("from json: " + message.toString)
      case Left(error) => println("from json: " + error.toString)
    }
  }

  def fromXml(value: scala.xml.Node): MessageForSD = {
    val ownerId = (value \ "Отправитель").text.trim
    val partnerId = (value \ "Получатель").text.trim
    val documentId = (value \ "ИдДокумента").text.trim
    val filename = (value \ "ИмяФайла").text.trim
    val `type` = (value \ "Тип").text.trim.toInt
    val status = (value \ "Статус").text.trim.toByte
    val comment = (value \ "Комментарий").text.trim
    val classFromXml = MessageForSD(ownerId, partnerId, documentId, filename, `type`, status, comment)
    println("from xml: " + classFromXml.toString)
    classFromXml
  }
}
