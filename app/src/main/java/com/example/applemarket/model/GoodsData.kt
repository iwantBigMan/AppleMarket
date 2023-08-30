package com.example.applemarket.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoodsData(
    val gImage: Int,
    val gName: String,
    val address: String,
    val gExp: String,
    val gPrice: Int,
    val sellerName: String,
    var likeCnt: Int,
    val chatCnt: Int,
    var isLike: Boolean
    ) : Parcelable