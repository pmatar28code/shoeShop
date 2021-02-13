package com.example.shoeshop



import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.databinding.ItemShoesBinding
import com.example.shoeshop.models.ShoeModel
import com.example.shoeshop.repository.ShoeShopRepository


class ShoesAdapter(
        private val shoes:List<ShoeModel>,
        private val onClick: (ShoeModel,itemView:View,imageToD:View,position:Int) -> Unit





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
        val item = holder.itemView.findViewById<ImageView>(R.id.favorite_image
        )


        val imageToDetails = holder.itemView.findViewById<ImageView>(R.id.shoe_image
        )
            onClick(shoe, item,imageToDetails,position)




        }

    //}










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







