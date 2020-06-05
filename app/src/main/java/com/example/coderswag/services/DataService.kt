package com.example.coderswag.services

import com.example.coderswag.models.Category
import com.example.coderswag.models.Product

object DataService {

    val categories = listOf(
        Category("SHIRTS","shirtimage"),
        Category("HOODIES","hoodieimage"),
        Category("HATS","hatimage"),
        Category("DIGITAL","digitalgoodsimage")
    )
    val hats = listOf(
        Product("devslopes Graphic Beanie","$18","hat1"),
        Product("devslopes Hat Black","$20","hat2"),
        Product("devslopes Hat white","$18","hat3"),
        Product("devslopes Hat snapback","$22","hat4")
    )

    val shirts = listOf(
        Product("devslopes shirt black","$18","shirt1"),
        Product("devslopes Badge Light Gray","$20","shirt2"),
        Product("devslopes Logo shirt Red","$22","shirt3"),
        Product("devslopes Hustle","$22","shirt4"),
        Product("kockflip studios","$18","shirt5")
    )

    val hoodies = listOf(
        Product("devslopes hoodie gray","$18","hoodie1"),
        Product("devslopes hoodie red","$20","hoodie2"),
        Product("devslopes gray hoodie","$18","hoodie3"),
        Product("devslopes black hoodie","$22","hoodie4")
    )

    val digital = listOf<Product>()

  fun getList(category : String) : List<Product>{
      return when(category){
          "SHIRTS" -> shirts
          "HATS" -> hats
          "HOODIES" -> hoodies
          else -> digital
      }
  }
}