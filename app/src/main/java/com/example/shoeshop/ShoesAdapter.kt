package com.example.shoeshop

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.databinding.ItemShoesBinding
import com.example.shoeshop.models.ShoeModel

class ShoesAdapter(private val shoes:List<ShoeModel>
):RecyclerView.Adapter<ShoesAdapter.ShoesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemShoesBinding.inflate(layoutInflater,parent,false)
        return ShoesViewHolder(binding)
    }

    override fun getItemCount() = shoes.size


    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        holder.bind(shoes[position])
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