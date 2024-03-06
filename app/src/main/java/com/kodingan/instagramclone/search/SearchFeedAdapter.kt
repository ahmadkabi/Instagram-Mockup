package com.kodingan.instagramclone.search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kodingan.instagramclone.databinding.ItemSearchFeedBinding
import com.kodingan.instagramclone.util.BlurTransformation
import com.kodingan.instagramclone.util.gone
import com.kodingan.instagramclone.util.visible

class SearchFeedAdapter : RecyclerView.Adapter<SearchFeedAdapter.MyViewHolder>() {

    private val items = arrayListOf<SearchFeedModel>()

    companion object {
        val single = 1
        val multiple = 2
        val reel = 3
        val invisible = 4
        val sponsored = 5
    }

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

        when (item.itemType) {
            single -> {
                holder.binding.imgInvisible.gone()
                holder.binding.imgMultiple.gone()
                holder.binding.imgReel.gone()
                holder.binding.txSponsored.gone()
            }

            multiple -> {
                holder.binding.imgInvisible.gone()
                holder.binding.imgMultiple.visible()
                holder.binding.imgReel.gone()
                holder.binding.txSponsored.gone()
            }

            reel -> {
                holder.binding.imgInvisible.gone()
                holder.binding.imgMultiple.gone()
                holder.binding.imgReel.visible()
                holder.binding.txSponsored.gone()
            }

            invisible -> {
                holder.binding.imgInvisible.visible()
                holder.binding.imgMultiple.gone()
                holder.binding.imgReel.gone()
                holder.binding.txSponsored.gone()

            }

            sponsored -> {
                holder.binding.imgInvisible.gone()
                holder.binding.imgMultiple.gone()
                holder.binding.imgReel.gone()
                holder.binding.txSponsored.visible()
            }
        }

        when (item.itemType) {
            invisible -> {
                Glide.with(holder.itemView.context)
                    .load(item.imageResource) // or url
                    .transform(BlurTransformation(holder.itemView.context))
                    .into(holder.binding.img)
            }

            else -> {
                holder.binding.img.setImageResource(item.imageResource)
            }
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, position.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    fun addItem(item: SearchFeedModel) {
        items.add(item)
        notifyItemInserted(items.lastIndex)
    }

    fun addItems(items: List<SearchFeedModel>) {
        this.items.addAll(items)
        notifyItemRangeChanged(0, itemCount)
    }

}