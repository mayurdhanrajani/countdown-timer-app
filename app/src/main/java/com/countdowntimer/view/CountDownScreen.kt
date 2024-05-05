package com.countdowntimer.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.countdowntimer.R
import com.countdowntimer.enums.ButtonState
import com.countdowntimer.model.TimerUiState
import com.countdowntimer.viewmodel.CountDownViewModel
import org.koin.androidx.compose.koinViewModel

/** This composable creates the CountDownViewModel using Koin and updates the value of UI using TimerUiState model **/
@Composable
fun CountDownScreen(viewModel: CountDownViewModel = koinViewModel()) {
    val timerUiState by viewModel.timerUiState.collectAsState()

    CountDownContent(timerUiState, {
        viewModel.updateTimerUiState()
    }, {
        viewModel.stopTimer()
    })
}

/** This composable function creates the UI of the CountDown screen which will show the timer, progress and buttons to perform actions **/
@Composable
fun CountDownContent(
    timerUiState: TimerUiState, buttonStateClicked: () -> Unit, stopButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.status_bar_color)), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.timer),
            color = colorResource(id = R.color.text_color_two),
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.SIZE_50DP)),
            fontFamily = FontFamily(Font(R.font.tt_norms_pro_demi_bold))
        )

        CountDownIndicator(timerUiState)

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.SIZE_100DP))
        ) {
            CountDownButton(
                timerUiState.buttonState.toString()
            ) {
                buttonStateClicked()
            }
            if (timerUiState.buttonState != ButtonState.START) {
                CountDownButton(
                    stringResource(id = R.string.stop)
                ) {
                    stopButtonClicked()
                }
            }
        }
    }
}