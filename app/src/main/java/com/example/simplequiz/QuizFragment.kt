package com.example.simplequiz


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.simplequiz.databinding.FragmentQuizGameBinding


/**
 * A simple [Fragment] subclass.
 */
class QuizFragment : Fragment() {
   lateinit var binding: FragmentQuizGameBinding
    lateinit var currentQuestion:Question
    private var questionIndex = 0
    private val maxNumberOfQuestion = 7

    var questions:ArrayList<Question> = arrayListOf(
        Question("Which is the Independence day of Bangladesh?",
            arrayListOf("26 March","21 Feb","14th April","16 December") ),
        Question("Who is the first man landed on moon?",
            arrayListOf("Neil Armstrong","Edwin Aldrin", "Michael Collins", "Yuri Gregory")),
        Question("Socrates is best known for - ",
            arrayListOf("Philosophy","Mathmetics","Physiology","Astrology")),
        Question("How many states does USA have? ",
            arrayListOf("50","45","55","49")),
        Question("Which is not an Europian Country? ",
            arrayListOf("Combodia","Estonia","Lithunia","Moldova")),
        Question("Who is the first President of USA? ",
            arrayListOf("George Washington","William Henry Harrison","Abraham Lincoln","Franklin D. Roosevelt")),
        Question("Which one is the largest ocean? ",
            arrayListOf("Pacific","Atlantic","Mediterian","Arctic")),
        Question("What country has a town named Marathon? ",
            arrayListOf("USA","GREECE","ITALY","FRANCE")),
        Question("What well-known mountain pass connects Pakistan and Afghanistan? ",
            arrayListOf("Khyber Pass","Malakand Pass","Ahmad Pass","Shandar Pass")),
        Question("What country was formerly known as Ceylon?",
            arrayListOf("Sri Lanka","Sweden","Vietnam","Switzerland"))
    )

    lateinit var answers:ArrayList<String>
    lateinit var selectedAnswer:String

    private fun setQuestion(){
        currentQuestion = questions[questionIndex]
        answers = ArrayList(currentQuestion.answerGroup)
        answers.shuffle()

        Log.d("ANSWERGROUP", answers[0]+ " "+answers[1]+ " "+answers[2]+ " "+answers[3]+ " ")
        Log.d("REALANSWER", currentQuestion.answerGroup[0])

        binding.invalidateAll()

    }

    private fun randomQuestion(){
        questions.shuffle()
        setQuestion()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quiz_game,container,false)

        randomQuestion()
        binding.quiz=this
        return binding.root
    }


}
