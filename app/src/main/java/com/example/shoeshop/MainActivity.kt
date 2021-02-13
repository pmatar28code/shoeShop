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

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.moreList.apply {
            adapter = ShoesAdapter(ShoeShopRepository.getMoreShoes()
            ){shoeModel,item,imageToD,position ->

                item.setOnClickListener {
                    val cartShoes =
                            ShoeShopRepository.getCartItems()
                    if(cartShoes.contains(shoeModel)){
                        var quantityCart = cartShoes.indexOf(shoeModel)
                        val actualQuantity = cartShoes[quantityCart].quantity.toInt()
                        val total =actualQuantity + 1
                        cartShoes[quantityCart].quantity=total.toString()

                        // testing this code-------
                        var indexCartList = cartShoes.indexOf(shoeModel)
                        val itemPrice = cartShoes[indexCartList].price.toInt()
                        //var actualQuantity = cartShoes[indexCartList].quantity.toInt()
                        var times = itemPrice * total.toInt()
                        val subTotal = times.toString()
                        cartShoes[indexCartList].subtotal = subTotal.toString()
                        //------------------------


                        adapter?.notifyDataSetChanged()


                    }else {
                        cartShoes.add(shoeModel)
                        adapter?.notifyDataSetChanged()

                    }


                    val intent = Intent(this@MainActivity,
                            CartActivity::class.java)
                    startActivity(intent)

                }

                imageToD.setOnClickListener {
                    val detailsList = ShoeShopRepository.getDetailsItems()
                    detailsList.clear()
                    detailsList.add(shoeModel)
                    adapter?.notifyDataSetChanged()
                    val intent = Intent(this@MainActivity,
                            ShoeDetails::class.java)
                    startActivity(intent)
                }


            }
            layoutManager = LinearLayoutManager(this@MainActivity
                    ,LinearLayoutManager.HORIZONTAL,false)
        }





        binding.favoritesSideButton.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getFavoriteShoes()
                ){shoeModel,item,imageToD,position ->

                    item.setOnClickListener {
                        val cartShoes =
                                ShoeShopRepository.getCartItems()
                        if(cartShoes.contains(shoeModel)){
                            var quantityCart = cartShoes.indexOf(shoeModel)
                            val actualQuantity = cartShoes[quantityCart].quantity.toInt()
                            val total =actualQuantity + 1
                            cartShoes[quantityCart].quantity=total.toString()

                            // testing this code-------
                            var indexCartList = cartShoes.indexOf(shoeModel)
                            val itemPrice = cartShoes[indexCartList].price.toInt()
                            //var actualQuantity = cartShoes[indexCartList].quantity.toInt()
                            var times = itemPrice * total.toInt()
                            val subTotal = times.toString()
                            cartShoes[indexCartList].subtotal = subTotal.toString()
                            //------------------------


                            adapter?.notifyDataSetChanged()


                        }else {
                            cartShoes.add(shoeModel)
                            adapter?.notifyDataSetChanged()

                        }


                        val intent = Intent(this@MainActivity,
                                CartActivity::class.java)
                        startActivity(intent)

                    }

                    imageToD.setOnClickListener {
                        val detailsList = ShoeShopRepository.getDetailsItems()
                        detailsList.clear()
                        detailsList.add(shoeModel)
                        adapter?.notifyDataSetChanged()
                        val intent = Intent(this@MainActivity,
                                ShoeDetails::class.java)
                        startActivity(intent)
                    }


                }
                layoutManager = LinearLayoutManager(this@MainActivity
                        ,LinearLayoutManager.HORIZONTAL,false)
            }

        }



        binding.chip1.setOnClickListener {
            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes()
                ){shoeModel,item,imageToD,position ->

                    item.setOnClickListener {
                        val cartShoes =
                                ShoeShopRepository.getCartItems()
                        if(cartShoes.contains(shoeModel)){
                            var quantityCart = cartShoes.indexOf(shoeModel)
                            val actualQuantity = cartShoes[quantityCart].quantity.toInt()
                            val total =actualQuantity + 1
                            cartShoes[quantityCart].quantity=total.toString()

                            // testing this code-------
                            var indexCartList = cartShoes.indexOf(shoeModel)
                            val itemPrice = cartShoes[indexCartList].price.toInt()
                            //var actualQuantity = cartShoes[indexCartList].quantity.toInt()
                            var times = itemPrice * total.toInt()
                            val subTotal = times.toString()
                            cartShoes[indexCartList].subtotal = subTotal.toString()
                            //------------------------


                            adapter?.notifyDataSetChanged()


                        }else {
                            cartShoes.add(shoeModel)
                            adapter?.notifyDataSetChanged()

                        }


                        val intent = Intent(this@MainActivity,
                                CartActivity::class.java)
                        startActivity(intent)

                    }

                    imageToD.setOnClickListener {
                        val detailsList = ShoeShopRepository.getDetailsItems()
                        detailsList.clear()
                        detailsList.add(shoeModel)
                        adapter?.notifyDataSetChanged()
                        val intent = Intent(this@MainActivity,
                                ShoeDetails::class.java)
                        startActivity(intent)
                    }


                }
                layoutManager = LinearLayoutManager(this@MainActivity
                 ,LinearLayoutManager.HORIZONTAL,false)
            }

        }

        binding.chip2.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getAdidasShoes()
                ){shoeModel ,item,imageToD,position ->

                    item.setOnClickListener {
                        val cartShoes =
                                ShoeShopRepository.getCartItems()
                        if(cartShoes.contains(shoeModel)){
                            var quantityCart = cartShoes.indexOf(shoeModel)
                            val actualQuantity = cartShoes[quantityCart].quantity.toInt()
                            val total =actualQuantity + 1
                            cartShoes[quantityCart].quantity=total.toString()
                            adapter?.notifyDataSetChanged()


                        }else {
                            cartShoes.add(shoeModel)
                            adapter?.notifyDataSetChanged()

                        }


                        val intent = Intent(this@MainActivity,
                                CartActivity::class.java)
                        startActivity(intent)

                    }

                    imageToD.setOnClickListener {
                        val detailsList = ShoeShopRepository.getDetailsItems()
                        detailsList.clear()
                        detailsList.add(shoeModel)
                        adapter?.notifyDataSetChanged()
                        val intent = Intent(this@MainActivity,
                                ShoeDetails::class.java)
                        startActivity(intent)
                    }


                }
                layoutManager = LinearLayoutManager(this@MainActivity
                        ,LinearLayoutManager.HORIZONTAL,false)
            }
        }

        binding.chip3.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getJordanShoes()
                ){shoeModel,item,imageToD,position ->

                    item.setOnClickListener {
                        val cartShoes =
                                ShoeShopRepository.getCartItems()
                        if(cartShoes.contains(shoeModel)){
                            var quantityCart = cartShoes.indexOf(shoeModel)
                            val actualQuantity = cartShoes[quantityCart].quantity.toInt()
                            val total =actualQuantity + 1
                            cartShoes[quantityCart].quantity=total.toString()
                            adapter?.notifyDataSetChanged()


                        }else {
                            cartShoes.add(shoeModel)
                            adapter?.notifyDataSetChanged()

                        }


                        val intent = Intent(this@MainActivity,
                                CartActivity::class.java)
                        startActivity(intent)

                    }

                    imageToD.setOnClickListener {
                        val detailsList = ShoeShopRepository.getDetailsItems()
                        detailsList.clear()
                        detailsList.add(shoeModel)
                        adapter?.notifyDataSetChanged()
                        val intent = Intent(this@MainActivity,
                                ShoeDetails::class.java)
                        startActivity(intent)
                    }


                }
                layoutManager = LinearLayoutManager(this@MainActivity
                        ,LinearLayoutManager.HORIZONTAL,false)
            }
        }
        binding.chip4.setOnClickListener {

            binding.shoesList.apply {
                adapter = ShoesAdapter(ShoeShopRepository.getRebookShoes()
                ){shoeModel,item,imageToD,position ->

                    item.setOnClickListener {
                        val cartShoes =
                                ShoeShopRepository.getCartItems()
                        if(cartShoes.contains(shoeModel)){
                            var quantityCart = cartShoes.indexOf(shoeModel)
                            val actualQuantity = cartShoes[quantityCart].quantity.toInt()
                            val total =actualQuantity + 1
                            cartShoes[quantityCart].quantity=total.toString()
                            adapter?.notifyDataSetChanged()


                        }else {
                            cartShoes.add(shoeModel)
                            adapter?.notifyDataSetChanged()

                        }


                        val intent = Intent(this@MainActivity,
                                CartActivity::class.java)
                        startActivity(intent)

                    }

                    imageToD.setOnClickListener {
                        val detailsList = ShoeShopRepository.getDetailsItems()
                        detailsList.clear()
                        detailsList.add(shoeModel)
                        adapter?.notifyDataSetChanged()
                        val intent = Intent(this@MainActivity,
                                ShoeDetails::class.java)
                        startActivity(intent)
                    }


                }
                layoutManager = LinearLayoutManager(this@MainActivity
                        ,LinearLayoutManager.HORIZONTAL,false)
            }
        }

        binding.shoesList.apply {
            adapter = ShoesAdapter(ShoeShopRepository.getNikeShoes()
            ) { shoeModel,item,imageToD,position ->


                item.setOnClickListener {
                    val cartShoes =
                            ShoeShopRepository.getCartItems()
                    if(cartShoes.contains(shoeModel)){
                        var quantityCart = cartShoes.indexOf(shoeModel)
                        val actualQuantity = cartShoes[quantityCart].quantity.toInt()
                        val total =actualQuantity + 1
                        cartShoes[quantityCart].quantity=total.toString()
                        adapter?.notifyDataSetChanged()


                    }else {
                        cartShoes.add(shoeModel)
                        adapter?.notifyDataSetChanged()

                    }


                    val intent = Intent(this@MainActivity,
                            CartActivity::class.java)
                    startActivity(intent)

                }

                imageToD.setOnClickListener {
                    val detailsList = ShoeShopRepository.getDetailsItems()
                    detailsList.clear()
                    detailsList.add(shoeModel)
                    adapter?.notifyDataSetChanged()
                    val intent = Intent(this@MainActivity,
                            ShoeDetails::class.java)
                    startActivity(intent)
                }


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





