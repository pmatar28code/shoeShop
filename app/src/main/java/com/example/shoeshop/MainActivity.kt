package com.example.shoeshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeshop.databinding.ActivityMainBinding
import com.example.shoeshop.repository.ShoeShopRepository

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.favoritesSideButton.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getFavoriteShoes(),
                        onItemClick =  {ShoeModel->
                            ShoeShopRepository.addNewShoeOrUpdateQuantity(ShoeModel)
                            adapter?.notifyDataSetChanged()
                            val intent=Intent(this@MainActivity,CartActivity::class.java)
                            startActivity(intent)
                        },
                        onImageClick = {ShoeModel->
                            val detailsList = ShoeShopRepository.getDetailsItems()
                            detailsList.clear()
                            detailsList.add(ShoeModel)
                            adapter?.notifyDataSetChanged()
                            val intent = Intent(this@MainActivity,
                                    ShoeDetails::class.java)
                            startActivity(intent)
                        }
                )
                layoutManager = LinearLayoutManager(this@MainActivity
                        ,LinearLayoutManager.HORIZONTAL,false)
                setHasFixedSize(true)
            }
        }

        binding.moreList.apply {
            adapter = ShoesAdapter(ShoeShopRepository.getMoreShoes(),
                    onItemClick =  {ShoeModel->
                        ShoeShopRepository.addNewShoeOrUpdateQuantity(ShoeModel)
                        adapter?.notifyDataSetChanged()
                        val intent=Intent(this@MainActivity,CartActivity::class.java)
                        startActivity(intent)
                    },
                    onImageClick = {ShoeModel->
                        val detailsList = ShoeShopRepository.getDetailsItems()
                        detailsList.clear()
                        detailsList.add(ShoeModel)
                        adapter?.notifyDataSetChanged()
                        val intent = Intent(this@MainActivity,
                                ShoeDetails::class.java)
                        startActivity(intent)
                    }
            )


            layoutManager = LinearLayoutManager(this@MainActivity
                    ,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)

        }
        binding.chip1.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes(),
                        onItemClick =  {ShoeModel->
                            ShoeShopRepository.addNewShoeOrUpdateQuantity(ShoeModel)
                            adapter?.notifyDataSetChanged()
                            val intent=Intent(this@MainActivity,CartActivity::class.java)
                            startActivity(intent)
                        },
                        onImageClick = {ShoeModel->
                            val detailsList = ShoeShopRepository.getDetailsItems()
                            detailsList.clear()
                            detailsList.add(ShoeModel)
                            adapter?.notifyDataSetChanged()
                            val intent = Intent(this@MainActivity,
                                    ShoeDetails::class.java)
                            startActivity(intent)
                        }
                )
                layoutManager = LinearLayoutManager(this@MainActivity
                        , LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)

            }
        }
        binding.chip2.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getAdidasShoes(),
                        onItemClick =  {ShoeModel->
                            ShoeShopRepository.addNewShoeOrUpdateQuantity(ShoeModel)
                            adapter?.notifyDataSetChanged()
                            val intent=Intent(this@MainActivity,CartActivity::class.java)
                            startActivity(intent)
                        },
                        onImageClick = {ShoeModel->
                            val detailsList = ShoeShopRepository.getDetailsItems()
                            detailsList.clear()
                            detailsList.add(ShoeModel)
                            adapter?.notifyDataSetChanged()
                            val intent = Intent(this@MainActivity,
                                    ShoeDetails::class.java)
                            startActivity(intent)
                        }
                )

                layoutManager = LinearLayoutManager(this@MainActivity
                        , LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)

            }
        }
        binding.chip3.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getJordanShoes(),
                        onItemClick =  {ShoeModel->
                            ShoeShopRepository.addNewShoeOrUpdateQuantity(ShoeModel)
                            adapter?.notifyDataSetChanged()
                            val intent=Intent(this@MainActivity,CartActivity::class.java)
                            startActivity(intent)
                        },
                        onImageClick = {ShoeModel->
                            val detailsList = ShoeShopRepository.getDetailsItems()
                            detailsList.clear()
                            detailsList.add(ShoeModel)
                            adapter?.notifyDataSetChanged()
                            val intent = Intent(this@MainActivity,
                                    ShoeDetails::class.java)
                            startActivity(intent)
                        }
                )

                layoutManager = LinearLayoutManager(this@MainActivity
                        , LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)

            }
        }
        binding.chip4.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getRebookShoes(),
                        onItemClick =  {ShoeModel->
                            ShoeShopRepository.addNewShoeOrUpdateQuantity(ShoeModel)
                            adapter?.notifyDataSetChanged()
                            val intent=Intent(this@MainActivity,CartActivity::class.java)
                            startActivity(intent)
                        },
                        onImageClick = {ShoeModel->
                            val detailsList = ShoeShopRepository.getDetailsItems()
                            detailsList.clear()
                            detailsList.add(ShoeModel)
                            adapter?.notifyDataSetChanged()
                            val intent = Intent(this@MainActivity,
                                    ShoeDetails::class.java)
                            startActivity(intent)
                        }
                )

                layoutManager = LinearLayoutManager(this@MainActivity
                        ,LinearLayoutManager.HORIZONTAL,false)
                setHasFixedSize(true)

            }
        }
        binding.shoesList.apply {
            adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes(),
                    onItemClick =  {ShoeModel->
                        ShoeShopRepository.addNewShoeOrUpdateQuantity(ShoeModel)
                        adapter?.notifyDataSetChanged()
                        val intent=Intent(this@MainActivity,CartActivity::class.java)
                        startActivity(intent)
                    },
                    onImageClick = {ShoeModel->
                        val detailsList = ShoeShopRepository.getDetailsItems()
                        detailsList.clear()
                        detailsList.add(ShoeModel)
                        adapter?.notifyDataSetChanged()
                        val intent = Intent(this@MainActivity,
                                ShoeDetails::class.java)
                        startActivity(intent)
                    })


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





