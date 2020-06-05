package com.example.coderswag.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coderswag.R
import com.example.coderswag.models.Product
import com.example.coderswag.utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.product_list_item.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ProductDetailActivity : AppCompatActivity() {
    //lateinit var product: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

       val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceId = this.resources.getIdentifier(product.image,"drawable",this.packageName)
        detailImageView.setImageResource(resourceId)
        detailProductName.text = product.title
        detailProductPrice.text = product.price
      //  Toast.makeText(this," PRODUCT NAME : ${product.title} PRODUCT PRICE : ${product.price}",Toast.LENGTH_SHORT).show()
    }
}