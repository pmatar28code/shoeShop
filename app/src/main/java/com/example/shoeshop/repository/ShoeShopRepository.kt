package com.example.shoeshop.repository

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.widget.Adapter
import androidx.constraintlayout.widget.ConstraintSet
import com.example.shoeshop.CartActivity
import com.example.shoeshop.R
import com.example.shoeshop.ShoesAdapter
import com.example.shoeshop.databinding.ActivityCartBinding
import com.example.shoeshop.models.CartModel
import com.example.shoeshop.models.ShoeModel

object ShoeShopRepository {

    private val nikeShoes = listOf(
            ShoeModel("Nike", "Air Max Uptempo", "160", R.drawable.uptempo, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "160", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.uptemposide),
            ShoeModel("Nike", "Air Max Sensation", "180", R.drawable.airmaxsensation, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "180", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.airmaxsensationside),
            ShoeModel("Nike", "Air Max CB94", "200", R.drawable.cb94, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "200", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.barkleycb94side)
    )
    private val adidasShoes = listOf(
            ShoeModel("Adidas", "Adidas 1", "100", R.drawable.adidas1, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "100", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.adidas1),
            ShoeModel("Adidas", "Adidas 2", "85", R.drawable.adidas2, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "85", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.adidas2),
            ShoeModel("Adidas", "Adidas 3", "75", R.drawable.adidas3, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "75", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.adidas3)
    )
    private val jordanShoes = listOf(
            ShoeModel("Jordan", "Jordan XI", "200", R.drawable.jordanconcord, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "200", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.jordanconcordside),
            ShoeModel("Jordan", "Jordan X", "180", R.drawable.jordanx, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "180", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.jordanxside),
            ShoeModel("jordan", "Jordan IV", "200", R.drawable.jordan4, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "200", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.jordan4side)
    )
    private val rebookShoes = listOf(
            ShoeModel("Rebook", "Rebook 1", "110", R.drawable.rebook1, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "110", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.rebook1side),
            ShoeModel("Rebook", "Rebook 2", "130", R.drawable.reebok2, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "130", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.reebok2side),
            ShoeModel("Rebook", "Rebook 3", "89", R.drawable.reebook3, R.drawable.ic_baseline_favorite_24, quantity = "1", subtotal = "89", description = "There's a generation of sneakerheads who probably aren't aware that Chris Webber was once a Nike signature athlete. But Nike's latest retro takes us back to 1995,wore this shoe on the court.", imageForDescription = R.drawable.reebok3side)
    )
    private val cartItems = mutableListOf<ShoeModel>()
    private val DetailsItems = mutableListOf<ShoeModel>()

    fun getFavoriteShoes(): List<ShoeModel> {
        val favList = mutableListOf<ShoeModel>()
        for (shoe in nikeShoes) {
            favList.add(shoe)
        }
        for (shoe in jordanShoes) {
            favList.add(shoe)
        }
        for (shoe in rebookShoes) {
            favList.add(shoe)
        }
        return favList
    }

    fun getMoreShoes(): List<ShoeModel> {
        val favList = mutableListOf<ShoeModel>()
        for (shoe in adidasShoes) {
            favList.add(shoe)
        }
        for (shoe in rebookShoes) {
            favList.add(shoe)
        }
        for (shoe in jordanShoes) {
            favList.add(shoe)
        }
        for (shoe in nikeShoes) {
            favList.add(shoe)
        }
        return favList
    }

    fun getDetailsItems() = DetailsItems
    fun getCartItems() = cartItems
    fun getNikeShoes() = nikeShoes
    fun getAdidasShoes() = adidasShoes
    fun getJordanShoes() = jordanShoes
    fun getRebookShoes() = rebookShoes

    fun addNewShoeOrUpdateQuantity(shoeModel: ShoeModel, adapter: ShoesAdapter) {
        val cartShoes =
                ShoeShopRepository.getCartItems()
        if (cartShoes.contains(shoeModel)) {
            var quantityCart = cartShoes.indexOf(shoeModel)
            val actualQuantity = cartShoes[quantityCart].quantity.toInt()
            val total = actualQuantity + 1
            cartShoes[quantityCart].quantity = total.toString()
            var indexCartList = cartShoes.indexOf(shoeModel)
            val itemPrice = cartShoes[indexCartList].price.toInt()
            var times = itemPrice * total.toInt()
            val subTotal = times.toString()
            cartShoes[indexCartList].subtotal = subTotal.toString()
        } else {
            cartShoes.add(shoeModel)
        }
    }

    fun cartUpButton(item: ShoeModel, cartShoes: List<ShoeModel>) {
        val actualQuantity = item.quantity
        val left = (actualQuantity.toInt() + 1)
                .toString()
        item.quantity = left
        // testing this code-------
        var indexCartList = cartShoes.indexOf(item)
        val itemPrice = cartShoes[indexCartList].price.toInt()
        //var actualQuantity = cartShoes[indexCartList].quantity.toInt()
        var times = itemPrice * left.toInt()
        val subTotal = times.toString()
        cartShoes[indexCartList].subtotal = subTotal.toString()

    }

    fun cartButtonDown(item:ShoeModel,cartList:List<ShoeModel>,mContext:Context,position:Int){
        val layoutInflater=LayoutInflater.from(mContext)
        var binding = ActivityCartBinding.inflate(layoutInflater)
        if (item.quantity == "1") {
            val cartList =
                    ShoeShopRepository.getCartItems()
            cartList.removeAt(position)
            binding.totalTextTitle.text = "0.00"
        } else {
            val actualQuantity = item.quantity
            val left = (actualQuantity.toInt() - 1)
                    .toString()
            item.quantity = left

            var indexCartList = cartList.indexOf(item)
            val itemPrice = cartList[indexCartList].price.toInt()
            var times = itemPrice * left.toInt()
            val subTotal = times.toString()
            cartList[indexCartList].subtotal = subTotal.toString()
        }
    }
}


