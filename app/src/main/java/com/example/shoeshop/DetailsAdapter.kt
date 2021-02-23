package com.example.shoeshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.databinding.ItemDetailsBinding
import com.example.shoeshop.models.ShoeModel

class DetailsAdapter(
        private val items:List<ShoeModel>,
        private val onItemClick:(ShoeModel)->Unit

):RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDetailsBinding.inflate(layoutInflater, parent, false)
        return DetailsViewHolder(binding,onItemClick)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class DetailsViewHolder(
            private val binding: ItemDetailsBinding,
            private val onItemClick: (ShoeModel) -> Unit

    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ShoeModel) {
            binding.apply {

                imageShoe.setImageResource(item.image)
                detailsBrand.text = item.brand
                detailsModel.text = item.model
                imageDetailsSide.setImageResource(item.imageForDescription)
                detailsPrice.text = item.price
                detailsDescription.text = item.description
                detailsButtonCart.setOnClickListener {
                    onItemClick(item)
                }
            }
        }
    }
}