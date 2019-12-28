package com.example.simplequiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.simplequiz.databinding.FragmentCorrectAnswerBinding

/**
 * A simple [Fragment] subclass.
 */
class QuizWonFragment : Fragment() {
    lateinit var binding:FragmentCorrectAnswerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_correct_answer,container,false)
        binding.btnPlayNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_quizWonFragment_to_titleFragment)
        }
        return binding.root
    }


}
