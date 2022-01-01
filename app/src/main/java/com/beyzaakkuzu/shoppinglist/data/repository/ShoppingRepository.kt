package com.beyzaakkuzu.shoppinglist.data.repository

import com.beyzaakkuzu.shoppinglist.data.db.ShoppingDatabase
import com.beyzaakkuzu.shoppinglist.data.db.entities.Shopping

class ShoppingRepository(
    private val db:ShoppingDatabase
) {
    suspend fun upsert(item:Shopping)= db.getShoppingDao().upsert(item)
    suspend fun delete(item:Shopping)=db.getShoppingDao().delete(item)
    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItem()

}