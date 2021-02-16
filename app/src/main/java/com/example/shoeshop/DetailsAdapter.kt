package com.example.shoeshop

import android.content.Context
import android.content.Intent
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
import com.example.shoeshop.repository.ShoeShopRepository

class DetailsAdapter(
        private val items:List<ShoeModel>,
        val mContext:Context

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

        val detailsCartButton = holder.
        itemView.findViewById<Button>(R.id.details_button_cart)

        detailsCartButton.setOnClickListener{
            val cartShoes =
                    ShoeShopRepository.getCartItems()
            if(cartShoes.contains(item)){
                var quantityCart = cartShoes.indexOf(item)
                val actualQuantity = cartShoes[quantityCart].quantity.toInt()
                val total =actualQuantity + 1
                cartShoes[quantityCart].quantity=total.toString()
                var indexCartList = cartShoes.indexOf(item)
                val itemPrice = cartShoes[indexCartList].price.toInt()
                var times = itemPrice * total.toInt()
                val subTotal = times.toString()
                cartShoes[indexCartList].subtotal = subTotal.toString()
                this?.notifyDataSetChanged()

            }else {
                cartShoes.add(item)
                this?.notifyDataSetChanged()
            }
            val intent = Intent(mContext,
                    CartActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    class DetailsViewHolder(private val binding: ItemDetailsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ShoeModel) {
            binding.apply {

                imageShoe.setImageResource(item.image)
                detailsBrand.text = item.brand
                detailsModel.text = item.model
                detailsButtonCart
                imageDetailsSide.setImageResource(item.imageForDescription)
                detailsPrice.text = item.price
                detailsDescription.text = item.description
            }
        }
    }
}