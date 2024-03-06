package com.kodingan.instagramclone

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kodingan.instagramclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buildLikedText()
        buildCaption()

    }


    private fun buildLikedText() {
        val builder = SpannableStringBuilder("Liked by ")

        val omameSpannable = SpannableString("omame_munchkin ")
        val othersSpannable = SpannableString("2.462 others")

        omameSpannable.setSpan(
            StyleSpan(Typeface.BOLD), 0, omameSpannable.length, 0
        )
        othersSpannable.setSpan(
            StyleSpan(Typeface.BOLD), 0, othersSpannable.length, 0
        )

        builder.append(omameSpannable)
        builder.append("and ")
        builder.append(othersSpannable)

        binding.txLiked.setText(builder, TextView.BufferType.SPANNABLE)

    }

    private fun buildCaption() {
        val builder = SpannableStringBuilder("")

        val pisco = SpannableString("pisco_cat ")

        pisco.setSpan(
            StyleSpan(Typeface.BOLD), 0, pisco.length, 0
        )

        builder.append(pisco)
        builder.append("When you are eating your French fries in peace.... Your girlfriend be like")

        binding.txCaption.setText(builder, TextView.BufferType.SPANNABLE)

    }

    companion object {

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }

    }

}