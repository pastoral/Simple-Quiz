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
import com.example.simplequiz.databinding.FragmentWrongAnswerBinding

/**
 * A simple [Fragment] subclass.
 */
class QuizLostFragment : Fragment() {

    lateinit var binding: FragmentWrongAnswerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_wrong_answer,container,false)
        binding.btnTryAgain.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_quizLostFragment_to_titleFragment)
        }
        return binding.root
        }
    }

