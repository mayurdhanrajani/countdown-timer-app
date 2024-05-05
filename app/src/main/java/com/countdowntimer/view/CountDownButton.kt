package com.countdowntimer.view

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.countdowntimer.R

/** This composable function creates the UI of the start/pause/resume/stop button **/
@Composable
fun CountDownButton(
    text: String, buttonClicked: () -> Unit
) {
    Button(
        onClick = {
            buttonClicked()
        },
        modifier = Modifier
            .height(dimensionResource(id = R.dimen.SIZE_60DP))
            .width(dimensionResource(id = R.dimen.SIZE_140DP)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.SIZE_24DP)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.button_color),
            contentColor = colorResource(id = R.color.text_color_one),
        ),
    ) {
        Text(
            text, fontSize = 20.sp, fontFamily = FontFamily(Font(R.font.tt_norms_pro_normal))
        )
    }
}