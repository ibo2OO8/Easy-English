package com.ibrohimapk3.easyenglish.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.ibrohimapk3.easyenglish.R
import com.ibrohimapk3.easyenglish.presentation.view.MainActivity

class AddNewWordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).hideBottomNav(true)
        val toolbar = view?.findViewById<Toolbar>(R.id.toolbar)
        // Устанавливаем Toolbar как ActionBar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

           val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

        toolbar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        return inflater.inflate(R.layout.fragment_add_new_word, container, false)
    }
    override fun onPause() {
        Log.d("helloN" , "hello")
        super.onPause()
    }
}