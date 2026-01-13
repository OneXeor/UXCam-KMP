@file:Suppress("UNUSED")

package dev.onexeor.uxcam

expect object UXCam {

    fun startWithConfiguration(
        key: String,
        config: UXConfig = UXConfig(),
        completionHandler: (Boolean) -> Unit = {}
    )

    fun tagScreenName(screenName: String)

    fun addScreenNameToIgnore(screenName: String)

    fun addScreenNamesToIgnore(screenNames: List<String>)

    fun removeScreenNameToIgnore(screenName: String)

    fun removeAllScreenNamesToIgnore()

    fun allowShortBreakForAnotherApp(b: Boolean)

    fun pauseScreenRecording()

    fun resumeScreenRecording()

    fun startNewSession()

    fun stopSessionAndUploadData()

    fun cancelCurrentSession()

    fun urlForCurrentSession(): String?

    fun urlForCurrentUser(): String?

    fun isRecording(): Boolean

    fun pendingUploads(): Int

    fun optOutOverall()

    fun optInOverall()

    fun optInOverallStatus(): Boolean

    fun optOutOfSchematicRecordings()

    fun optIntoSchematicRecordings()

    fun optInSchematicRecordingStatus(): Boolean

    fun setUserIdentity(identity: String)

    fun logEvent(eventName: String?)

    fun logEvent(eventName: String?, withProperties: Map<String?, *>)

    fun setUserProperty(key: String?, value: String?)

    fun setUserProperty(key: String?, value: Int)

    fun setUserProperty(key: String?, value: Float)

    fun setUserProperty(key: String?, value: Boolean)
}

data class UXConfig(
    val enableAutomaticScreenNameTagging: Boolean = true,
    /**
     * Only for Android
     */
    val enableImprovedScreenCapture: Boolean = false,
    val enableCrashHandling: Boolean = true,
    val enableMultiSessionRecord: Boolean = true,
    val enableIntegrationLogging: Boolean = false,
    /**
     * Only for iOS - enables advanced gesture recognition
     */
    val enableAdvancedGestureRecognition: Boolean = false
)
