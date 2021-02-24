package com.example.shoeshop.models

data class ShoeModel(
        val brand:String,
        val model:String,
        val price:String,
        val image:Int,
        val favoriteImg:Int,
        val description:String,
        val imageForDescription:Int,
        var quantity:String,
        var subtotal:String
)