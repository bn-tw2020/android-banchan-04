package com.woowa.banchan.ui.screen.cart.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.woowa.banchan.R
import com.woowa.banchan.extensions.toMoneyString

@Composable
fun CartPriceColumn(
    modifier: Modifier = Modifier,
    totalPrice: Int,
    deliveryFee: Int = 0
) {
    Column(
        modifier = modifier
            .padding(16.dp, 8.dp)
            .width(IntrinsicSize.Max),
        horizontalAlignment = Alignment.End
    ) {
        PriceRow(
            label = stringResource(R.string.cart_ordering_price),
            price = totalPrice.toMoneyString(),
            color = colorResource(R.color.gray_default)
        )

        PriceRow(
            label = stringResource(R.string.delivery_fee),
            price = deliveryFee.toMoneyString(),
            color = colorResource(R.color.gray_default)
        )

        Divider(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            thickness = 1.dp,
            color = colorResource(R.color.gray_line)
        )

        PriceRow(
            label = stringResource(R.string.total_price),
            price = (totalPrice + deliveryFee).toMoneyString(),
            color = colorResource(R.color.black)
        )
    }
}

@Composable
private fun PriceRow(
    label: String,
    price: String,
    color: Color
) {
    Row(
        modifier = Modifier
            .padding(0.dp, 8.dp)
            .width(240.dp)
    ) {
        Text(modifier = Modifier.weight(1f), text = label, color = color)
        Text(modifier = Modifier.weight(1f), text = price, color = color, textAlign = TextAlign.End)
    }
}
