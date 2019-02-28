package com.tomtre.android.architecture.shoppinglistmvp.data.source.local

import com.tomtre.android.architecture.shoppinglistmvp.data.Product
import com.tomtre.android.architecture.shoppinglistmvp.data.source.ProductDataSource
import com.tomtre.android.architecture.shoppinglistmvp.util.AppExecutors

class ProductsLocalDataSource
private constructor(val appExecutors: AppExecutors, val productsDao: ProductsDao) : ProductDataSource {

    companion object {

        @Volatile
        private var INSTANCE: ProductsLocalDataSource? = null;

        fun getInstance(appExecutors: AppExecutors, productsDao: ProductsDao): ProductsLocalDataSource {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: ProductsLocalDataSource(appExecutors, productsDao)
            }
        }

    }

    override fun getProducts(loadProductListCallback: ProductDataSource.LoadProductListCallback) {

    }

    override fun removeCheckedProducts() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeAllProducts() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProduct(productId: String, loadProductCallback: ProductDataSource.LoadProductCallback) {
        Runnable {
            val product = productsDao.getProductById(productId);
            executeOnMainThread(
                if (pro)
            )
        }
    }

    override fun saveProduct(product: Product) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeProduct(productId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checkProduct(product: Product) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checkProduct(productId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun uncheckProduct(product: Product) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun uncheckProduct(productId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun executeOnMainThread(runnable: Runnable) {
        appExecutors.getMainThreadExecutor().execute(runnable)
    }

    fun executeOnDiskIOThread(runnable: Runnable) {
        appExecutors.getDiskIOExecutor().execute(runnable)
    }

}