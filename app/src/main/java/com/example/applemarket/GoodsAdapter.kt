package com.example.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.RecycleItemBinding
import com.example.applemarket.model.GoodsData
import java.text.DecimalFormat

class GoodsAdapter(val mGoods: MutableList<GoodsData>):
    RecyclerView.Adapter<GoodsAdapter.Holder>() {

    interface ItemLongClick {
        fun onLongClick(view: View, position: Int )

    }
    interface ItemClick {
        fun onClick(view: View, position: Int )
    }
    var itemClick: ItemClick? = null
    var itemLongClick: ItemLongClick? = null


    // onCreateViewHolder 메소드는 새로운 ViewHolder 객체를 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }


    // onBindViewHolder 메소드는 ViewHolder와 데이터를 연결
    override fun onBindViewHolder(holder: Holder, position: Int){

        holder.itemView.setOnClickListener{
          itemClick?.onClick(it, position)
        }

        holder.itemView.setOnLongClickListener() OnLongClickListener@{
            itemLongClick?.onLongClick(it, position)
            return@OnLongClickListener true
        }
        holder.goodsImage.setImageResource(mGoods[position].gImage)
        holder.name.text = mGoods[position].gName
        holder.exp.text = mGoods[position].address
       val price = mGoods[position].gPrice
        holder.price.text = DecimalFormat("#,###").format(price) + "원"
        holder.tvLikeCnt.text = mGoods[position].likeCnt.toString()
        holder.tvChatCnt.text = mGoods[position].chatCnt.toString()

        if (mGoods[position].isLike){
            holder.adapterLike.setImageResource(R.drawable.trueheart)
        }else{
            holder.adapterLike.setImageResource(R.drawable.heart)
        }

    }


    // getItemId 메소드는 아이템의 고유 식별자를 반환
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    // getItemCount 메소드는 어댑터가 관리하는 데이터 아이템의 수를 반환
    override fun getItemCount(): Int {
        return mGoods.size
    }

    // ViewHolder 클래스는 각 아이템의 뷰 요소들을 보유
    inner class Holder(private val binding: RecycleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val goodsImage = binding.goodsImage
        val name = binding.gName
        val exp = binding.exp
        val price = binding.gPrice
        val tvLikeCnt = binding.hCount
        val tvChatCnt = binding.cCount
        val adapterLike = binding.mainLike

    }

}