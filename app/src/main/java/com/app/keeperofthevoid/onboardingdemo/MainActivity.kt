package com.app.keeperofthevoid.onboardingdemo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //private lateinit var mSlideViewPager: ViewPager
    private lateinit var slideAdapter : SliderAdapter
    private lateinit var mDotLayout: LinearLayout

    private val slideImages: IntArray = intArrayOf(R.drawable.eat, R.drawable.sleep, R.drawable.code)
    private val slideHeaders = arrayOf("EAT", "SLEEP", "CODE")
    private val slideDescriptions = arrayOf(R.string.description, R.string.description, R.string.description)

    override fun onCreate(savedInstanceState: Bundle?) {

        var fragment1 = SliderFragment()
        var fragment2 = SliderFragment()
        var fragment3 = SliderFragment()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment1.setImage(slideImages[0])
        fragment1.setHeader(slideHeaders[0])
        fragment1.setDescription(slideDescriptions[0])

        fragment2.setImage(slideImages[1])
        fragment2.setHeader(slideHeaders[1])
        fragment2.setDescription(slideDescriptions[1])

        fragment3.setImage(slideImages[2])
        fragment3.setHeader(slideHeaders[2])
        fragment3.setDescription(slideDescriptions[2])

        // Create Slide Adapter and add Fragments to it
        slideAdapter = SliderAdapter(supportFragmentManager)
        slideAdapter.fragmentList.add(fragment1)
        slideAdapter.fragmentList.add(fragment2)
        slideAdapter.fragmentList.add(fragment3)

        slideViewPager.adapter = slideAdapter

        btn_next.setOnClickListener{
            slideViewPager.currentItem++
        }

        btn_skip.setOnClickListener{ goToDashboard() }

        slideViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(position: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixel: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (position == slideAdapter.fragmentList.size - 1) {
                    // Last Page
                    btn_next.text = "DONE"
                    btn_next.setOnClickListener{
                        goToDashboard()
                    }
                } else {
                    // Has next page
                    btn_next.text = "NEXT"
                    btn_next.setOnClickListener{
                        slideViewPager.currentItem++
                    }
                }
                // Set indicator color depending on screen

                when(slideViewPager.currentItem) {
                    0 -> {
                        indicator1.setTextColor(Color.BLACK)
                        indicator2.setTextColor(Color.GRAY)
                        indicator3.setTextColor(Color.GRAY)
                    }
                    1 -> {
                        indicator1.setTextColor(Color.GRAY)
                        indicator2.setTextColor(Color.BLACK)
                        indicator3.setTextColor(Color.GRAY)
                    }
                    2 -> {
                        indicator1.setTextColor(Color.GRAY)
                        indicator2.setTextColor(Color.GRAY)
                        indicator3.setTextColor(Color.BLACK)
                    }
                }
            }

        })

        //mSlideViewPager = findViewById(R.id.slideViewPager)
        //mDotLayout = findViewById(R.id.dotsLayout)
    }

    fun goToDashboard() {
        // Used to navigate from Onboarding screens
        /*startActivity(Intent(activity, DashboardActivity::class.java))
        finish()*/

        // For One-time onboarding Functionality
        /*val editor = preference.edit()
        editor.putBoolean(preference_show_intro, false)
        editor.apply()*/
    }

}
