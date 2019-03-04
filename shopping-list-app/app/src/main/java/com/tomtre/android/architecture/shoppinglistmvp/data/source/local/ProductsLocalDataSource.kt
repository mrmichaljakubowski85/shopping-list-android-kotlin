package com.tomtre.android.architecture.shoppinglistmvp.data.source.local

import com.tomtre.android.architecture.shoppinglistmvp.data.Product
import com.tomtre.android.architecture.shoppinglistmvp.data.source.ProductDataSource
import com.tomtre.android.architecture.shoppinglistmvp.util.AppExecutors
import java.util.function.Function

class ProductsLocalDataSource
private constructor(
    private val appExecutors: AppExecutors,
    private val productsDao: ProductsDao
) : ProductDataSource {

    companion object {

        private val LOCK = Any()
        private var INSTANCE: ProductsLocalDataSource? = null;

        fun getInstance(appExecutors: AppExecutors, productsDao: ProductsDao): ProductsLocalDataSource {
            if (INSTANCE == null) {
                synchronized(LOCK) {
                    if (INSTANCE == null) {
                        INSTANCE = ProductsLocalDataSource(appExecutors, productsDao)
                    }
                }
            }
            return INSTANCE!!
        }

    }

    override fun getProduct(productId: String, loadProductCallback: ProductDataSource.LoadProductCallback) {
        val runnable = Runnable {
            val product: Product? = productsDao.getProductById(productId)
            executeOnMainThread(
                Runnable {
                    if (product == null) {
                        loadProductCallback.onDataNotAvailable()
                    } else {
                        loadProductCallback.onProductLoaded(product)
                    }
                }
            )
        }
        executeOnDiskIOThread({})

    }

    override fun getProducts(loadProductListCallback: ProductDataSource.LoadProductListCallback) {
        val runnable = Runnable {
            val products = productsDao.getProducts()
            executeOnMainThread(
                Runnable {
                    if (products.isEmpty()) {
                        loadProductListCallback.onDataNotAvailable()
                    } else {
                        loadProductListCallback.onProductsLoaded(products)
                    }

                }
            )
        }
        executeOnDiskIOThread(runnable)
    }

    override fun removeCheckedProducts() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeAllProducts() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

    private fun executeOnMainThread(runnable: Runnable) {
        appExecutors.mainThreadExecutor.execute(runnable)
    }

    private fun executeOnDiskIOThread(runnable: Runnable) {
        appExecutors.diskIOExecutor.execute(runnable)
    }

}