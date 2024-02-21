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
        adapter.addItems(resources.getStringArray(R.array.search_feeds).toCollection(ArrayList()))
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