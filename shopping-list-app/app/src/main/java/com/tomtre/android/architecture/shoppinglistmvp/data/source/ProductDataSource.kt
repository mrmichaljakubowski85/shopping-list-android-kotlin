package com.tomtre.android.architecture.shoppinglistmvp.data.source

import com.tomtre.android.architecture.shoppinglistmvp.data.Product

interface ProductDataSource {

    interface LoadProductListCallback {

        fun onProductsLoaded(products: List<Product>)

        fun onDataNotAvailable()
    }

    interface LoadProductCallback {

        fun onProductLoaded(product: Product)

        fun onDataNotAvailable()
    }

    fun getProducts(loadProductListCallback: LoadProductListCallback)

    fun removeCheckedProducts()

    fun removeAllProducts()

    fun getProduct(productId: String, loadProductCallback: LoadProductCallback)

    fun saveProduct(product: Product)

    fun removeProduct(productId: String)

    fun checkProduct(product: Product)

    fun checkProduct(productId: String)

    fun uncheckProduct(product: Product)

    fun uncheckProduct(productId: String)
}