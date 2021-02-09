package com.example.shoeshop

import android.renderscript.ScriptGroup
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeshop.models.ShoeModel

class ShoesAdapter(private val shoes:List<ShoeModel>
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = shoes.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ShoesViewHolder(private val binding:ItemShoesBinding):RecyclerView.ViewHolder(binding){


    }
}