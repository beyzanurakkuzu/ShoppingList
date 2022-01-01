package com.beyzaakkuzu.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ShoppingDao {
    @Insert(onConflict = REPLACE)
    suspend fun upsert(items: Shopping)

    @Delete
    suspend fun delete(items:Shopping)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItem(): LiveData<List<Shopping>>
}