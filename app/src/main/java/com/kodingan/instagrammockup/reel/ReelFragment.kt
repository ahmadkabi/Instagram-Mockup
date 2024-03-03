package com.kodingan.instagrammockup.reel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kodingan.instagrammockup.databinding.FragmentReelBinding

class ReelFragment : Fragment() {

    lateinit var binding: FragmentReelBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReelBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {

        fun newInstance(): ReelFragment {
            return ReelFragment()
        }

    }

}