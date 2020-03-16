package ru.art241111.dev_intensive.models

class UserView (
    val id:String,
    val fullName: String,
    val nickName: String,
    val avatar: String? = null,
    val status: String? = "offline",
    val initials: String?

){
    fun printMe(){

    }
}