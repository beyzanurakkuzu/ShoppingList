package com.beyzaakkuzu.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.beyzaakkuzu.shoppinglist.data.db.entities.Shopping

@Dao
interface ShoppingDao {
    @Insert(onConflict = REPLACE)
    suspend fun upsert(item: Shopping)

    @Delete
    suspend fun delete(item: Shopping)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItem(): LiveData<List<Shopping>>
}