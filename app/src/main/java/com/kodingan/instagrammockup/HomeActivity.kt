package com.kodingan.instagrammockup

import android.graphics.Typeface.BOLD
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kodingan.instagrammockup.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        buildBottomNavigation()
    }

    private fun buildBottomNavigation() {

        var currentFragment: Fragment

        binding.bottomNav.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.navigation_home -> {
                    currentFragment = HomeFragment.newInstance()
                }

                R.id.navigation_search -> {
                    currentFragment = SearchFragment.newInstance()
                }

                R.id.navigation_post -> {
                    currentFragment = PostFragment.newInstance()
                }

                R.id.navigation_reel -> {
                    currentFragment = ReelFragment.newInstance()
                }

                R.id.navigation_account -> {
                    currentFragment = AccountFragment.newInstance()
                }

                else -> {
                    currentFragment = HomeFragment.newInstance()
                }
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.hostFragment, currentFragment)
                .commit()

            true
        }

    }

}