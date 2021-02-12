package com.example.shoeshop



import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.databinding.ItemShoesBinding
import com.example.shoeshop.models.ShoeModel
import com.example.shoeshop.repository.ShoeShopRepository


class ShoesAdapter(
        private val shoes:List<ShoeModel>,
        private val onClick: (ShoeModel) -> Unit





):RecyclerView.Adapter<ShoesAdapter.ShoesViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemShoesBinding.inflate(
                layoutInflater,parent,false)


        return ShoesViewHolder(binding)
    }

    override fun getItemCount() = shoes.size


    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        val shoe = shoes[position]
        holder.bind(shoe)
        holder.itemView.findViewById<ImageView>(R.id.favorite_image
        ).setOnClickListener {
            ShoeShopRepository.getCartItems().add(shoe)
            onClick(shoe)

            
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







