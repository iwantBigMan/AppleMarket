package com.example.applemarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.RecycleItemBinding

class GoodsAdapter(val mGoods: MutableList<GoodsData>):
    RecyclerView.Adapter<GoodsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int){
        holder.goodsImage.setImageResource(mGoods[position].gImage)
        holder.name.text = mGoods[position].gName
        holder.exp.text = mGoods[position].gExp
        holder.price.text = mGoods[position].gPrice

    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mGoods.size
    }


    inner class Holder(private val binding: RecycleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val goodsImage = binding.goodsImage
        val name = binding.gName
        val exp = binding.exp
        val price = binding.gPrice
    }
}