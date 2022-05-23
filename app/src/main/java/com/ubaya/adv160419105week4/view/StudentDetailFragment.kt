package com.ubaya.adv160419105week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ubaya.adv160419105week4.R
import com.ubaya.adv160419105week4.util.loadImage
import com.ubaya.adv160419105week4.viewmodel.DetailViewModel
import com.ubaya.adv160419105week4.viewmodel.ListViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import kotlinx.android.synthetic.main.fragment_student_detail.*
import java.util.concurrent.TimeUnit

/**
 * A simple [Fragment] subclass.
 * Use the [StudentDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDetailFragment : Fragment() {
    private lateinit var detailModel : DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var id = ""
        arguments?.let{
            id = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentID
        }
        detailModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailModel.fetch(id)
        observeDetailModel()
    }

    private fun observeDetailModel() {
        detailModel.studentLiveData.observe(viewLifecycleOwner){

            val student = it
            editID.setText(it.id)
            editName.setText(it.name)
            editBOD.setText(it.dob)
            imageDetailStudentPhoto.loadImage(it.photoUrl,progressLoadingDetailPhoto)
            editPhone.setText(it.phone)
            buttonNotif.setOnClickListener{
                Observable
                    .timer(5, TimeUnit.SECONDS)
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe{
                        Log.d("mynotif", "Notification delayed by 5 seconds")
                        MainActivity.showNotification(student.name.toString(), "Notification Created", R.drawable.ic_baseline_person_24)
                    }
            }
        }
    }
}