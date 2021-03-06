package com.ubaya.adv160419105week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.adv160419105week4.R
import com.ubaya.adv160419105week4.databinding.StudentListItemBinding
import com.ubaya.adv160419105week4.model.Student
import com.ubaya.adv160419105week4.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*
import java.util.zip.Inflater

class StudentListAdapter(val studentList:ArrayList<Student>) : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), StudentDetailClickListener {
    class StudentViewHolder(var view:StudentListItemBinding) : RecyclerView.ViewHolder(view.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.student_list_item,parent,false)
        val view = StudentListItemBinding.inflate(inflater,parent, false)
//        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater,R.layout.student_list_item,parent,false)
        return StudentViewHolder(view)

    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        with(holder.view){
            student = studentList[position]
            detailListener = this@StudentListAdapter
        }
//        val student = studentList[position]
//        with(holder.view){
//            textID.text = student.id.toString()
//            textName.text = student.name.toString()
//            buttonDetail.setOnClickListener {
//                val action = StudentListFragmentDirections.actionStudentListFragmentToStudentDetailFragment(student.id.toString())
//                Navigation.findNavController(it).navigate(action)
//            }
//            imageStudentPhoto.loadImage(student.photoUrl,progressLoadingStudentPhoto)
//        }
    }

    override fun getItemCount() = studentList.size


    fun updateStudentList(newStudentList : ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onStudentDetailClick(view: View) {
        val action = StudentListFragmentDirections.actionStudentListFragmentToStudentDetailFragment(view.tag.toString())
        Navigation.findNavController(view).navigate(action)
    }
}