package com.foodorderingapp.screens.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.foodorderingapp.R
import com.foodorderingapp.adapters.MenuAdapter
import com.foodorderingapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val originalItems = ArrayList<Triple<String, Int, Int>>()
    private val items = mutableListOf<Triple<String, Int, Int>>()
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        originalItems.add(Triple("Herbal Pancake", R.drawable.menu1, 10))
        originalItems.add(Triple("Fruit Salad", R.drawable.menu2, 20))
        originalItems.add(Triple("Green Noddle", R.drawable.menu3, 5))
        originalItems.add(Triple("Herbal Pancake", R.drawable.menu4, 10))
        originalItems.add(Triple("Fruit Salad", R.drawable.menu5, 20))
        originalItems.add(Triple("Green Noddle", R.drawable.menu6, 5))
        originalItems.add(Triple("Herbal Pancake", R.drawable.menu7, 10))
        originalItems.add(Triple("Herbal Pancake", R.drawable.menu1, 10))
        originalItems.add(Triple("Fruit Salad", R.drawable.menu2, 20))
        originalItems.add(Triple("Green Noddle", R.drawable.menu3, 5))
        originalItems.add(Triple("Herbal Pancake", R.drawable.menu4, 10))
        originalItems.add(Triple("Fruit Salad", R.drawable.menu5, 20))
        originalItems.add(Triple("Green Noddle", R.drawable.menu6, 5))
        originalItems.add(Triple("Herbal Pancake", R.drawable.menu7, 10))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showItems()
        searchItem()
        showSearchedItem()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showSearchedItem() {
        items.clear()
        items.addAll(originalItems)
        adapter.notifyDataSetChanged()
    }

    private fun showItems() {
//        adapter = MenuAdapter(requireContext(), items, databaseReference)
//        binding.rvSearchMenuItem.layoutManager = LinearLayoutManager(requireContext())
//        binding.rvSearchMenuItem.adapter = adapter
    }

    private fun searchItem() {
        binding.searchItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterMenuItems(query: String?) {
        items.clear()
        originalItems.forEachIndexed { index, item ->
            if (item.first.contains(query!!, true)) {
                items.add(originalItems[index])
            }
        }

        adapter.notifyDataSetChanged()
    }
}