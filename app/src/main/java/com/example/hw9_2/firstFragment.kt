package com.example.hw9_2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hw9_2.databinding.FragmentFirstBinding


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
            var sharedPreferences = activity?.getSharedPreferences("share", Context.MODE_PRIVATE)

            val editor: SharedPreferences.Editor = sharedPreferences!!.edit()
            editor.putString("name", binding.myEditText1.text.toString())
            editor.putString("user", binding.myEditText2.text.toString())
            editor.putString("email", binding.myEditText3.text.toString())
            editor.putString("password", binding.myEditText5.text.toString())
            Toast.makeText(activity, "shared successfully", Toast.LENGTH_SHORT).show()
        }

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}