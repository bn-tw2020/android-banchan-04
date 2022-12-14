package com.woowa.banchan.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val detailHash: String,
    val image: String,
    val alt: String,
    val deliveryType: List<String>,
    val title: String,
    val description: String,
    val nPrice: String?,
    val sPrice: String,
    val badge: List<String>?,
    val viewedAt: String = "",
    var hasCart: Boolean = false
) : Parcelable {
    val discountRate: String
        get() = if (nPrice == null) ""
        else {
            val tempS = sPrice.replace(Regex(",|원"), "").toFloat()
            val tempN = nPrice.replace(Regex(",|원"), "").toFloat()
            "${((tempN - tempS) / tempN * 100).toInt()}%"
        }
}
