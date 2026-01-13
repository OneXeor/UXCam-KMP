@file:Suppress("UNUSED")

package dev.onexeor.uxcam

import com.uxcam.OnVerificationListener
import com.uxcam.UXCam
import com.uxcam.datamodel.UXConfig
import io.github.aakira.napier.Napier

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
                p0?.let { Napier.e("UXCam verification failed: $it") }
                completionHandler(false)
            }
        })
    }

    actual fun tagScreenName(screenName: String) {
        UXCam.tagScreenName(screenName)
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
        if (key != null && value != null) {
            UXCam.setUserProperty(key, value)
        }
    }

    actual fun logEvent(eventName: String?) {
        eventName?.let { UXCam.logEvent(it) }
    }

    actual fun logEvent(eventName: String?, withProperties: Map<String?, *>) {
        eventName?.let { UXCam.logEvent(it, withProperties) }
    }

    actual fun setUserProperty(key: String?, value: Int) {
        key?.let { UXCam.setUserProperty(it, value) }
    }

    actual fun setUserProperty(key: String?, value: Float) {
        key?.let { UXCam.setUserProperty(it, value) }
    }

    actual fun setUserProperty(key: String?, value: Boolean) {
        key?.let { UXCam.setUserProperty(it, value) }
    }
}
