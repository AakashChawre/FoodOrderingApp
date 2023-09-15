package com.foodorderingapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.foodorderingapp.databinding.PopularItemBinding

class PopularAdapter(
    private val context: Context,
    private val items: List<Triple<String, Int, Int>>
) :
    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            PopularItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(context, items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PopularViewHolder(private val binding: PopularItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, item: Triple<String, Int, Int>) {
            binding.ivItem.setImageResource(item.second)
            binding.tvName.text = item.first
            binding.tvPrice.text = "$${item.third}"
            binding.tvAddToCard.setOnClickListener {
                Toast.makeText(context, "${item.first} is select...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}