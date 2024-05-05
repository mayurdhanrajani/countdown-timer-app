package com.countdowntimer.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import com.countdowntimer.enums.ButtonState.*
import com.countdowntimer.enums.TimerStatus.RUNNING
import com.countdowntimer.enums.TimerStatus.STOPPED
import com.countdowntimer.model.TimerUiState
import com.countdowntimer.utils.Constants.COUNTDOWN_INTERVAL_MILLISECONDS
import com.countdowntimer.utils.Constants.COUNTDOWN_TIMER_DURATION
import com.countdowntimer.utils.Constants.COUNTDOWN_TIMER_PROGRESS
import com.countdowntimer.utils.formatTime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/** This ViewModel is used to observe the LiveData of all different variables and perform operations using functions
 *  of a timer based on which the UI is updated with being lifecycle aware **/
class CountDownViewModel : ViewModel() {

    private lateinit var countDownTimer: CountDownTimer

    /** This variable sets the value of a timer either by a timer or a user **/
    private val _timerUiState = MutableStateFlow(TimerUiState())

    /** This variable emits the value when it is changed either by a timer or a user **/
    val timerUiState: StateFlow<TimerUiState> = _timerUiState

    /** This function updates the state of CountDownTimer **/
    fun updateTimerUiState() {
        when (_timerUiState.value.timerStatus) {
            STOPPED -> startTimer()
            RUNNING -> pauseTimer()
        }
    }

    /** This function starts the CountDownTimer **/
    private fun startTimer() {
        countDownTimer = object : CountDownTimer(
            _timerUiState.value.remainingTimeDuration, COUNTDOWN_INTERVAL_MILLISECONDS
        ) {
            override fun onTick(millisUntilFinished: Long) {
                _timerUiState.value = TimerUiState(
                    remainingTimeDuration = millisUntilFinished,
                    remainingTimeProgress = millisUntilFinished.toFloat()
                        .div(COUNTDOWN_TIMER_DURATION),
                    remainingTimeString = millisUntilFinished.formatTime(),
                    timerStatus = RUNNING,
                    buttonState = PAUSE
                )
            }

            override fun onFinish() {
                _timerUiState.value = getResetTimerUiState()
            }
        }

        countDownTimer.start()
    }

    /** This function pauses the CountDownTimer **/
    private fun pauseTimer() {
        countDownTimer.cancel()
        _timerUiState.value = _timerUiState.value.copy(
            timerStatus = STOPPED, buttonState = RESUME
        )
    }

    /** This function stops the CountDownTimer **/
    fun stopTimer() {
        countDownTimer.cancel()
        _timerUiState.value = getResetTimerUiState()
    }

    /** This function resets the CountDownTimer **/
    private fun getResetTimerUiState(): TimerUiState = TimerUiState(
        timerStatus = STOPPED,
        buttonState = START,
        remainingTimeDuration = COUNTDOWN_TIMER_DURATION,
        remainingTimeProgress = COUNTDOWN_TIMER_PROGRESS,
    )

}