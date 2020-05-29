package com.hank.shop.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hank.shop.model.Item

@Dao
interface ItemDao {

    @Query("select * from Item order by viewCount")
    fun getItems():LiveData<List<Item>>

    @Query("select * from Item where category == :categoryId order by viewCount")
    fun getItemsByCategory(categoryId: String): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItem(item: Item)

}