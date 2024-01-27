package com.kodingan.uicollection

import android.graphics.Typeface.BOLD
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kodingan.uicollection.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buildLikedText()
    }

    private fun buildLikedText() {
        val builder = SpannableStringBuilder("Liked by ")

        val omameSpannable = SpannableString("omame_munchkin ")
        val othersSpannable = SpannableString("2.462 others")

        omameSpannable.setSpan(
            StyleSpan(BOLD), 0, omameSpannable.length, 0
        )
        othersSpannable.setSpan(
            StyleSpan(BOLD), 0, othersSpannable.length, 0
        )

        builder.append(omameSpannable)
        builder.append("and ")
        builder.append(othersSpannable)

        binding.txLiked.setText(builder, TextView.BufferType.SPANNABLE)

    }

}