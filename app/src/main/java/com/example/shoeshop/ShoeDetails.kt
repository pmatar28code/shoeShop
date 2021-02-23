package com.example.shoeshop

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeshop.databinding.ActivityDetailsBinding
import com.example.shoeshop.models.ShoeModel
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
                            var quantityCart = cartShoes.indexOf(ShoeModel)
                            val actualQuantity = cartShoes[quantityCart].quantity.toInt()
                            val total =actualQuantity + 1
                            cartShoes[quantityCart].quantity=total.toString()
                            var indexCartList = cartShoes.indexOf(ShoeModel)
                            val itemPrice = cartShoes[indexCartList].price.toInt()
                            var times = itemPrice * total.toInt()
                            val subTotal = times.toString()
                            cartShoes[indexCartList].subtotal = subTotal.toString()
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
