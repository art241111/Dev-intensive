package ru.art241111.dev_intensive.models

import ru.art241111.dev_intensive.extension.humanizeDiff
import java.util.*

class ImageMessage(
    id:String,
    from:User?,
    chat:Chat,
    isIncoming:Boolean = false,
    date: Date = Date(),
    var image:String?
): BaseMessage(id,from,chat,isIncoming,date) {
    override fun formatMessage(): String = "id:$id ${from?.firstName} " +
            "${if(isIncoming) "получил" else "отправил"} изображение " +
            "\"$image\" ${date.humanizeDiff()}"
}