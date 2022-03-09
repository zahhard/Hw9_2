package com.example.hw9_2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.hw9_2.databinding.FragmentFirstBinding
import com.example.hw9_2.databinding.FragmentSecondBinding


class firstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {


            var bundle = Bundle()
            bundle.putString("name", binding.myEditText1.text.toString())
            bundle.putString("user", binding.myEditText2.text.toString())
            bundle.putString("email", binding.myEditText3.text.toString())
            bundle.putString("password", binding.myEditText5.text.toString())
            var gender = ""
            if (binding.radioButton3.isChecked){
                gender = "male"
            }
            else if (binding.radioButton2.isChecked){
                gender = "female"
            }
            bundle.putString("gender", gender)
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }

//    override fun onClick(view: View) {
//        val action =
//            SpecifyAmountFragmentDirections
//                .actionSpecifyAmountFragmentToConfirmationFragment()
//        view.findNavController().navigate(action)
//    }
}