@file:Suppress("UNUSED")

package dev.onexeor.uxcam

import com.uxcam.OnVerificationListener
import com.uxcam.UXCam
import com.uxcam.datamodel.UXConfig

actual object UXCam {

    actual fun startWithConfiguration(
        key: String,
        config: dev.onexeor.uxcam.UXConfig,
        completionHandler: (Boolean) -> Unit
    ) {
        val config = UXConfig.Builder(key)
            .enableAutomaticScreenNameTagging(config.enableAutomaticScreenNameTagging)
            .enableImprovedScreenCapture(config.enableImprovedScreenCapture)
            .enableCrashHandling(config.enableCrashHandling)
            .build()
        UXCam.startWithConfiguration(config)
        UXCam.addVerificationListener(object : OnVerificationListener {
            override fun onVerificationSuccess() {
                completionHandler(true)
            }

            override fun onVerificationFailed(p0: String?) {
                p0?.let(System.err::println)
                completionHandler(false)
            }
        })
    }

    actual fun addScreenNameToIgnore(screenName: String) {
        UXCam.addScreenNameToIgnore(screenName)
    }

    actual fun addScreenNamesToIgnore(screenNames: List<String>) {
        UXCam.addScreenNamesToIgnore(screenNames)
    }

    actual fun allowShortBreakForAnotherApp(b: Boolean) {
        UXCam.allowShortBreakForAnotherApp(b)
    }

    actual fun pauseScreenRecording() {
        UXCam.pauseScreenRecording()
    }

    actual fun resumeScreenRecording() {
        UXCam.resumeScreenRecording()
    }

    actual fun startNewSession() {
        UXCam.startNewSession()
    }

    actual fun stopSessionAndUploadData() {
        UXCam.stopSessionAndUploadData()
    }

    actual fun cancelCurrentSession() {
        UXCam.cancelCurrentSession()
    }

    actual fun urlForCurrentSession(): String? = UXCam.urlForCurrentSession()

    actual fun setUserIdentity(identity: String) {
        UXCam.setUserIdentity(identity)
    }

    actual fun setUserProperty(key: String?, value: String?) {
        UXCam.setUserProperty(key, value)
    }

    actual fun logEvent(eventName: String?) {
        UXCam.logEvent(eventName)
    }

    actual fun logEvent(eventName: String?, withProperties: Map<String?, *>) {
        UXCam.logEvent(eventName, withProperties)
    }

    actual fun setUserProperty(key: String?, value: Int) {
        UXCam.setUserProperty(key, value)
    }

    actual fun setUserProperty(key: String?, value: Float) {
        UXCam.setUserProperty(key, value)
    }

    actual fun setUserProperty(key: String?, value: Boolean) {
        UXCam.setUserProperty(key, value)
    }
}
