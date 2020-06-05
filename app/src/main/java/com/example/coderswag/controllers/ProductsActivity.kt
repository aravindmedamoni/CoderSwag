package com.example.coderswag.controllers

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.utilities.EXTRA_CATEGORY
import com.example.coderswag.R
import com.example.coderswag.adapters.ProductRecyclerAdapter
import com.example.coderswag.models.Product
import com.example.coderswag.services.DataService
import com.example.coderswag.utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductRecyclerAdapter
    lateinit var product: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        product = Product("","","")
        val category = intent.getStringExtra(EXTRA_CATEGORY)
        val products = DataService.getList(category!!)
        adapter = ProductRecyclerAdapter(this,products){
            product ->
//            this.product.image = product.image
//            this.product.title = product.title
//            this.product.price = product.price
                val productDetailIntent = Intent(this,ProductDetailActivity::class.java)
                productDetailIntent.putExtra(EXTRA_PRODUCT,product)
                startActivity(productDetailIntent)
        }

        var spanCount = 2
        val orintation = resources.configuration.orientation
        if(orintation == Configuration.ORIENTATION_LANDSCAPE)
            spanCount = 3
        val screenSize = resources.configuration.screenHeightDp
        if(screenSize > 720)
            spanCount = 3

       val layoutManager = GridLayoutManager(this,spanCount)
        productListView.layoutManager = layoutManager
        productListView.setHasFixedSize(true)
        productListView.adapter = adapter

    }
}