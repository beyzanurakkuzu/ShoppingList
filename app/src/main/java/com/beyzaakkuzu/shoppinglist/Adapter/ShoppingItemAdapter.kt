package com.beyzaakkuzu.shoppinglist.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beyzaakkuzu.shoppinglist.R
import com.beyzaakkuzu.shoppinglist.data.db.entities.Shopping
import com.beyzaakkuzu.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<Shopping>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem= items[position]
        holder.itemView.nameTextView.text = curShoppingItem.name
        holder.itemView.amountTextView.text = "${curShoppingItem.amount}"

        holder.itemView.plus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }
        holder.itemView.delete.setOnClickListener {
                viewModel.delete(curShoppingItem)
            }
        holder.itemView.minus.setOnClickListener {
            if(curShoppingItem.amount>0){
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
        }
        }

    }
    
    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


}