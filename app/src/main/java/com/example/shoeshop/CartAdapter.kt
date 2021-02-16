package com.example.shoeshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.databinding.ActivityCartBinding
import com.example.shoeshop.databinding.ItemCartBinding
import com.example.shoeshop.databinding.ItemShoesBinding
import com.example.shoeshop.models.CartModel
import com.example.shoeshop.models.ShoeModel
import com.example.shoeshop.repository.ShoeShopRepository

class CartAdapter(
        private val items:List<ShoeModel>,
        val mContext:Context,
        private val onClick:(shoe:ShoeModel) ->Unit



):RecyclerView.Adapter<CartAdapter.CartViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCartBinding.inflate(layoutInflater, parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = items[position]
        holder.bind(items[position])

        val quantityView = holder.itemView.
        findViewById<TextView>(R.id.cartQuantity)

        quantityView.text = item.quantity

        val buttonDown=
                holder.itemView.findViewById<Button>(R.id.button_down)
        val buttonUp =
                holder.itemView.findViewById<Button>(R.id.button_up)

        buttonDown.setOnClickListener {

            ShoeShopRepository.cartButtonDown(item,items,mContext,position)
            this.notifyDataSetChanged()
        }

        buttonUp.setOnClickListener {
            ShoeShopRepository.cartUpButton(item,items)
            this.notifyDataSetChanged()
        }
        onClick(item)
    }

     class CartViewHolder(private val binding: ItemCartBinding
    ) : RecyclerView.ViewHolder(binding.root) {

         fun bind(item: ShoeModel) {
            binding.apply {
                cartModel.text = item.model
                cartPrice.text = item.price
                cartShoeImage.setImageResource(item.image)
                cartQuantity.text = item.quantity
                //buttonUp
                //buttonDown
                cartSubtotalSum.text = item.subtotal
            }
         }
     }
}