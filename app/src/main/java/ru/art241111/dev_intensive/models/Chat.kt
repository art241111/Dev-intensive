package ru.art241111.dev_intensive.models

import java.lang.reflect.Member

class Chat(
    val id:String,
    val members: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf()
) {
}