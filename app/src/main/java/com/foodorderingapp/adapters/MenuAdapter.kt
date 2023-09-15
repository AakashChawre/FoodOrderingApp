package com.foodorderingapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.foodorderingapp.R
import com.foodorderingapp.databinding.MenuItemBinding
import com.foodorderingapp.models.Item
import com.foodorderingapp.screens.fragment.bottom_sheet.MenuBottomSheetFragment
import com.google.firebase.database.DatabaseReference

class MenuAdapter(
    private val context: Context,
    private val items: ArrayList<Item>,
    databaseReference: DatabaseReference
) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            MenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(context, items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MenuViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context, item: Item) {

            // set image using glide
            Glide.with(context)
                .load(item.itemImage)
                .centerCrop()
                .placeholder(R.drawable.addimage)
                .into(binding.ivItem)

            binding.tvName.text = item.itemName
            binding.tvPrice.text = "$${item.itemPrice}"

            binding.tvAddToCard.setOnClickListener {
                Toast.makeText(context, "${item.itemName} is select...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}