package com.example.masterdetaildesign.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.masterdetaildesign.data.Item

class ItemViewModel: ViewModel() {

    //initial List of Items
    var liveData = MutableLiveData<ArrayList<Item>>(dummyList)

    // Item Selected in RecyclerView
    var selectedItem = ObservableField<Item>()
    var selectedItemPos: Int = 0

    //Item That was added via Input
    var newItem = MutableLiveData<Item>()

    fun newItemAdded(item: Item) {
        newItem.postValue(item)
    }

    fun itemSelected(pos: Int, item: Item) {
        selectedItemPos = pos
        selectedItem.set(item)
    }
}