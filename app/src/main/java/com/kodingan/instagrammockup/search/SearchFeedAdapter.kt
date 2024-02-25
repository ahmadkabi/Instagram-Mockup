package com.kodingan.instagrammockup.search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kodingan.instagrammockup.databinding.ItemSearchFeedBinding

class SearchFeedAdapter : RecyclerView.Adapter<SearchFeedAdapter.MyViewHolder>() {

    private val items = arrayListOf<Int>()

    inner class MyViewHolder(val binding: ItemSearchFeedBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemSearchFeedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]

        holder.binding.img.setImageResource(item)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, position.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    fun addItem(item: Int) {
        items.add(item)
        notifyItemInserted(items.lastIndex)
    }

    fun addItems(items: List<Int>) {
        this.items.addAll(items)
        notifyItemRangeChanged(0, itemCount)
    }

}