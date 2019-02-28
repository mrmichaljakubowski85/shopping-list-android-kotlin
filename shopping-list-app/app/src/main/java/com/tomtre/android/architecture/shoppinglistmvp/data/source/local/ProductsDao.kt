package com.tomtre.android.architecture.shoppinglistmvp.data.source.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tomtre.android.architecture.shoppinglistmvp.data.Product

interface ProductsDao {

    @Query("SELECT * FROM Products")
    fun getProducts(): List<Product>

    @Query("SELECT * FROM Products WHERE id = :productId")
    fun getProductById(productId: String);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Query("DELETE FROM Products WHERE id = :productId")
    fun deleteProductById(productId: String)

    @Query("UPDATE Products SET checked = :checked WHERE id = :productId")
    fun updateChecked(productId: String, checked: Boolean)

    @Query("DELETE FROM Products WHERE checked = 1")
    fun deleteCheckedProducts()

    @Query("DELETE FROM Products")
    fun deleteProducts()
}