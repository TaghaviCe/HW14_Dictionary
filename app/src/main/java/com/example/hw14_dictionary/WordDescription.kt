package com.example.hw14_dictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.hw14_dictionary.databinding.FragmentAddWordBinding
import com.example.hw14_dictionary.databinding.FragmentMainPageBinding
import com.example.hw14_dictionary.databinding.FragmentWordDescriptionBinding

class WordDescription : Fragment() {
    val viewModel: MainViewModel by viewModels()
    private lateinit var _binding: FragmentWordDescriptionBinding
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordDescriptionBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


}