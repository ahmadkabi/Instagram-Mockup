package com.kodingan.instagramclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kodingan.instagramclone.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    lateinit var binding: FragmentPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {

        fun newInstance(): PostFragment {
            return PostFragment()
        }

    }

}