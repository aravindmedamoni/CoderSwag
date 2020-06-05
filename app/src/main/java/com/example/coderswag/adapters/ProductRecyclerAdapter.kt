package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.models.Product

class ProductRecyclerAdapter(private val context: Context, val products: List<Product>,val itemclick:(Product) -> Unit) : RecyclerView.Adapter<ProductRecyclerAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view, itemclick)
    }

    override fun getItemCount(): Int {
       return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.productBindHolder(context,products[position])
    }

    inner class ProductHolder(itemView: View, val itemClick : (Product) ->Unit) : RecyclerView.ViewHolder(itemView){
        private val productImage: ImageView = itemView.findViewById<ImageView>(R.id.productImage)
        private val productName: TextView = itemView.findViewById<TextView>(R.id.productName)
        private val productPrice: TextView = itemView.findViewById<TextView>(R.id.productPrice)

        fun productBindHolder(context : Context, product:Product){
            val resourceId = context.resources.getIdentifier(product.image,"drawable",context.packageName)
            productImage.setImageResource(resourceId)
            productName.text = product.title
            productPrice.text = product.price
            itemView.setOnClickListener { itemclick(product) }
        }
    }
}