package com.ibrohimapk3.easyenglish.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ibrohimapk3.easyenglish.R
import com.ibrohimapk3.easyenglish.presentation.view.MainActivity
import com.ibrohimapk3.easyenglish.presentation.view.MyAdapter
import com.ibrohimapk3.easyenglish.presentation.viewmodel.MyVocabularyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyVocabularyFragment : Fragment() {
    val viewModel : MyVocabularyViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_my_vocabulary, container, false)
        (activity as MainActivity).hideBottomNav(false)
        var rv = view.findViewById<RecyclerView>(R.id.rv_list_vocabulary)
        var adapter = MyAdapter()
        var btn = view.findViewById<FloatingActionButton>(R.id.save_btn)
        btn.setOnClickListener {
            findNavController().navigate(R.id.action_myVocabularyFragment_to_addNewWordFragment)
        }
        Log.d("helloNi", viewModel.listLiveData.value.toString())
        viewModel.listLiveData.observe(viewLifecycleOwner) {
            it?.let {
                adapter.setList(it)
            }
            rv.adapter = adapter
        }
        return view
    }
}