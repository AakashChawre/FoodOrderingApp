package com.foodorderingapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.foodorderingapp.databinding.CardItemBinding
import com.foodorderingapp.databinding.NotificationItemBinding

class NotificationAdapter(
    private val context: Context, private val items: ArrayList<Pair<Int, String>>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(
            NotificationItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(context, items, position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class NotificationViewHolder(private val binding: NotificationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context, items: ArrayList<Pair<Int, String>>, position: Int) {
            val item = items.get(position)
            binding.apply {
                ivNotification.setImageResource(item.first)
                tvMassage.text = item.second
            }
        }
    }
}