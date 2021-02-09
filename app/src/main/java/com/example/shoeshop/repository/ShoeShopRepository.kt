package com.example.shoeshop.repository

import com.example.shoeshop.models.ShoeModel

object ShoeShopRepository {
    private val nikeShoes = listOf(
            ShoeModel("Nike", "Air Max Uptempo", "$160"),
            ShoeModel("Nike", "Air Max Sensation","$180"),
            ShoeModel("Nike","Air Max CB94","$200")
    )

    private val adidasShoes = listOf(
            ShoeModel("Adidas","Adidas 1","$100"),
            ShoeModel("Adidas","Adidas 2","$85"),
            ShoeModel("Adidas","Adidas 3","$75")
    )

    private val jordanShoes= listOf(
            ShoeModel("Jordan","Jordan XI","$200"),
            ShoeModel("Jordan","Jordan X","$180"),
            ShoeModel("jordan","Jordan IV","$200")
    )

    private val rebookShoes= listOf(
            ShoeModel("Rebook","Rebook 1","$110"),
            ShoeModel("Rebook","Rebook 2","$130"),
            ShoeModel("Rebook","Rebook 3","$89")
    )

    fun getNikeShoes() = nikeShoes
    fun getAdidasShoes()= adidasShoes
    fun getJordanShoes()= jordanShoes
    fun getRebookShoes()= rebookShoes


}
