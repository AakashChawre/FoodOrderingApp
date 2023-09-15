package com.foodorderingapp.screens.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Slide
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.foodorderingapp.R
import com.foodorderingapp.adapters.PopularAdapter
import com.foodorderingapp.databinding.FragmentHomeBinding
import com.foodorderingapp.screens.fragment.bottom_sheet.MenuBottomSheetFragment

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBanner()
        showItems()

        binding.tvViewMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"TEST")
        }
    }

    private fun showItems() {
        val adapter = PopularAdapter(requireContext(), items)
        binding.rvPopularItem.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPopularItem.adapter = adapter
    }


    private fun showBanner() {
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                val itemPosition = imageList[position]
                val massage = "Double selected image is - $itemPosition"
                Toast.makeText(requireContext(), massage, Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val massage = "Selected image is - $itemPosition"
                Toast.makeText(requireContext(), massage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}