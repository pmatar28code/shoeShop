package com.example.shoeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeshop.databinding.ActivityMainBinding
import com.example.shoeshop.databinding.ItemShoesBinding
import com.example.shoeshop.models.ShoeModel
import com.example.shoeshop.repository.ShoeShopRepository

 class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.favoritesSideButton.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getFavoriteShoes(),
                        this@MainActivity)
                layoutManager = LinearLayoutManager(this@MainActivity
                        ,LinearLayoutManager.HORIZONTAL,false)
                setHasFixedSize(true)
            }
        }

        binding.moreList.apply {
            adapter = ShoesAdapter(ShoeShopRepository.getMoreShoes(),
                    this@MainActivity
            )
            layoutManager = LinearLayoutManager(this@MainActivity
                    ,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)

        }
        binding.chip1.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes(),
                        this@MainActivity
                )
                layoutManager = LinearLayoutManager(this@MainActivity
                        , LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)

            }
        }
        binding.chip2.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getAdidasShoes(), this@MainActivity
                )
                layoutManager = LinearLayoutManager(this@MainActivity
                        , LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)

            }
        }
        binding.chip3.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getJordanShoes(), this@MainActivity
                )
                layoutManager = LinearLayoutManager(this@MainActivity
                        , LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)

            }
        }
        binding.chip4.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getRebookShoes(),this@MainActivity
                )
                layoutManager = LinearLayoutManager(this@MainActivity
                        ,LinearLayoutManager.HORIZONTAL,false)
                setHasFixedSize(true)

            }
        }
        binding.shoesList.apply {
            adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes(),this@MainActivity
            )
            layoutManager = LinearLayoutManager(this@MainActivity
               ,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)

        }
        binding.cartImageButton.setOnClickListener {
            val intent = Intent(this,CartActivity::class.java)
            startActivity(intent)
        }
    }
 }





