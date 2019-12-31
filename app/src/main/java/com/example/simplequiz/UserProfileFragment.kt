package com.example.simplequiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.simplequiz.databinding.FragmentUserProfileBinding

/**
 * A simple [Fragment] subclass.
 */
class UserProfileFragment : Fragment() {

    lateinit var binding: FragmentUserProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_profile,container,false)
            return binding.root
        }



}
