package com.ibrohimapk3.easyenglish.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ibrohimapk3.easyenglish.R
import com.ibrohimapk3.easyenglish.data.ListA1.a1Words
import com.ibrohimapk3.easyenglish.domain.Word
import com.ibrohimapk3.easyenglish.presentation.view.MainActivity
import com.ibrohimapk3.easyenglish.presentation.view.MyAdapter

class MyVocabularyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_my_vocabulary, container, false)
        var rv = view.findViewById<RecyclerView>(R.id.rv_list_vocabulary)
        var adapter = MyAdapter()
        var list = mutableListOf<Word>(
            Word(english = "hello", russian = "niger"),
            Word(english = "hello", russian = "niger"),
            Word(english = "hello", russian = "niger"),
            Word(english = "hello", russian = "niger"),
        )
        var btn = view.findViewById<FloatingActionButton>(R.id.save_btn)
        btn.setOnClickListener {
            findNavController().navigate(R.id.action_myVocabularyFragment_to_addNewWordFragment)
        }
        adapter.setList(list)
        rv.adapter = adapter
        return view
    }
}