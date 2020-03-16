package ru.art241111.dev_intensive.extension

fun String.truncate(numberToDelete: Int = 16):String{
    var returnText:String = this.trim()
    if(returnText.length < numberToDelete) return returnText

    val countRemainingCharacters: Int = this.length - numberToDelete
    returnText = returnText.dropLast(countRemainingCharacters)
                     .trim()

    return returnText.padEnd(returnText.length + 3,'.')
}

fun String.stripHtml():String{
    var checkTeg:Boolean = false
    var checkEnter:Boolean = true
    var returnText:String = "";

    this.forEach {
        if(it == '<') checkTeg = false
        if (it != ' ') checkEnter = true

        if(checkTeg && checkEnter) returnText += it

        if(it == '>') checkTeg = true
        if (it == ' ') checkEnter = false
    }
    return returnText
}