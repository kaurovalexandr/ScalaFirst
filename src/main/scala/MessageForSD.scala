import io.circe. parser
import io.circe.generic.auto._
import io.circe.syntax._


case class MessageForSD(ownerId: String, partnerId: String, documentId: String,
                        filename: String, `type`: Int, status: Byte, comment: String) {
}

object MessageForSD {
  def fromJson(json: String): MessageForSD = parser.decode[MessageForSD](json).toOption.get
  def toJson(message: MessageForSD): String = message.asJson.noSpaces
}
