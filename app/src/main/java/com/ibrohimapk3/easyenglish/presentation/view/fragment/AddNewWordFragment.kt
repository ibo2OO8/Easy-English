package com.ibrohimapk3.easyenglish.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ibrohimapk3.easyenglish.R
import com.ibrohimapk3.easyenglish.domain.Word
import com.ibrohimapk3.easyenglish.presentation.view.MainActivity
import com.ibrohimapk3.easyenglish.presentation.viewmodel.AddNewWordViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNewWordFragment : Fragment() {
    val viewModel: AddNewWordViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).hideBottomNav(true)
        var view = inflater.inflate(R.layout.fragment_add_new_word, container, false)
        var edt_eng = view.findViewById<EditText>(R.id.edt_eng)
        var edt_rus = view.findViewById<EditText>(R.id.edt_rus)
        var btn_save = view.findViewById<Button>(R.id.btn_save)
        var btn_back = view.findViewById<Button>(R.id.btn_back)
        btn_save.setOnClickListener {
            checkEditText(edt_rus.text.toString(), edt_eng.text.toString())
        }
        btn_back.setOnClickListener {
            findNavController().navigate(R.id.action_addNewWordFragment_to_myVocabularyFragment)
        }
        return view
    }

    fun checkEditText(edt_rus: String, edt_eng: String) {
        if (!edt_rus.isBlank() && !edt_eng.isBlank()) {
            viewModel.addWord(Word(null, edt_rus, edt_eng))
            findNavController().navigate(R.id.action_addNewWordFragment_to_myVocabularyFragment)
        } else {
            Toast.makeText(requireContext(), "field is empty", Toast.LENGTH_SHORT).show()
        }
    }
}