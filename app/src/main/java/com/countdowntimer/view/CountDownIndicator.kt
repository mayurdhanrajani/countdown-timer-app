package com.countdowntimer.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.countdowntimer.R
import com.countdowntimer.model.TimerUiState

/** This composable function creates the UI of the CountDown Indicator which will show the progress **/
@Composable
fun CountDownIndicator(timerUiState: TimerUiState) {
    val animatedProgress by animateFloatAsState(
        targetValue = timerUiState.remainingTimeProgress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
    )

    Column(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.SIZE_100DP))) {

        Box {
            val circularProgressDimenSize = dimensionResource(id = R.dimen.SIZE_250DP)

            val circularProgressModifier = Modifier
                .height(circularProgressDimenSize)
                .width(circularProgressDimenSize)

            CircularProgressIndicatorBackground(
                modifier = circularProgressModifier,
                color = colorResource(R.color.progress_foreground_color)
            )

            CircularProgressIndicator(
                progress = animatedProgress,
                modifier = circularProgressModifier,
                color = colorResource(R.color.progress_background_color),
                strokeWidth = dimensionResource(id = R.dimen.SIZE_12DP),
            )

            Column(modifier = Modifier.align(Alignment.Center)) {
                Text(
                    text = timerUiState.remainingTimeString,
                    color = colorResource(id = R.color.text_color_two),
                    fontFamily = FontFamily(Font(R.font.tt_norms_pro_demi_bold)),
                    fontSize = 40.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                )
            }
        }

    }
}

/** This composable function creates the UI of the CountDown Indicator background which will show the progress **/
@Composable
fun CircularProgressIndicatorBackground(
    modifier: Modifier = Modifier, color: Color
) {
    val style = with(LocalDensity.current) { Stroke(12.dp.toPx()) }

    Canvas(modifier = modifier, onDraw = {
        val innerRadius = (size.minDimension.minus(style.width)).div(2)
        drawArc(
            color = color, startAngle = 0f, sweepAngle = 360f, topLeft = Offset(
                (size / 2.0f).width - innerRadius, (size / 2.0f).height - innerRadius
            ), size = Size(innerRadius * 2, innerRadius * 2), useCenter = false, style = style
        )
    })
}