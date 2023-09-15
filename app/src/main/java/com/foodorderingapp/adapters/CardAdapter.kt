package com.foodorderingapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.foodorderingapp.databinding.CardItemBinding

class CardAdapter(
    private val context: Context, private val items: ArrayList<Triple<String, Int, Int>>
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(context, items, position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CardViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context, items: ArrayList<Triple<String, Int, Int>>, position: Int) {
            val item = items.get(position)

            binding.apply {
                tvName.text = item.first
                ivImage.setImageResource(item.second)
                tvPrice.text = "$${item.third}"
                var count = 1
                ibPlus.setOnClickListener {
                    binding.tvCount.text = "${count++}"
                }
                ibMinus.setOnClickListener {
                    binding.tvCount.text = "${count--}"
                }
            }
        }
    }
}