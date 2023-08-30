package com.example.applemarket

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.example.applemarket.databinding.ActivityGoodsDetailBinding
import com.example.applemarket.model.GoodsData
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

class GoodsDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityGoodsDetailBinding
    private var isLike = false
    private val item : GoodsData? by lazy  {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getParcelableExtra(Constants.ITEM_OBJECT, GoodsData::class.java)
        }else{
            intent.getParcelableExtra<GoodsData>(Constants.ITEM_OBJECT)
        }
    }

    private val itemPosition: Int by lazy {
        intent.getIntExtra(Constants.ITEM_INDEX, 0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoodsDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.d("jblee", "itemPosition = $itemPosition" )


        binding.itemImage.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(
                resources,
                it.gImage,
                null
            )
        })

        binding.sellerName.text = item?.sellerName
        binding.sellerAddress.text = item?.address
        binding.goodsTitle.text = item?.gName
        binding.itemExp.text = item?.gExp
        binding.detailPrice.text = DecimalFormat("#,###").format(item?.gPrice)+ "원"

        isLike = item?.isLike == true

        binding.ivDetailLike.setImageResource(if (isLike){R.drawable.trueheart}else{R.drawable.heart})

        binding.backB.setOnClickListener{
            exit()
        }

        binding.detailLike.setOnClickListener{
            isLike = if (!isLike){
                binding.ivDetailLike.setImageResource(R.drawable.trueheart)
                Snackbar.make(binding.snackbarAction, "관심 목록에 추가되었습니다.", Snackbar.LENGTH_SHORT).show()
                true
            }else{
                binding.ivDetailLike.setImageResource(R.drawable.heart)
                false
            }
        }
    }


private fun exit(){
    val intent = Intent(this, MainActivity::class.java).apply {
        putExtra("itemIndex", itemPosition)
        putExtra("isLike", isLike)
        }
    setResult(RESULT_OK, intent)
    if (!isFinishing) finish()
    }


    override fun onBackPressed() {
        exit()
    }
}