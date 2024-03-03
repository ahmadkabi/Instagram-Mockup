package com.kodingan.instagrammockup

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.imageview.ShapeableImageView
import com.kodingan.instagrammockup.databinding.ActivityHomeBinding
import com.kodingan.instagrammockup.reel.ReelFragment
import com.kodingan.instagrammockup.search.SearchFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var imgAccount: ShapeableImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        buildBottomNavigation()
    }

    private fun buildBottomNavigation() {

        var currentFragment: Fragment = SearchFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.hostFragment, currentFragment)
            .commit()

        buildAccountMenuItem()

        binding.bottomNav.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.navigation_home -> {
                    currentFragment = HomeFragment.newInstance()

                    imgAccount.strokeColor = getColorStateList(android.R.color.transparent)
                }

                R.id.navigation_search -> {
                    currentFragment = SearchFragment.newInstance()

                    imgAccount.strokeColor = getColorStateList(android.R.color.transparent)
                }

                R.id.navigation_post -> {
                    currentFragment = PostFragment.newInstance()

                    imgAccount.strokeColor = getColorStateList(android.R.color.transparent)
                }

                R.id.navigation_reel -> {
                    currentFragment = ReelFragment.newInstance()

                    imgAccount.strokeColor = getColorStateList(android.R.color.transparent)
                }

                R.id.navigation_account -> {
                    currentFragment = AccountFragment.newInstance()

                    imgAccount.strokeColor = getColorStateList(android.R.color.black)
                }

                else -> {
                    currentFragment = HomeFragment.newInstance()
                }
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.hostFragment, currentFragment)
                .commit()

            if (it.itemId == R.id.navigation_reel) {
                binding.bottomNav.setBackgroundResource(R.color.black)
                binding.bottomNav.itemIconTintList =
                    ColorStateList.valueOf(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )

            } else {
                binding.bottomNav.setBackgroundResource(R.color.white)
                binding.bottomNav.itemIconTintList =
                    ColorStateList.valueOf(
                        ContextCompat.getColor(
                            this,
                            R.color.black
                        )
                    )
            }

            true
        }

    }

    private fun buildAccountMenuItem() {
        val menuItem = LayoutInflater
            .from(this)
            .inflate(
                R.layout.menu_item_bottom_nav_account,
                binding.bottomNav,
                false
            )

        imgAccount = menuItem.findViewById(R.id.imgAccount)
        imgAccount.strokeColor = getColorStateList(android.R.color.transparent)

        val itemView = binding.bottomNav.findViewById<BottomNavigationItemView>(
            R.id.navigation_account
        )
        itemView.addView(menuItem)
    }

}