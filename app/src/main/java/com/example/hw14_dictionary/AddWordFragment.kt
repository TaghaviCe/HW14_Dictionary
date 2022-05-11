package com.example.hw14_dictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw14_dictionary.databinding.FragmentAddWordBinding
import com.example.hw14_dictionary.databinding.FragmentMainPageBinding


class AddWordFragment : Fragment() {
    private lateinit var _binding: FragmentAddWordBinding
    private val binding get() = _binding!!
    lateinit var word:WordEntity
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddWordBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      //  super.onViewCreated(view, savedInstanceState)
        binding.yesButton.setOnClickListener {
            word = WordEntity(
                binding.wordEnglish.text.toString(),
                binding.wordPersian.text.toString(),
                binding.wordDesc.text.toString(),
                binding.wordSynonym.text.toString(),
                binding.wordUrl.text.toString()
            )
            viewModel.addWord(word)
            findNavController().navigate(R.id.action_addWordFragment_to_mainPageFragment)
        }

    }

}