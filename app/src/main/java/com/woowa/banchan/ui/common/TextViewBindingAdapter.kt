package com.woowa.banchan.ui.common

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.woowa.banchan.utils.toMoneyInt
import com.woowa.banchan.utils.toMoneyString
import com.woowa.banchan.utils.toVisibility

@BindingAdapter("price", "quantity")
fun TextView.setTotalPrice(price: String?, quantity: Int) {
    text = if (price.isNullOrEmpty()) "0원"
    else (price.toMoneyInt() * quantity).toMoneyString()
}

@BindingAdapter("textStrikeThrough")
fun TextView.setTextStrikeThrough(condition: Boolean) {
    if (condition) {
        paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
}

@BindingAdapter("visibility")
fun TextView.setVisibility(condition: Boolean) {
    visibility = condition.toVisibility()
}