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
                    )


            layoutManager = LinearLayoutManager(this@CartActivity
                    , LinearLayoutManager.VERTICAL,false)



        }

    }


}