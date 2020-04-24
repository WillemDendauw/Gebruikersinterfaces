package com.example.codelabtutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            //problem:
            //val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            //findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.toast_button).setOnClickListener{
            val myToast = Toast.makeText(context, getString(R.string.toast_button_value), Toast.LENGTH_SHORT)
            myToast.show();
        }

        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(view)
        }
    }

    private fun countMe(view: View){
        //get the textview
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        //get the value
        val countString = showCountTextView.text.toString()
        //convert value to a number and increment
        var count = countString.toInt()
        count++
        //Display the new value
        showCountTextView.text = count.toString()
    }
}
