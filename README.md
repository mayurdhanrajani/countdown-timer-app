# Countdown Timer

## Info

- Countdown Timer is a straightforward app which will show a countdown timer of 1 minute. It is
  made entirely in Kotlin using Jetpack compose.
- It has 2 buttons:
    1. Stop - It will stop the timer and reset to 1 minute.
    2. Start/Resume/Pause - The same button performs multiple operation based on the state.
        1. Start - It will start the timer.
        2. Pause - It will pause the timer.
        3. Resume - It will resume the timer if it is paused.
- Initially only the Start button will be visible. Stop button will be visible only if the timer is
  running. If the timer is stopped or the timer is finished, it will hide.
- The app is made in Light and Dark modes. It will show the app based on the theme selected as
  System Default in the app settings.
- The apk is located in the project itself which can be used to run the app.

## Solution Design

- The entire app is connected with dependencies using the Koin framework.
- The ViewModel with StateFlows are used to update the UI values of the timer when operations are
  performed either manually or by timer.
- Finally, for the UI part, since it takes a lot of time to design a good UI, I went with the
  black-and-white approach. The UI will change once the dark mode is changed in the system settings.