package com.ibrohimapk3.easyenglish.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibrohimapk3.easyenglish.R
import com.ibrohimapk3.easyenglish.presentation.view.adapter.MyAdapterForAllAplh
import com.ibrohimapk3.easyenglish.presentation.view.adapter.MyAdapterForListVocabulary

class AllAlphabetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_all_alphabet, container, false)
        var rcView = view.findViewById<RecyclerView>(R.id.rc_all_alphabet)
        var adapter = MyAdapterForAllAplh()
        rcView.adapter = adapter
        rcView.layoutManager = GridLayoutManager(context, 3)
        return view
    }
}