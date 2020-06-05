package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.R
import com.example.coderswag.models.Category
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryAdapter(private val context: Context, private val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView:View
        val holder : ViewHolder
        if (convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item,parent,false)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryBgImage)
            holder.categoryTitle = categoryView.findViewById(R.id.categoryTitle)
            categoryView.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }
        val resourceId = context.resources.getIdentifier(categories[position].image,"drawable",context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryTitle?.text = categories[position].title
        return categoryView
    }

    override fun getItem(position: Int): Any {
       return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder{
        var categoryImage : ImageView? = null
        var categoryTitle : TextView? = null
    }
}