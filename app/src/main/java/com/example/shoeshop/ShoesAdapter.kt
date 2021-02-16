package com.example.shoeshop



import android.content.Context
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
        var mContext: Context

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

        item.setOnClickListener {
            ShoeShopRepository.addNewShoeOrUpdateQuantity(shoe,this)
            this?.notifyDataSetChanged()
            val intent=Intent(mContext,CartActivity::class.java)
            mContext.startActivity(intent)
        }

        imageToDetails.setOnClickListener {
            val detailsList = ShoeShopRepository.getDetailsItems()
            detailsList.clear()
            detailsList.add(shoe)
            this?.notifyDataSetChanged()
            val intent = Intent(mContext,
                    ShoeDetails::class.java)
            mContext.startActivity(intent)
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







