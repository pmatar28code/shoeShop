package com.example.shoeshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeshop.databinding.ActivityDetailsBinding
import com.example.shoeshop.repository.ShoeShopRepository

class ShoeDetails:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailsList.apply {
            adapter = DetailsAdapter(ShoeShopRepository.getDetailsItems(),
                    onItemClick = {ShoeModel ->

                        val cartShoes =
                                ShoeShopRepository.getCartItems()
                        if(cartShoes.contains(ShoeModel)){
                            val quantityCart = cartShoes.indexOf(ShoeModel)
                            val actualQuantity = cartShoes[quantityCart].quantity.toInt()
                            val total =actualQuantity + 1
                            cartShoes[quantityCart].quantity=total.toString()
                            val indexCartList = cartShoes.indexOf(ShoeModel)
                            val itemPrice = cartShoes[indexCartList].price.toInt()
                            val times = itemPrice * total
                            val subTotal = times.toString()
                            cartShoes[indexCartList].subtotal = subTotal
                            adapter?.notifyDataSetChanged()

                        }else {
                            cartShoes.add(ShoeModel)
                            adapter?.notifyDataSetChanged()
                        }
                        val intent = Intent(this@ShoeDetails,
                                CartActivity::class.java)
                        startActivity(intent)
                    }
            )
            layoutManager = LinearLayoutManager(this@ShoeDetails
                    , LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
        }
        binding.homeImageDetails.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
