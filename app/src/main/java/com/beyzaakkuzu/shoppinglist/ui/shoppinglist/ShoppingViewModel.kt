package com.beyzaakkuzu.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.beyzaakkuzu.shoppinglist.data.db.entities.Shopping
import com.beyzaakkuzu.shoppinglist.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository): ViewModel() {
    fun upsert(item: Shopping)= CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun delete(item:Shopping)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun getAllShoppingItems() = repository.getAllShoppingItems()
}