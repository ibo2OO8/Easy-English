package com.ibrohimapk3.easyenglish.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.bundle.bundleOf
import androidx.core.graphics.blue
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ibrohimapk3.easyenglish.R

class ListAlpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_list_alp, container, false)
        var btnA1 = view.findViewById<Button>(R.id.btn_a1)
        var btnA2 = view.findViewById<Button>(R.id.btn_a2)
        var btnB1 = view.findViewById<Button>(R.id.btn_b1)
        btnA1.setOnClickListener {
            var bundle = bundleOf("myArg" to "a1")
            findNavController().navigate(R.id.action_listAlpFragment_to_ShowVocabularyFragment , bundle)
        }
        btnA2.setOnClickListener {
            var bundle = bundleOf("myArg" to "a2")
            findNavController().navigate(R.id.action_listAlpFragment_to_ShowVocabularyFragment , bundle)

        }
        btnB1.setOnClickListener {
            var bundle = bundleOf("myArg" to "b1")
            findNavController().navigate(R.id.action_listAlpFragment_to_ShowVocabularyFragment , bundle)
        }
        return view
    }
}