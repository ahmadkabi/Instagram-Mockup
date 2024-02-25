package com.kodingan.instagrammockup.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.kodingan.instagrammockup.R
import com.kodingan.instagrammockup.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buildRv()
    }

    private fun buildRv() {
        val spanCount = 3
        val adapter = SearchFeedAdapter()

        val drawables = arrayOf(
            R.drawable.cat_1,
            R.drawable.cat_2,
            R.drawable.cat_3,
            R.drawable.cat_4,
            R.drawable.cat_5,
            R.drawable.cat_6,
            R.drawable.cat_7,
            R.drawable.cat_8,
            R.drawable.cat_9,
            R.drawable.cat_10,
            R.drawable.cat_11,
            R.drawable.cat_12,
            R.drawable.cat_13,
            R.drawable.cat_14,
            R.drawable.cat_15,
            R.drawable.cat_16,
            R.drawable.cat_17,
            R.drawable.cat_18,
            R.drawable.cat_19,
            R.drawable.cat_20,
            R.drawable.cat_21,
            R.drawable.cat_22,
            R.drawable.cat_23,
            R.drawable.cat_24,
            R.drawable.cat_25,
            R.drawable.cat_26,
        )

        adapter.addItems(drawables.toList())
        binding.rv.adapter = adapter

        val itemDecoration = ItemDecorationGridVertical(
            spanCount,
            6,
            true
        )
        binding.rv.addItemDecoration(itemDecoration)
        binding.rv.layoutManager = GridLayoutManager(
            requireContext(),
            spanCount,
            GridLayoutManager.VERTICAL,
            false
        )
        binding.rv.setHasFixedSize(false)

    }

    companion object {

        fun newInstance(): SearchFragment {
            return SearchFragment()
        }

    }

}