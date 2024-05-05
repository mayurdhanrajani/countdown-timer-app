package com.countdowntimer.model

import com.countdowntimer.enums.ButtonState
import com.countdowntimer.enums.ButtonState.START
import com.countdowntimer.enums.TimerStatus
import com.countdowntimer.enums.TimerStatus.STOPPED
import com.countdowntimer.utils.Constants.COUNTDOWN_TIMER_DURATION
import com.countdowntimer.utils.Constants.COUNTDOWN_TIMER_PROGRESS
import com.countdowntimer.utils.formatTime

/** This data class is used to store the Timer Ui State info **/
data class TimerUiState(
    /** This variable stores the time remaining in milliseconds **/
    val remainingTimeDuration: Long = COUNTDOWN_TIMER_DURATION,
    /** This variable stores the time remaining in readable format **/
    val remainingTimeString: String = remainingTimeDuration.formatTime(),
    /** This variable stores the time remaining in Ui indication format **/
    val remainingTimeProgress: Float = COUNTDOWN_TIMER_PROGRESS,
    /** This variable stores the button state **/
    val buttonState: ButtonState = START,
    /** This variable stores the timer status **/
    val timerStatus: TimerStatus = STOPPED
)