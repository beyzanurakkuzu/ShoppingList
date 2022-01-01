package com.beyzaakkuzu.shoppinglist.ui.shoppinglist

import com.beyzaakkuzu.shoppinglist.data.db.entities.Shopping

interface AddDialogListener {
    fun onAddButtonClicked(item:Shopping)
}