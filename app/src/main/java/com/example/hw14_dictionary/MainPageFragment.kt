package com.example.hw14_dictionary


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hw14_dictionary.databinding.FragmentMainPageBinding


class MainPageFragment : Fragment() {
    private lateinit var _binding: FragmentMainPageBinding
    private val binding get() = _binding
    val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainPageBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)
        binding.counter.text=viewModel.getAllWord().toString()
        var count=Observer<Int>{
            binding.counter.text=it.toString()
        }

        viewModel.wordCount.observe(viewLifecycleOwner,count)

        binding.buttonNewWord.setOnClickListener {
            findNavController().navigate(R.id.action_mainPageFragment_to_addWordFragment)
        }

        binding.buttonWordLink.setOnClickListener {
            findNavController().navigate(R.id.action_mainPageFragment_to_wordDescription)
        }
        binding.searchEnglishButton.setOnClickListener {
            var searchWord=binding.searchEnglish.text.toString()
            var wordEnglish: WordEntity? =viewModel.getEnglishWord(searchWord)

            binding.englishWord.text = wordEnglish?.englishWord.toString()
            binding.persianWord.text = wordEnglish?.persianWord.toString()
            binding.wordDetails.text = wordEnglish?.wordDetails.toString()
            binding.synonym.text = wordEnglish?.synonym.toString()
            binding.wordUrl.text = wordEnglish?.wordUrl.toString()

        }
        binding.searchPersianButton.setOnClickListener {
            var searchWord=binding.searchPersian.text.toString()
            var wordPersian: WordEntity? =viewModel.getPersianWord(searchWord)

            binding.englishWord.text = wordPersian?.englishWord.toString()
            binding.persianWord.text = wordPersian?.persianWord.toString()
            binding.wordDetails.text = wordPersian?.wordDetails.toString()
            binding.synonym.text = wordPersian?.synonym.toString()
            binding.wordUrl.text = wordPersian?.wordUrl.toString()

        }

    }

}