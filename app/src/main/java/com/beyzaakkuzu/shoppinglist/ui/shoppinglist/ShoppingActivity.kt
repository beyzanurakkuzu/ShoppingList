package com.beyzaakkuzu.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyzaakkuzu.shoppinglist.Adapter.ShoppingItemAdapter
import com.beyzaakkuzu.shoppinglist.R
import com.beyzaakkuzu.shoppinglist.data.db.ShoppingDatabase
import com.beyzaakkuzu.shoppinglist.data.db.entities.Shopping
import com.beyzaakkuzu.shoppinglist.data.repository.ShoppingRepository
import kotlinx.android.synthetic.main.activity_main.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database= ShoppingDatabase(this)
        val repository= ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[ShoppingViewModel::class.java]

        val adapter= ShoppingItemAdapter(listOf(),viewModel)
        rvShoppingItems.layoutManager= LinearLayoutManager(this)
        rvShoppingItems.adapter= adapter
        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items=it
            adapter.notifyDataSetChanged()
        })
        fab.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener{
                override fun onAddButtonClicked(item: Shopping) {
                   viewModel.upsert(item)
                }

            }).show()
        }



    }
}