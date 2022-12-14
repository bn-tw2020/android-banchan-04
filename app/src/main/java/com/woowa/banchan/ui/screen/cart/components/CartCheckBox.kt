package com.woowa.banchan.ui.screen.cart.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.woowa.banchan.R

@Composable
fun CartCheckBox(
    modifier: Modifier = Modifier,
    state: CheckState,
    onCheck: () -> Unit,
    onUncheck: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Row(modifier = modifier) {
        Image(
            modifier = Modifier
                .clickable {
                    if (state == CheckState.CHECKED)
                        onUncheck()
                    else
                        onCheck()
                }
                .padding(20.dp),
            painter = if (state == CheckState.CHECKED) painterResource(R.drawable.ic_checkbox)
            else painterResource(R.drawable.ic_checkbox_empty),
            contentDescription = stringResource(R.string.label_checkbox)
        )

        Text(
            modifier = Modifier
                .weight(1f)
                .align(CenterVertically),
            text = if (state == CheckState.CHECKED) stringResource(R.string.cart_deselect)
            else stringResource(R.string.cart_select_all),
            color = colorResource(R.color.black)
        )

        TextButton(
            modifier = Modifier
                .align(CenterVertically)
                .padding(20.dp, 0.dp),
            onClick = onDeleteClick,
            colors = ButtonDefaults.textButtonColors(
                contentColor = colorResource(R.color.gray_default)
            )
        ) {
            Text(text = stringResource(R.string.cart_delete))
        }
    }

    Divider(modifier = modifier, thickness = 1.dp, color = colorResource(R.color.gray_line))
}
