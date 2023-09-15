package com.foodorderingapp.screens.fragment.bottom_sheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.foodorderingapp.R
import com.foodorderingapp.adapters.NotificationAdapter
import com.foodorderingapp.adapters.PopularAdapter
import com.foodorderingapp.databinding.FragmentNotificationBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NotificationBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNotificationBottomSheetBinding
    private val massages = ArrayList<Pair<Int, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        massages.add(Pair(R.drawable.menu1, "Your order has been Canceled Successfully "))
        massages.add(Pair(R.drawable.menu2, "Order has been taken by the driver 2"))
        massages.add(Pair(R.drawable.menu3, "Congrats Your Order Placed 3"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBack.setOnClickListener {
            dismiss()
        }
        showNotification()
    }

    private fun showNotification() {
        val adapter = NotificationAdapter(requireContext(), massages)
        binding.rvNotificationItem.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotificationItem.adapter = adapter
    }
}