package com.example.shoeshop

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.databinding.ActivityMainBinding
import com.example.shoeshop.databinding.ItemShoesBinding
import com.example.shoeshop.repository.ShoeShopRepository

class MainActivity : AppCompatActivity(),ShoesAdapter.onItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.shoesList.apply {
            adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes(),this@MainActivity)


        layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)


        }



    }

    override fun onItemCLick(position: Int) {
        val intent = Intent(this@MainActivity,TestActivity::class.java)
        startActivity(intent)
    }


}