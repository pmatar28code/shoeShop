package com.example.shoeshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.databinding.ItemCartBinding
import com.example.shoeshop.databinding.ItemShoesBinding
import com.example.shoeshop.models.ShoeModel

class CartAdapter(private val items:List<ShoeModel>,
                  private val listener: onItemClickListener
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
    }


    inner class CartViewHolder(private val binding: ItemCartBinding
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(shoe: ShoeModel) {
            binding.apply {

                cartModel.text = item
                cartPrice.text = items.price
                cartShoeImage.setImageResource(items.image)

            }

        }

        init {
            binding.buttonUp.setOnClickListener(this)
            binding.buttonDown.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemCLick(position)
            }
        }

    }

    interface onItemClickListener {
        fun onItemCLick(position: Int)
    }
}