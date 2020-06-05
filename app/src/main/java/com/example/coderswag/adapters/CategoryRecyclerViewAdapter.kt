package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.models.Category
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryRecyclerViewAdapter (private val context : Context, private val categories : List<Category>, private val itemClick : (Category) -> Unit): RecyclerView.Adapter<CategoryRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)
        return Holder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(context,categories[position])
    }

    inner class Holder(itemView: View, val itemClick : (Category) -> Unit) : RecyclerView.ViewHolder(itemView){
        private val categoryImage: ImageView = itemView.findViewById<ImageView>(R.id.categoryBgImage)
        private val categoryTitle: TextView = itemView.findViewById<TextView>(R.id.categoryTitle)
        fun bindCategory(context:Context, category : Category){
             val resourceId = context.resources.getIdentifier(category.image,"drawable",context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryTitle.text = category.title
            itemView.setOnClickListener { itemClick( category) }
        }
    }
}