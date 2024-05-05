package com.countdowntimer.utils

/** This object stores the constant values used in the project **/
object Constants {

    /** This variable stores the countdown timer duration in milliseconds **/
    const val COUNTDOWN_TIMER_DURATION = 60000L

    /** This variable stores the progress value which will fill the animation ring based on how much it has progressed **/
    const val COUNTDOWN_TIMER_PROGRESS = 1.0F

    /** This variable stores the mod operation value which will show the seconds remaining in readable format **/
    const val COUNTDOWN_TIMER_SECONDS_FORMAT = 60

    /** This variable stores the mod operation value which will show the milliseconds remaining in readable format **/
    const val COUNTDOWN_TIMER_MILLISECONDS_FORMAT = 100

    /** This variable stores the value at which the timer will respond every milliseconds **/
    const val COUNTDOWN_INTERVAL_MILLISECONDS = 10L

    /** This variable stores the time format which will be shown on the screen **/
    const val TIME_FORMAT = "%02d:%02d:%02d"

}