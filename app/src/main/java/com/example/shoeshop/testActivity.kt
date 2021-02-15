package com.example.shoeshop
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.shoeshop.databinding.ActivityTestBinding
import com.example.shoeshop.repository.ShoeShopRepository


class TestActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var cartList = ShoeShopRepository.getCartItems()

        var totalFromCart = intent.getStringExtra("Total")
        if (cartList.isEmpty()){
            binding.purchasedTotal.text = "0.00"
        }else{ binding.purchasedTotal.text = totalFromCart}

        //textView.text = totalFromCart


        binding.purchasedToHome.setOnClickListener {
            ShoeShopRepository.getCartItems().clear()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


}