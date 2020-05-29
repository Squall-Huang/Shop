package com.hank.shop.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.lifecycle.LiveData
import com.hank.shop.model.Item
import com.hank.shop.view.FirestoreQueryLiveData

class ItemRepository(application: Application) {
    private var itemDao: ItemDao
    private lateinit var items: LiveData<List<Item>>
    private var firestoreQueryLiveData = FirestoreQueryLiveData()
    private var network = true
    init {
        itemDao = ItemDatabase.getDatabase(application).getItemDao()
        items = itemDao.getItems()
        val cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        network = cm.isDefaultNetworkActive
    }

    fun getAllItems(): LiveData<List<Item>> {
        if (network) {
            items = firestoreQueryLiveData
        } else {
            items = itemDao.getItems()
        }
        return items
    }

    fun setCategory(categoryId: String) {
        if (network) {
            firestoreQueryLiveData.setCategory(categoryId)
        } else {
            items = itemDao.getItemsByCategory(categoryId)
        }
    }
}