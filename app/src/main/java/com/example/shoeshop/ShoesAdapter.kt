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
        private val listener: onItemClickListener



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




    inner class ShoesViewHolder(
        private val binding: ItemShoesBinding


    ) : RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        fun bind(shoe:ShoeModel){
        binding.apply {
            brandText.text = shoe.brand
            modelText.text = shoe.model
            priceText.text = shoe.price
            shoeImage.setImageResource(shoe.image)
            favoriteImage.setImageResource(shoe.favoriteImg)

        }

        }
        init {
            binding.favoriteImage.setOnClickListener(this)

        }
        override fun onClick(v:View?){
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemCLick(position)
            }

        }

        }

        interface onItemClickListener{
            fun onItemCLick(position: Int)
        }

    }
