package com.example.shoeshop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
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
                        binding.totalTextTitle.text="0.00"

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

                var totalFromCart=0
                for(item in cartShoes){
                    totalFromCart+=item.subtotal.toInt()

                }
                if(cartShoes.isEmpty()) {
                    binding.totalTextTitle.text = "0.00"
                    //adapter?.notifyDataSetChanged()
                }else{
                    binding.totalTextTitle.text = totalFromCart.toString()
                }

                binding.checkoutButtonCart.setOnClickListener{
                    if(!cartShoes.isEmpty()){



                        var intent = Intent(this@CartActivity,TestActivity::class.java)
                        val newTotalFromCart = totalFromCart.toString()
                        intent.putExtra("Total", newTotalFromCart)
                        var listOfShoesInCart = ShoeShopRepository.getCartItems()
                        for(item in listOfShoesInCart){
                            item.quantity = "1"
                            var indexCartList = cartShoes.indexOf(item)
                            val itemPrice = cartShoes[indexCartList].price.toInt()
                            //var actualQuantity = cartShoes[indexCartList].quantity.toInt()
                            var times = itemPrice * item.quantity.toInt()
                            val subTotal = times.toString()
                            cartShoes[indexCartList].subtotal = subTotal.toString()
                        }
                        ShoeShopRepository.getCartItems().clear()
                        adapter?.notifyDataSetChanged()
                        startActivity(intent)
                    }

                }


            }


            layoutManager = LinearLayoutManager(this@CartActivity
                    , LinearLayoutManager.VERTICAL,false)





        }

    binding.homeImage.setOnClickListener {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    }




}