package com.app.keeperofthevoid.onboardingdemo


import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class SliderAdapter(private val mContext: Context) : PagerAdapter() {

    private val slideImages: IntArray = intArrayOf(R.drawable.eat, R.drawable.sleep, R.drawable.code)

    private val slideHeaders = arrayOf("EAT", "SLEEP", "CODE")

    private val slideDescriptions = arrayOf("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                    "incididunt ut labore et dolore magna aliqua",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                    "incididunt ut labore et dolore magna aliqua")

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(R.layout.slide_layout, collection, false) as ViewGroup


        val slideImageView: ImageView = layout.findViewById(R.id.iconImageView)
        val slideHeading: TextView = layout.findViewById(R.id.headerTextView)
        val slideDescription: TextView = layout.findViewById(R.id.descriptionTextView)

        slideImageView.setImageResource(slideImages[position])
        slideHeading.text = slideHeaders[position]
        slideDescription.text = slideDescriptions[position]

        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return slideHeaders.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

}