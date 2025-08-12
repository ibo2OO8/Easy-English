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
import com.ibrohimapk3.easyenglish.data.ListA2
import com.ibrohimapk3.easyenglish.data.ListB1
import com.ibrohimapk3.easyenglish.domain.Word
import com.ibrohimapk3.easyenglish.presentation.view.Speaker
import com.ibrohimapk3.easyenglish.presentation.view.adapter.MyAdapterForListVocabulary
import com.ibrohimapk3.easyenglish.presentation.view.callBack.CallBackForListAlp

class ShowVocabularyFragment : Fragment(), CallBackForListAlp{
    private lateinit var speaker : Speaker
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_show_vocabulary, container, false)
        var rcView = view.findViewById<RecyclerView>(R.id.rv_list_for_vocabulary)
        val backBtn = view.findViewById<FloatingActionButton>(R.id.back_btn)
        speaker = Speaker(requireContext())
        val myArg = arguments?.getString("myArg")
        var list: Any

        if (myArg.toString() == "a1") list = ListA1.a1Words
        else if (myArg.toString() == "a2") list = ListA2.a2Words
        else list = ListB1.b1Words
        var adapter = MyAdapterForListVocabulary(this)
        adapter.setList(list)
        rcView.adapter = adapter
        backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_ShowVocabularyFragment_to_listAlpFragment)
        }
        return view
    }

    override fun sound(item: Word) {
        speaker.speak(item.english , 0.5F)
    }
}