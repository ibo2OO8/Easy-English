package com.ibrohimapk3.easyenglish.presentation.view.fragment

import android.annotation.SuppressLint
import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ibrohimapk3.easyenglish.R
import com.ibrohimapk3.easyenglish.presentation.view.ListOfAlphabet
import com.ibrohimapk3.easyenglish.presentation.view.Speaker
import kotlin.io.path.Path

class LearnAlpFragment : Fragment() {
    private var counter = 0
    private var listOfAlp = ListOfAlphabet()
    private lateinit var speaker : Speaker
    @SuppressLint("MissingInflatedId")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_learn_alp, container, false)
        var img = view.findViewById<ImageView>(R.id.imageAlphabet)
        var btnLeft = view.findViewById<ImageButton>(R.id.btn_left)
        var btnRight = view.findViewById<ImageButton>(R.id.btn_right)
        var btnSound = view.findViewById<ImageButton>(R.id.btn_speech)
        var tvAlp = view.findViewById<TextView>(R.id.tv_alphabet)

        tvAlp.text = "${listOfAlp.listAB[counter]} ${listOfAlp.list[counter]}"
        img.setImageResource(getImageId(R.array.image_array)[counter])
        speaker = Speaker(requireContext())

        btnLeft.setOnClickListener {
            moveImgToLeft(img, tvAlp)
            speaker.speak(listOfAlp.listAB[counter].toString())

        }

        btnRight.setOnClickListener {
            moveImgToRight(img, tvAlp)
            speaker.speak(listOfAlp.listAB[counter].toString())
        }

        btnSound.setOnClickListener {
            speaker.speak(listOfAlp.listAB[counter].toString())
        }
        return view
    }

    private fun getImageId(imageArrayId: Int): IntArray {
        var tarray: TypedArray = resources.obtainTypedArray(imageArrayId)
        var count = tarray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tarray.getResourceId(i, 0)
        }
        tarray.recycle()
        return ids
    }

    fun moveImgToRight(img: ImageView, tvAlp: TextView) {
        if (counter < listOfAlp.listAB.size - 1) {
            counter++
            img.setImageResource(getImageId(R.array.image_array)[counter])
            tvAlp.text = "${listOfAlp.listAB[counter]} ${listOfAlp.list[counter]}"
        }
    }

    fun moveImgToLeft(img: ImageView, tvAlp: TextView) {
        if (counter > 0) {
            counter--
            img.setImageResource(getImageId(R.array.image_array)[counter])
            tvAlp.text = "${listOfAlp.listAB[counter]} ${listOfAlp.list[counter]}"
        }
    }
}
