package com.beyzaakkuzu.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="shopping_items")
data class Shopping(
    @ColumnInfo(name="item_name")
    var name:String,

    @ColumnInfo(name="item_amount")
    var amount:Int,

    @PrimaryKey(autoGenerate = true) val id:Int? = null

)