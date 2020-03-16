package ru.art241111.dev_intensive.models

import ru.art241111.dev_intensive.extension.humanizeDiff
import java.util.*

class TextMessage(
         id:String,
         from:User?,
         chat:Chat,
         isIncoming:Boolean = false,
         date: Date = Date(),
         var text:String?
): BaseMessage(id,from,chat,isIncoming,date){
    override fun formatMessage(): String = "id:$id ${from?.firstName} " +
            "${if(isIncoming) "получил" else "отправил"} сообщение " +
            "\"$text\" ${date.humanizeDiff()}"
}

