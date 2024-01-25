package com.kodingan.uicollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kodingan.uicollection.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load(R.drawable.cat)
            .circleCrop()
            .into(binding.story1.imgStory)

        Glide.with(this)
            .load(R.drawable.cat)
            .circleCrop()
            .into(binding.story2.imgStory)

        Glide.with(this)
            .load(R.drawable.cat)
            .circleCrop()
            .into(binding.story3.imgStory)

        Glide.with(this)
            .load(R.drawable.cat)
            .circleCrop()
            .into(binding.imgProfile.imgStory)

    }
}