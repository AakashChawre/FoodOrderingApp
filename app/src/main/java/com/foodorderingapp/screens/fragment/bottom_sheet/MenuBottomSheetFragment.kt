package com.foodorderingapp.screens.fragment.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.foodorderingapp.adapters.MenuAdapter
import com.foodorderingapp.databinding.FragmentMenuBottomSheetBinding
import com.foodorderingapp.models.Item
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMenuBottomSheetBinding

    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase

    private val menuItems = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // initialize Firebase Database
        databaseReference = FirebaseDatabase.getInstance().reference

        // initialize Firebase Database
        database = FirebaseDatabase.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBack.setOnClickListener {
            dismiss()
        }
        getMenuItems()
    }


    private fun getMenuItems() {
        val foodRef : DatabaseReference = database.reference.child("menu")
        foodRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                menuItems.clear()
                for (foodSnapshot in snapshot.children){
                    val menuItem = foodSnapshot.getValue(Item::class.java)
                    menuItem.let {
                        menuItems.add(it!!)
                    }
                }

                showItems()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "error : ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun showItems() {
        val adapter = MenuAdapter(requireContext(), menuItems,databaseReference)
        binding.rvMenuItem.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMenuItem.adapter = adapter
    }
}