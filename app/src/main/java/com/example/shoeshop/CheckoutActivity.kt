package com.example.shoeshop
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shoeshop.databinding.ActivityCheckoutBinding
import com.example.shoeshop.repository.ShoeShopRepository

class CheckoutActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cartList = ShoeShopRepository.getCartItems()

        val totalFromCart = intent.getStringExtra("Total")
         binding.purchasedTotal.text = totalFromCart.toString()
         binding.purchasedToHome.setOnClickListener {
        val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
         }
    }
}