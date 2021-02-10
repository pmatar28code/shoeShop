package com.example.shoeshop.repository

import com.example.shoeshop.R
import com.example.shoeshop.models.ShoeModel

object ShoeShopRepository {


    private val nikeShoes = listOf(
            ShoeModel("Nike", "Air Max Uptempo", "$160", R.drawable.uptempo, R.drawable.ic_baseline_favorite_border_24 ),
            ShoeModel("Nike", "Air Max Sensation","$180",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_border_24),
            ShoeModel("Nike","Air Max CB94","$200",R.drawable.airmaxcb94,R.drawable.ic_baseline_favorite_border_24)
    )

    private val adidasShoes = listOf(
            ShoeModel("Adidas","Adidas 1","$100",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_border_24),
            ShoeModel("Adidas","Adidas 2","$85",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_border_24),
            ShoeModel("Adidas","Adidas 3","$75",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_border_24)
    )

    private val jordanShoes= listOf(
            ShoeModel("Jordan","Jordan XI","$200",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_border_24),
            ShoeModel("Jordan","Jordan X","$180",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_border_24),
            ShoeModel("jordan","Jordan IV","$200",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_border_24)
    )

    private val rebookShoes= listOf(
            ShoeModel("Rebook","Rebook 1","$110",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_border_24),
            ShoeModel("Rebook","Rebook 2","$130",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_border_24),
            ShoeModel("Rebook","Rebook 3","$89",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_border_24)
    )

    fun getNikeShoes() = nikeShoes
    fun getAdidasShoes()= adidasShoes
    fun getJordanShoes()= jordanShoes
    fun getRebookShoes()= rebookShoes









}
