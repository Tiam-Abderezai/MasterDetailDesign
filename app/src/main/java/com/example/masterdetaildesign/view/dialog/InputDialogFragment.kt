package com.example.masterdetaildesign.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.masterdetaildesign.R
import com.example.masterdetaildesign.data.Item
import com.example.masterdetaildesign.databinding.FragmentInputDialogBinding
import com.example.masterdetaildesign.viewmodel.ItemViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class InputDialogFragment: BottomSheetDialogFragment() {

    private lateinit var viewModel: ItemViewModel
    private lateinit var binding: FragmentInputDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_input_dialog, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submitItem.setOnClickListener {
            submitItem(it)
        }
    }

    private fun submitItem(view: View) {
        Toast.makeText(requireContext(), "Outside", Toast.LENGTH_SHORT).show()
        if (binding.nameInput.length() > 0 && binding.urlInput.length() > 0) {
            Log.d("BottomSheet", "onViewCreated: ${binding.nameInput.length()}, ${binding.urlInput.length()}")
            Toast.makeText(requireContext(), "Valid Input", Toast.LENGTH_SHORT).show()
            val item = Item(binding.nameInput.text.toString(), binding.urlInput.text.toString())
            viewModel.newItemAdded(item)
            dismiss()
        }
    }
}