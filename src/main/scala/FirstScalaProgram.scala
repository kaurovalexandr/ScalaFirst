object FirstScalaProgram {
  def main(args: Array[String]){
    println("hello Stas");

    val message:MessageForSD = MessageForSD("600000078", "600000526", "ec741647-ff84-4776-ba8f-d6c173be3b84", "ON_NSCHFDOPPRMARK_2LT-600000526_2LT-600000078_20191121_ea933cc4-710d-4a6f-aa1c-03203dc8f6c4.xml", 504, 0, "hello")
    var messageJson:String =  MessageForSD.toJson(message)
    println(messageJson)
    val messageClass  = MessageForSD.fromJson(messageJson)
    println(message.toString)
  }
}
