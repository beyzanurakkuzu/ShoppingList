package com.beyzaakkuzu.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.beyzaakkuzu.shoppinglist.R
import com.beyzaakkuzu.shoppinglist.data.db.ShoppingDatabase
import com.beyzaakkuzu.shoppinglist.data.repository.ShoppingRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database= ShoppingDatabase(this)
        val repository= ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[ShoppingViewModel::class.java]

    }
}