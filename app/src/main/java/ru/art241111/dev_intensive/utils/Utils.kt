package ru.art241111.dev_intensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?,String?>{
        if (fullName?.trimIndent() == "" ) {
            return null to null
        }
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName =parts?.getOrNull(1)

        return firstName to lastName;
    }

    fun transliteration(payload: String, divider:String = " "): String {
        val words:MutableList<String> = payload.toLowerCase().split(" ") as MutableList<String>
        var returnPayload:String = ""

        words.forEach{
            returnPayload += transliterationWord(it) + divider
        }
        return returnPayload.dropLast(1);

        }
        private fun transliterationWord(word: String): String {
            val letters: CharArray = word.toCharArray()
            var returnWord:String = ""

            letters.forEach {
                returnWord += transliterationDictionary.getOrElse(it){it}
            }
            return returnWord.capitalize()
        }

    fun toInitials(firstName: String?, lastName: String?): String? {
        if((firstName == null && lastName == null)
           || (firstName?.trimIndent() == "" && lastName?.trimIndent() == "")) return null;

        return (firstName?.get(0) ?: "").toString().toUpperCase() + (lastName?.get(0) ?: "").toString().toUpperCase()

    }

    private var transliterationDictionary:Map<Char, String> = mapOf('а' to "a",
                                                         'б' to "b",
                                                         'в' to "v",
                                                         'г' to "g",
                                                         'д' to "d",
                                                         'е' to "e",
                                                         'ё' to "e",
                                                         'ж' to "zh",
                                                         'з' to "z",
                                                         'и' to "i",
                                                         'й' to "i",
                                                         'к' to "k",
                                                         'л' to "l",
                                                         'м' to "m",
                                                         'н' to "n",
                                                         'о' to "o",
                                                         'п' to "p",
                                                         'р' to "r",
                                                         'с' to "s",
                                                         'т' to "t",
                                                         'у' to "u",
                                                         'ф' to "f",
                                                         'х' to "h",
                                                         'ц' to "c",
                                                         'ч' to "ch",
                                                         'ш' to "sh",
                                                         'щ' to "sh'",
                                                         'ъ' to "",
                                                         'ы' to "i",
                                                         'ь' to "",
                                                         'э' to "e",
                                                         'ю' to "yu",
                                                         'я' to "ya")

}