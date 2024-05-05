package com.countdowntimer.utils

import com.countdowntimer.utils.Constants.COUNTDOWN_TIMER_MILLISECONDS_FORMAT
import com.countdowntimer.utils.Constants.COUNTDOWN_TIMER_SECONDS_FORMAT
import com.countdowntimer.utils.Constants.TIME_FORMAT
import java.util.concurrent.TimeUnit

/** This file stores the extension functions to perform some operations on existing classes **/

/** This function converts the milliseconds to readable time format **/
fun Long.formatTime(): String = String.format(
    TIME_FORMAT,
    TimeUnit.MILLISECONDS.toMinutes(this),
    TimeUnit.MILLISECONDS.toSeconds(this).mod(COUNTDOWN_TIMER_SECONDS_FORMAT),
    TimeUnit.MILLISECONDS.toMillis(this).mod(COUNTDOWN_TIMER_MILLISECONDS_FORMAT)
)