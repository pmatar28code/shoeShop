package com.example.shoeshop

import android.R
import android.R.attr.phoneNumber
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.databinding.ItemShoesBinding
import com.example.shoeshop.models.ShoeModel


class ShoesAdapter(
        private val shoes:List<ShoeModel>,
        private val context: Context

):RecyclerView.Adapter<ShoesAdapter.ShoesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemShoesBinding.inflate(layoutInflater,parent,false)


        return ShoesViewHolder(binding)
    }

    override fun getItemCount() = shoes.size


    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        val shoe = shoes[position]
        holder.bind(shoes[position])


    }

     fun onClick(view: View,position: Int,context: Context){
         val position = shoes[position]
         val intent =Intent(view.context,TestActivity::class.java)
         context.startActivity(intent)

     }

    fun ViewHolder( binding: ItemShoesBinding,position: Int,context: Context
    ){
        binding.apply {
            favoriteImage.setOnClickListener { context }
        }


    }


    class ShoesViewHolder(
        private val binding: ItemShoesBinding

    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(shoe:ShoeModel){
        binding.apply {
            brandText.text = shoe.brand
            modelText.text = shoe.model
            priceText.text = shoe.price
            shoeImage.setImageResource(shoe.image)
            favoriteImage.setImageResource(shoe.favoriteImg)

        }

        }

        }

    }
