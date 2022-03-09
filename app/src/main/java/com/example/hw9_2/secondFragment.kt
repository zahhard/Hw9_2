package com.example.hw9_2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hw9_2.databinding.FragmentFirstBinding
import com.example.hw9_2.databinding.FragmentSecondBinding

class secondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textView1.text = requireArguments().getString("name").toString()
        binding.textView2.text = requireArguments().getString("user").toString()
        binding.textView3.text = requireArguments().getString("email").toString()
        binding.textView4.text = requireArguments().getString("password").toString()
        binding.textView5.text = requireArguments().getString("gender").toString()

        binding.button3.setOnClickListener {
            var sharedPreferences = activity?.getSharedPreferences("share", Context.MODE_PRIVATE)

            val editor: SharedPreferences.Editor = sharedPreferences!!.edit()
            editor.putString("name", binding.textView1.text.toString())
            editor.putString("user", binding.textView2.text.toString())
            editor.putString("email", binding.textView3.text.toString())
            editor.putString("password", binding.textView4.text.toString())
            editor.putString("gender", binding.textView5.text.toString())
            Toast.makeText(activity, "shared successfully", Toast.LENGTH_SHORT).show()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}