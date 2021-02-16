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
            adapter = CartAdapter(ShoeShopRepository.getCartItems(),context
            ) {item ->
                val cartShoes = ShoeShopRepository.getCartItems()
                var totalFromCart=0
                for(item in cartShoes){
                    totalFromCart+=item.subtotal.toInt()
                }
                if(cartShoes.isEmpty()) {
                    binding.totalTextTitle.text = "0.00"
                    adapter?.notifyDataSetChanged()
                }else{
                    binding.totalTextTitle.text = totalFromCart.toString()
                }
                binding.checkoutFloatingCart.setOnClickListener{
                    if(!cartShoes.isEmpty()){
                        var intent = Intent(this@CartActivity,
                                CheckoutActivity::class.java)
                        val newTotalFromCart = totalFromCart.toString()
                        intent.putExtra("Total", newTotalFromCart)
                        var listOfShoesInCart =
                                ShoeShopRepository.getCartItems()
                        for(item in listOfShoesInCart){
                            item.quantity = "1"
                            var indexCartList = cartShoes.indexOf(item)
                            val itemPrice = cartShoes[indexCartList].price.toInt()
                            var times = itemPrice * item.quantity.toInt()
                            val subTotal = times.toString()
                            cartShoes[indexCartList].subtotal = subTotal.toString()
                        }
                        ShoeShopRepository.getCartItems().clear()
                        binding.totalTextTitle.text = "0.00"
                        adapter?.notifyDataSetChanged()
                        startActivity(intent)
                    }
                }
            }
            layoutManager = LinearLayoutManager(this@CartActivity
                    , LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)

        }

        binding.homeImage.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}