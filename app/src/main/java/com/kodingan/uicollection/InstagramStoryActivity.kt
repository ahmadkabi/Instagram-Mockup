package com.kodingan.uicollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kodingan.uicollection.databinding.ActivityInstagramStoryBinding

class InstagramStoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInstagramStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstagramStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Glide.with(this)
            .load(R.drawable.cat)
            .circleCrop()
            .into(binding.instagramStoryAdd.img)

        Glide.with(this)
            .load(R.drawable.cat)
            .circleCrop()
            .into(binding.instagramStoryOn.img)

        Glide.with(this)
            .load(R.drawable.cat)
            .circleCrop()
            .into(binding.instagramStoryOff.img)

    }
}

/*TODO
*   add name below of image
* */