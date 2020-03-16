package ru.art241111.dev_intensive.extension

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String = "HH:mm::ss dd.MM.yy"):String{
    val  dataFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dataFormat.format(this)
}

private fun timeUnitsForInt(time:TimeUnits):Long =
        when(time){
            TimeUnits.SECOND -> SECOND
            TimeUnits.MINUTE -> MINUTE
            TimeUnits.HOUR -> HOUR
            TimeUnits.DAY -> DAY
        }

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND):Date{
    var time = this.time

    time += value * timeUnitsForInt(units)

    this.time = time
    return this
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

/**
 * @author Artem Gerasimov
 *
 * @param num - число, в зависимости от которого меняется окончание
 * @param list - список вариантов измений слов  (Пример: list = "секунду", "секунды", "секунд")
 *
 * @return  Число, которое ввел пользователь, и подобранное слово (Пример: 1 секунду)
 */
    private fun declination(num:Int, list:List<String>):String{
        var pos:Int = 0

        when(num % 10){
            1 -> pos = 0
            in 2..4 -> pos = 1
            0, in 5..10 -> pos = 2
        }

        return "$num ${list[pos]}"
    }
fun TimeUnits.plural(value: Int):String{
    return when(this){
        TimeUnits.SECOND -> declination(value, listOf("секунду", "секунды", "секунд"))
        TimeUnits.MINUTE -> declination(value, listOf("минуту", "минуты", "минут"))
        TimeUnits.HOUR -> declination(value, listOf("час", "часа", "часов"))
        TimeUnits.DAY -> declination(value, listOf("день", "дня", "дней"))
    }

}
    private fun diffGreaterOrLess(diff: Long, time:TimeUnits):String{
        val newDiff = diff / timeUnitsForInt(time)
        var textReturn:String = time.plural(abs(newDiff.toInt()))

        if(diff > 0) textReturn = "$textReturn назад"
        else textReturn = "через $textReturn"
        return textReturn
    }

    private fun diffGreaterOrLess(diff: Long, text:String):String{
        return if(diff > 0) "$text назад"
        else "через $text"
    }
private fun searchInTheInterval(diff: Long):String {
    return when(abs(diff)){
        in 0  * SECOND .. 1  * SECOND -> "только что"
        in 1  * SECOND .. 45 * SECOND -> diffGreaterOrLess(diff,"несколько секунд")
        in 45 * SECOND .. 75 * SECOND -> diffGreaterOrLess(diff,"минуту")
        in 75 * SECOND .. 45 * MINUTE -> diffGreaterOrLess(diff, TimeUnits.MINUTE)
        in 45 * MINUTE .. 75 * MINUTE -> diffGreaterOrLess(diff,"час")
        in 75 * MINUTE .. 22 * HOUR   -> diffGreaterOrLess(diff, TimeUnits.HOUR)
        in 22 * HOUR   .. 26 * HOUR   -> diffGreaterOrLess(diff,"день ")
        in 26 * HOUR   .. 360 * DAY   -> diffGreaterOrLess(diff, TimeUnits.DAY)
        else -> if(diff > 0) "более года назад"
                else "более чем через год"
    }
}



fun Date.humanizeDiff(date: Date = Date()): String {
    return searchInTheInterval(Date().time - this.time).trim()
}
