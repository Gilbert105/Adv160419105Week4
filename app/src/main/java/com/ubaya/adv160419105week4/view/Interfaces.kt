package com.ubaya.adv160419105week4.view

import android.view.View
import com.ubaya.adv160419105week4.model.Student

interface StudentDetailClickListener{
    fun onStudentDetailClick(view:View)
}
interface StudentCreateNotificationClickListener{
    fun onStudentCreateNotificationClickListener(view:View, obj:Student)
}