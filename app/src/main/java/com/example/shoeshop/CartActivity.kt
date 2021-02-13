package com.example.shoeshop

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeshop.databinding.ActivityCartBinding
import com.example.shoeshop.repository.ShoeShopRepository

class CartActivity():AppCompatActivity() {
    companion object{
        const val CART = "CART"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.cartList.apply {
            adapter = CartAdapter(ShoeShopRepository.getCartItems()
                    ){item,buttonDown,buttonUp,position ->
                val cartShoes = ShoeShopRepository.getCartItems()
            /*
                if(cartShoes.contains(item)) {
                    var indexCartList = cartShoes.indexOf(item)
                    val itemPrice = cartShoes[indexCartList].price.toInt()
                    var actualQuantity = cartShoes[indexCartList].quantity.toInt()
                    var times = itemPrice * actualQuantity
                    val subTotal = times
                    cartShoes[indexCartList].subtotal = subTotal.toString()


                }
            */

                buttonUp.setOnClickListener{
                    val actualQuantity = item.quantity
                    val left = (actualQuantity.toInt()+1)
                            .toString()
                    item.quantity = left
                    // testing this code-------
                    var indexCartList = cartShoes.indexOf(item)
                    val itemPrice = cartShoes[indexCartList].price.toInt()
                    //var actualQuantity = cartShoes[indexCartList].quantity.toInt()
                    var times = itemPrice * left.toInt()
                    val subTotal = times.toString()
                    cartShoes[indexCartList].subtotal = subTotal.toString()
                    //------------------------
                    adapter?.notifyDataSetChanged()
                }

                buttonDown.setOnClickListener{
                    if(item.quantity=="1"){
                        val cartList =
                                ShoeShopRepository.getCartItems()
                        cartList.removeAt(position)

                        adapter?.notifyDataSetChanged()

                    }else{
                        val actualQuantity = item.quantity
                        val left = (actualQuantity.toInt() -1)
                                .toString()
                        item.quantity = left

                        // testing this code-------
                        var indexCartList = cartShoes.indexOf(item)
                        val itemPrice = cartShoes[indexCartList].price.toInt()
                        //var actualQuantity = cartShoes[indexCartList].quantity.toInt()
                        var times = itemPrice * left.toInt()
                        val subTotal = times.toString()
                        cartShoes[indexCartList].subtotal = subTotal.toString()
                        //------------------------

                        adapter?.notifyDataSetChanged()



                    }
                }


            }


            layoutManager = LinearLayoutManager(this@CartActivity
                    , LinearLayoutManager.VERTICAL,false)



        }

    }


}