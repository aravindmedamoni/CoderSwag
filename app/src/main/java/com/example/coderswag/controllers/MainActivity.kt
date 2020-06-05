package com.example.coderswag.controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.utilities.EXTRA_CATEGORY
import com.example.coderswag.R
import com.example.coderswag.adapters.CategoryRecyclerViewAdapter
import com.example.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  // lateinit var adapter :CategoryAdapter
  lateinit var adapter : CategoryRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //adapter = CategoryAdapter(this,DataService.categories)
        adapter = CategoryRecyclerViewAdapter(this,DataService.categories){
          category ->
            val productIntent = Intent(this,ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(productIntent)
        }
        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
        categoryListView.adapter = adapter
        // below code is for setting the onclick listener to the listView

//        categoryListView.setOnItemClickListener { parent, view, position, id ->
//            val category = DataService.categories[position];
//            Toast.makeText(this,"You clicked on ${category.title} cell",Toast.LENGTH_SHORT).show()
//        }
    }
}