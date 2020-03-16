package ru.art241111.dev_intensive

import org.junit.Test

import org.junit.Assert.*
import ru.art241111.dev_intensive.extension.*
import ru.art241111.dev_intensive.models.BaseMessage
import ru.art241111.dev_intensive.models.User
import ru.art241111.dev_intensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User(id = "1");
        //val user2 = User(id = "2", "John", "");
        val user3 = User(id = "3");

        user.printMe();

        println("$user")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("John Wick")

        val user1 = user.copy(id="2", lastName = "Cena")

        print("$user \n $user1")
    }

    @Test
    fun test_base_message() {
        print(Utils.toInitials("john" ,"doe"))
    }

    @Test
    fun test_truncate() {
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        println("A     ".truncate(3))
    }

    @Test
    fun stripHtml() {
        println("<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>".stripHtml())
        println("<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml())
    }

    @Test
    fun TimeUnitPlural() {
        println(TimeUnits.SECOND.plural(1));
        println(TimeUnits.MINUTE.plural(4));
        println(TimeUnits.HOUR.plural(2));
        println(TimeUnits.DAY.plural(222));
    }

    @Test
    fun TimeHumanizeDif() {
        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff() );
        println(Date().add(-5, TimeUnits.DAY).humanizeDiff() );
        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff());
        println(Date().add(7, TimeUnits.DAY).humanizeDiff());
        println(Date().add(-400, TimeUnits.DAY).humanizeDiff() );
        println(Date().add(400, TimeUnits.DAY).humanizeDiff() );

    }
}
