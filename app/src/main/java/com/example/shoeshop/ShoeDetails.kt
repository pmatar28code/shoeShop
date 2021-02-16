package com.example.shoeshop

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup
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
            context)
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
