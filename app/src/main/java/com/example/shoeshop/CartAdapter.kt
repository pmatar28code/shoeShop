package com.example.shoeshop

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.databinding.ItemCartBinding
import com.example.shoeshop.models.ShoeModel

class CartAdapter(
        private val items:List<ShoeModel>,
        private val onButtonDownClick:(ShoeModel,Int) -> Unit,
        private val onButtonUpClick:(ShoeModel) -> Unit
):RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            :CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCartBinding.inflate(
                layoutInflater, parent, false)
        return CartViewHolder(binding,onButtonUpClick)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(
            holder: CartViewHolder,position: Int) {
        val item = items[position]
        holder.bind(items[position])
        val buttonDown=
                holder.itemView.findViewById<Button>(R.id.button_down)

        buttonDown.setOnClickListener {
            onButtonDownClick(item,position)
        }
    }

    class CartViewHolder(
             private val binding: ItemCartBinding,
             private val onButtonUpClick: (ShoeModel) -> Unit

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ShoeModel) {
            binding.apply {
                cartModel.text = item.model
                cartPrice.text = item.price
                cartShoeImage.setImageResource(item.image)
                cartQuantity.text = item.quantity
                cartSubtotalSum.text = item.subtotal
                buttonUp.setOnClickListener {
                    onButtonUpClick(item)
                }
            }
         }
     }
}