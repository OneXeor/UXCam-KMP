@file:Suppress("UNUSED")

package dev.onexeor.uxcam

import cocoapods.UXCam.UXCam
import cocoapods.UXCam.UXCamConfiguration

actual object UXCam {

    actual fun startWithConfiguration(
        key: String,
        config: UXConfig,
        completionHandler: (Boolean) -> Unit
    ) {
        val configuration = UXCamConfiguration(key).apply {
            enableAutomaticScreenNameTagging = config.enableAutomaticScreenNameTagging
            enableCrashHandling = config.enableCrashHandling
        }
        UXCam.optIntoSchematicRecordings()
        UXCam.startWithConfiguration(configuration, completionHandler)
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

    actual fun logEvent(eventName: String?) {
        eventName?.let { UXCam.logEvent(eventName = it) }
    }

    actual fun logEvent(eventName: String?, withProperties: Map<String?, *>) {
        val properties = withProperties.entries.associate { it.key as Any? to it.value }
        eventName?.let { UXCam.logEvent(eventName = it, withProperties = properties) }
    }

    actual fun setUserProperty(key: String?, value: String?) {
        if (value != null && key != null) {
            UXCam.setUserProperty(key, value)
        }
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
