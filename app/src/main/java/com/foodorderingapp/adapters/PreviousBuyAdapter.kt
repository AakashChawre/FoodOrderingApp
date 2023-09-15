package com.foodorderingapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.foodorderingapp.databinding.BuyItemBinding
import com.foodorderingapp.databinding.MenuItemBinding
import com.foodorderingapp.databinding.PopularItemBinding

class PreviousBuyAdapter(
    private val context: Context,
    private val items: List<Triple<String, Int, Int>>
) :
    RecyclerView.Adapter<PreviousBuyAdapter.PreviousBuyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviousBuyViewHolder {
        return PreviousBuyViewHolder(
            BuyItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PreviousBuyViewHolder, position: Int) {
        holder.bind(context, items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PreviousBuyViewHolder(private val binding: BuyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context, item: Triple<String, Int, Int>) {
            binding.ivItem.setImageResource(item.second)
            binding.tvName.text = item.first
            binding.tvPrice.text = "$${item.third}"

            binding.tvBuyAgain.setOnClickListener {
                Toast.makeText(context, "${item.first} buy again.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}