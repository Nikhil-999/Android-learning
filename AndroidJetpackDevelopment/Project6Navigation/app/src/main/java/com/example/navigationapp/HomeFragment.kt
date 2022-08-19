package com.example.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_home, container, false)
        val myTextViewID = myView.findViewById<TextView>(R.id.HomeTextView)
        myTextViewID.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_secondFragment)        //we use navController to get access of the navigation between fragments.
        }
        val myButtonViewID = myView.findViewById<Button>(R.id.btnHomeFragment)
        myButtonViewID.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_thirdFragment)
        }
        return myView
    }
}