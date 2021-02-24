package com.example.shoeshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeshop.databinding.ActivityCartBinding
import com.example.shoeshop.models.ShoeModel
import com.example.shoeshop.repository.ShoeShopRepository

class CartActivity():AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun updateCartAgain(){
            val cartShoes = ShoeShopRepository
                    .getCartItems()
            var totalFromCart=0
            for(item in cartShoes){
                totalFromCart+=item.subtotal.toInt()
            }
           binding.totalTextTitle.text = totalFromCart.toString()
            if(cartShoes.isEmpty()) {
                binding.totalTextTitle.text = "0.00"
            }
        }

        fun checkout(){
            binding.checkoutFloatingCart.
            setOnClickListener{
                val cartShoes = ShoeShopRepository.getCartItems()
                var totalFromCart = 0
                for (item in cartShoes) {
                    totalFromCart += item.subtotal.toInt()
                }
                if (cartShoes.isNotEmpty()) {
                    val intent = Intent(this@CartActivity,
                            CheckoutActivity::class.java)
                    val newTotalFromCart = totalFromCart.toString()
                    intent.putExtra("Total", newTotalFromCart)
                    val listOfShoesInCart =
                            ShoeShopRepository.getCartItems()
                    for (item in listOfShoesInCart) {
                        item.quantity = "1"
                        val indexCartList = cartShoes.indexOf(item)
                        val itemPrice = cartShoes[indexCartList].price.toInt()
                        var times = itemPrice * item.quantity.toInt()
                        val subTotal = times.toString()
                        cartShoes[indexCartList].subtotal = subTotal.toString()
                    }
                    ShoeShopRepository.getCartItems().clear()
                    binding.totalTextTitle.text = "0.00"
                    startActivity(intent)
                }
            }
        }

        fun cartButtonDown(item: ShoeModel, cartList:List<ShoeModel>
                           ,position:Int){
            if (item.quantity == "1") {
                val cartList =
                        ShoeShopRepository.getCartItems()
                cartList.removeAt(position)
                binding.totalTextTitle.text = "0.00"
            } else {
                val actualQuantity = item.quantity
                val left = (actualQuantity.toInt() - 1)
                        .toString()
                item.quantity = left

                val indexCartList = cartList.indexOf(item)
                val itemPrice = cartList[indexCartList].price.toInt()
                val times = itemPrice * left.toInt()
                val subTotal = times.toString()
                cartList[indexCartList].subtotal = subTotal
            }
        }

        updateCartAgain()
        binding.cartList.apply {
            adapter = CartAdapter(ShoeShopRepository.getCartItems(),
                    onButtonDownClick = {item,position ->
                        cartButtonDown(item,ShoeShopRepository.getCartItems(),position)
                        updateCartAgain()
                        adapter?.notifyDataSetChanged()
                    },

                    onButtonUpClick = {item->
                        ShoeShopRepository.cartUpButton(item,ShoeShopRepository.getCartItems())
                        updateCartAgain()
                        adapter?.notifyDataSetChanged()
                    })

            checkout()

            layoutManager = LinearLayoutManager(this@CartActivity
                    , LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)

        }

        binding.homeImage.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}