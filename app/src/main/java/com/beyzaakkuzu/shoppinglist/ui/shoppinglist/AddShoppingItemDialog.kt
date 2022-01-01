package com.beyzaakkuzu.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.beyzaakkuzu.shoppinglist.R
import com.beyzaakkuzu.shoppinglist.data.db.entities.Shopping
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        addtextView.setOnClickListener {
            val name= nameTv.text.toString()
            val amount=amountTv.text.toString()
            if(name.isEmpty()||amount.isEmpty()){
                Toast.makeText(context, "Please enter all the information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item= Shopping(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        canceltextView.setOnClickListener {
            cancel()
        }

    }
}
