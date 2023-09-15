package com.foodorderingapp.screens.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.foodorderingapp.R
import com.foodorderingapp.adapters.PopularAdapter
import com.foodorderingapp.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private val items = ArrayList<Triple<String, Int, Int>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items.add(Triple("Herbal Pancake", R.drawable.menu1, 10))
        items.add(Triple("Fruit Salad", R.drawable.menu2, 20))
        items.add(Triple("Green Noddle", R.drawable.menu3, 5))
        items.add(Triple("Herbal Pancake", R.drawable.menu4, 10))
        items.add(Triple("Fruit Salad", R.drawable.menu5, 20))
        items.add(Triple("Green Noddle", R.drawable.menu6, 5))
        items.add(Triple("Herbal Pancake", R.drawable.menu7, 10))
        items.add(Triple("Herbal Pancake", R.drawable.menu1, 10))
        items.add(Triple("Fruit Salad", R.drawable.menu2, 20))
        items.add(Triple("Green Noddle", R.drawable.menu3, 5))
        items.add(Triple("Herbal Pancake", R.drawable.menu4, 10))
        items.add(Triple("Fruit Salad", R.drawable.menu5, 20))
        items.add(Triple("Green Noddle", R.drawable.menu6, 5))
        items.add(Triple("Herbal Pancake", R.drawable.menu7, 10))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showItems()
    }

    private fun showItems() {
        val adapter = PopularAdapter(requireContext(), items)
        binding.rvPrevBuyItem.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPrevBuyItem.adapter = adapter
    }
}