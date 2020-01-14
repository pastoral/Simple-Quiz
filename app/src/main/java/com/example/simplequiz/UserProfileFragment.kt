package com.example.simplequiz


import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.simplequiz.databinding.FragmentUserProfileBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_user_profile.*


/**
 * A simple [Fragment] subclass.
 */
class UserProfileFragment : Fragment() {
    val user = FirebaseAuth.getInstance().currentUser
    var highestScore:String = "0"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var binding: FragmentUserProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_profile,container,false)
         binding.btnLogout.setOnClickListener {
             AuthUI.getInstance().signOut(activity?.applicationContext!!)

                 .addOnSuccessListener {
                     Navigation.findNavController(view!!).navigate(R.id.action_userProfileFragment_to_titleFragment)
                     Toast.makeText(activity,"Logged Out",Toast.LENGTH_SHORT)
                 }
         }
        binding.userprofile = this
         return binding.root
        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        user.let {
            Glide.with(this)
                .load(user?.photoUrl)
                .fitCenter()
                .placeholder(R.drawable.profilepic)
                .into(userimage)
        }
        sharedPreferences = activity!!.getSharedPreferences("SP_HIGH_SCORE", MODE_PRIVATE)
        highestScore = sharedPreferences.getInt("HIGHESTSCORE",0).toString()

    }



}
