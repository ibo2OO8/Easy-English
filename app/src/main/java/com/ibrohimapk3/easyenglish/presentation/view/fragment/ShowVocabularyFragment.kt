package com.ibrohimapk3.easyenglish.presentation.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ibrohimapk3.easyenglish.R
import com.ibrohimapk3.easyenglish.data.ListA1
import com.ibrohimapk3.easyenglish.presentation.view.MyAdapter

class ShowVocabularyFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_show_vocabulary, container, false)
        var rcView = view.findViewById<RecyclerView>(R.id.rv_list_for_vocabulary)
        val backBtn = view.findViewById<FloatingActionButton>(R.id.back_btn)
        val myArg = arguments?.getString("myArg")
        var listA1 = ListA1.a1Words
        var adapter = MyAdapter()
        adapter.setList(listA1)
        rcView.adapter = adapter

        backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_ShowVocabularyFragment_to_listAlpFragment)
        }
        return view
    }

}