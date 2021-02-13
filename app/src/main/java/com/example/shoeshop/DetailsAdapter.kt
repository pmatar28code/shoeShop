package com.example.shoeshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.databinding.ItemCartBinding
import com.example.shoeshop.databinding.ItemDetailsBinding
import com.example.shoeshop.databinding.ItemShoesBinding
import com.example.shoeshop.models.CartModel
import com.example.shoeshop.models.ShoeModel

class DetailsAdapter(
        private val items:List<ShoeModel>
       // private val onClick:(shoe:ShoeModel,buttonDown:Button,
                   //          buttonUp:Button,position:Int)->Unit

):RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDetailsBinding.inflate(layoutInflater, parent, false)
        return DetailsViewHolder(binding)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val item = items[position]
        holder.bind(items[position])




    }


    class DetailsViewHolder(private val binding: ItemDetailsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ShoeModel) {
            binding.apply {

                imageShoe.setImageResource(item.image)
                detailsBrand.text = item.brand
                detailsModel.text = item.model
                //detailsButtonCart
                imageDetailsSide.setImageResource(item.imageForDescription)
                detailsPrice.text = item.price
                detailsDescription.text = item.description





            }

        }





    }


}