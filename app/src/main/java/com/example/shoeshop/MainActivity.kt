package com.example.shoeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeshop.databinding.ActivityMainBinding
import com.example.shoeshop.repository.ShoeShopRepository

 class MainActivity : AppCompatActivity(),ShoesAdapter.onItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chip1.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes()
                        ,this@MainActivity)
            }

        }

        binding.chip2.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getAdidasShoes()
                        ,this@MainActivity)
            }
        }

        binding.chip3.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getJordanShoes()
                        ,this@MainActivity)
            }
        }
        binding.chip4.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getRebookShoes()
                        ,this@MainActivity)
            }
        }

        binding.shoesList.apply {
            adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes()
                    ,this@MainActivity)


        layoutManager = LinearLayoutManager(this@MainActivity
                ,LinearLayoutManager.HORIZONTAL,false)


        }



    }
     override fun onItemCLick(position: Int) {

         val intent = Intent(this@MainActivity
                 ,CartActivity::class.java)
         startActivity(intent)



     }


    }


