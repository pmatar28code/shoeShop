package com.example.shoeshop
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.shoeshop.databinding.ActivityCheckoutBinding
import com.example.shoeshop.databinding.ActivityMainBinding
//import com.example.shoeshop.databinding.ActivityCheckoutBinding
import com.example.shoeshop.repository.ShoeShopRepository


class CheckoutActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var cartList = ShoeShopRepository.getCartItems()

        var totalFromCart = intent.getStringExtra("Total")
         binding.purchasedTotal.text = totalFromCart.toString()

        //textView.text = totalFromCart


        binding.purchasedToHome.setOnClickListener {
        val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }


}