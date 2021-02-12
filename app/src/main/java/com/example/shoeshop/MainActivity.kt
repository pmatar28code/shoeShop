package com.example.shoeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeshop.databinding.ActivityMainBinding
import com.example.shoeshop.databinding.ItemShoesBinding
import com.example.shoeshop.models.ShoeModel
import com.example.shoeshop.repository.ShoeShopRepository

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.chip1.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes()
                ){cartModel ->
                   // val intent = Intent(this@MainActivity,CartActivity::class.java)
                   // startActivity(intent)

                }
            }

        }

        binding.chip2.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getAdidasShoes()
                ){shoeModel ->
                    //val intent = Intent(this@MainActivity,CartActivity::class.java)
                  //  startActivity(intent)
                    //layoutManager = LinearLayoutManager(this@MainActivity
                     //       ,LinearLayoutManager.HORIZONTAL,false)

                }
            }
        }

        binding.chip3.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getJordanShoes()
                ){shoeModel ->
                 //   val intent = Intent(this@MainActivity,CartActivity::class.java)
                  //  startActivity(intent)
                }
            }
        }
        binding.chip4.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getRebookShoes()
                ){shoeModel ->
                   // val intent = Intent(this@MainActivity,CartActivity::class.java)
                  //  startActivity(intent)
                }
            }
        }

        binding.shoesList.apply {
            adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes()
            ) { shoeModel ->


               // val cartShoes = ShoeShopRepository.getCartItems()
               //cartShoes.add(shoeModel)

               // val intent = Intent(this@MainActivity,CartActivity::class.java)
               // startActivity(intent)

            }

        layoutManager = LinearLayoutManager(this@MainActivity
               ,LinearLayoutManager.HORIZONTAL,false)


        }

        binding.cartImageButton.setOnClickListener {
            val intent = Intent(this,CartActivity::class.java)
            startActivity(intent)
        }




    }



        //MAIN BRACKEt
     }





