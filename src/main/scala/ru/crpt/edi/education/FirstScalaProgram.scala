package ru.crpt.edi.education

import ru.crpt.edi.education.kafka.MessageForSD

object FirstScalaProgram extends App {
  val messageClass = MessageForSD("600000078", "600000526", "ec741647-ff84-4776-ba8f-d6c173be3b84", "ON_NSCHFDOPPRMARK_2LT-600000526_2LT-600000078_20191121_ea933cc4-710d-4a6f-aa1c-03203dc8f6c4.xml", 504, 0, "hello")
  val messageJson: String = messageClass.toJson
  MessageForSD.fromJson(messageJson)
  val messageXml = messageClass.toXml
  val messageClassFromXml = MessageForSD.fromXml(messageXml)
}
