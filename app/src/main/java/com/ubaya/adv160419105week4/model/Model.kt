package com.ubaya.adv160419105week4.model

import com.google.gson.annotations.SerializedName

data class Student(

    //SerializedName dipakai jika data pada json berbeda dengan nama field di Android studio
    val id:String?,
    @SerializedName("student_name")
    var name:String?,
    @SerializedName("birth_of_date")
    var dob:String?,
    var phone:String?,
    @SerializedName("photo_url")
    var photoUrl:String?
)