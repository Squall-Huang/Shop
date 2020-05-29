package com.hank.shop.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hank.shop.data.ItemRepository
import com.hank.shop.model.Item
import com.hank.shop.view.FirestoreQueryLiveData

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    /*private var items = MutableLiveData<List<Item>>()
    private var firestoreQueryLiveData =
        FirestoreQueryLiveData()*/
    private lateinit var itemRepository: ItemRepository
    init {
        itemRepository = ItemRepository(application)
    }

    fun getItems(): LiveData<List<Item>> {

        return itemRepository.getAllItems()
    }

    fun setCategory(categoryId: String) {
        itemRepository.setCategory(categoryId)
    }
}