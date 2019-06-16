package com.app.keeperofthevoid.onboardingdemo


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_slider.*

class SliderFragment : Fragment() {

    var pageImage : Int = 0
    var pageHeader : String = ""
    var pageDescription : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        iconImageView.setImageResource(pageImage)
        headerTextView.text = pageHeader
        descriptionTextView.text = getString(pageDescription)
    }

    fun setImage(image : Int) {
        pageImage = image
    }

    fun setHeader(title : String) {
        pageHeader = title
    }

    fun setDescription(description : Int) {
        pageDescription = description
    }

}
