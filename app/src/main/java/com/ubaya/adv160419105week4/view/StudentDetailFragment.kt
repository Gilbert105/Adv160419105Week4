package com.ubaya.adv160419105week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ubaya.adv160419105week4.R
import com.ubaya.adv160419105week4.viewmodel.DetailViewModel
import com.ubaya.adv160419105week4.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*

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
        detailModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailModel.fetch()
        observeDetailModel()
    }

    private fun observeDetailModel() {
        detailModel.studentLiveData.observe(viewLifecycleOwner){
            editID.setText(it.id)
            editName.setText(it.name)
            editBOD.setText(it.dob)
            editPhone.setText(it.phone)
        }
    }
}