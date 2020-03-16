package ru.art241111.dev_intensive.extension

import ru.art241111.dev_intensive.models.User
import ru.art241111.dev_intensive.models.UserView
import ru.art241111.dev_intensive.utils.Utils
import java.util.*


fun User.toUserView() : UserView{
    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null)"Еще ни разу не был" else if(isOnline)"online" else "Последний раз был ${lastVisit?.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        avatar = avatar,
        status = status)
}


