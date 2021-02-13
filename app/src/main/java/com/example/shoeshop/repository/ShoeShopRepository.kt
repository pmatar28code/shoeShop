package com.example.shoeshop.repository

import com.example.shoeshop.R
import com.example.shoeshop.models.CartModel
import com.example.shoeshop.models.ShoeModel

object ShoeShopRepository {


    private val nikeShoes = listOf(
            ShoeModel("Nike", "Air Max Uptempo", "160", R.drawable.uptempo, R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "160",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.uptemposide),
            ShoeModel("Nike", "Air Max Sensation","180",R.drawable.airmaxsensation,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "180",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.airmaxsensationside ),
            ShoeModel("Nike","Air Max CB94","200",R.drawable.cb94,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "200",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.barkleycb94side)
    )

    private val adidasShoes = listOf(
            ShoeModel("Adidas","Adidas 1","100",R.drawable.adidas1,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "100",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.adidas1),
            ShoeModel("Adidas","Adidas 2","85",R.drawable.adidas2,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "85",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.adidas2),
            ShoeModel("Adidas","Adidas 3","75",R.drawable.adidas3,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "75",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.adidas3)
    )

    private val jordanShoes= listOf(
            ShoeModel("Jordan","Jordan XI","200",R.drawable.jordanconcord,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "200",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.jordanconcordside),
            ShoeModel("Jordan","Jordan X","180",R.drawable.jordanx,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "180",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.jordanxside),
            ShoeModel("jordan","Jordan IV","200",R.drawable.jordan4,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "200",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.jordan4side)
    )

    private val rebookShoes= listOf(
            ShoeModel("Rebook","Rebook 1","110",R.drawable.rebook1,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "110",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.rebook1side),
            ShoeModel("Rebook","Rebook 2","130",R.drawable.reebok2,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "130",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.reebok2side),
            ShoeModel("Rebook","Rebook 3","89",R.drawable.reebook3,R.drawable.ic_baseline_favorite_24,quantity = "1",subtotal = "89",description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.reebok3side)
    )


    private val cartItems = mutableListOf<ShoeModel>()
    private val DetailsItems = mutableListOf<ShoeModel>()

    fun getFavoriteShoes():List<ShoeModel>{
        val favList= mutableListOf<ShoeModel>()
        for(shoe in nikeShoes){
            favList.add(shoe)
        }
        for(shoe in jordanShoes){
            favList.add(shoe)
        }
        for(shoe in rebookShoes){
            favList.add(shoe)
        }
        return favList
    }

    fun getMoreShoes():List<ShoeModel>{
        val favList= mutableListOf<ShoeModel>()
        for(shoe in adidasShoes){
            favList.add(shoe)
        }
        for(shoe in rebookShoes){
            favList.add(shoe)
        }
        for(shoe in jordanShoes){
            favList.add(shoe)
        }
        for(shoe in nikeShoes){
            favList.add(shoe)
        }
        return favList
    }

    fun getDetailsItems() = DetailsItems
    fun getCartItems()= cartItems
    fun getNikeShoes() = nikeShoes
    fun getAdidasShoes()= adidasShoes
    fun getJordanShoes()= jordanShoes
    fun getRebookShoes()= rebookShoes




}
