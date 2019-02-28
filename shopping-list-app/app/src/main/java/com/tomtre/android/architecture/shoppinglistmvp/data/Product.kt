package com.tomtre.android.architecture.shoppinglistmvp.data

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tomtre.android.architecture.shoppinglistmvp.util.CommonUtils.leftSubString

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey @NonNull val id : String,
    @NonNull val title : String,
    @Nullable val description : String,
    @Nullable val quantity : String,
    @Nullable val unit : String,
    val checked : Boolean
) {
    override fun toString(): String {

        return "Product(id='${leftSubString(id, 8)}', title='$title', description='$description', quantity='$quantity', unit='$unit', checked=$checked)"
    }
}