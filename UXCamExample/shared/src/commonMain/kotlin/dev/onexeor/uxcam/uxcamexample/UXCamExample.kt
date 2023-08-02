package dev.onexeor.uxcam.uxcamexample

import dev.onexeor.uxcam.UXCam

class UXCamExample {

    fun start() {
        UXCam.startWithConfiguration("<key>") {
            println("Init result $it")
        }
    }
}
