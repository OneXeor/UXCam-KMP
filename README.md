# UXCam-KMP

A Kotlin Multiplatform wrapper library for [UXCam](https://uxcam.com/) session recording SDK, providing a unified Kotlin API for both Android and iOS platforms.

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.3.0-blue.svg)](https://kotlinlang.org)
[![Platform](https://img.shields.io/badge/Platform-Android%20%7C%20iOS-green.svg)](https://kotlinlang.org/docs/multiplatform.html)

## Features

- Unified Kotlin API for UXCam SDK across Android and iOS
- Full access to UXCam session recording capabilities
- Support for user identification and event logging
- Screen recording controls
- Session management
- Compose Multiplatform compatible

## Requirements

- Android: minSdk 23+ (compileSdk 36, targetSdk 36)
- iOS: 12.0+
- Kotlin: 2.3.0+
- JDK: 21+
- UXCam account and API key

## Installation

### Kotlin Multiplatform

Add the repository to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://sdk.uxcam.com/android/") }
    }
}
```

Add the dependency to your shared module's `build.gradle.kts`:

```kotlin
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation("dev.onexeor:uxcam-kmp:<version>")
        }
    }
}
```

### Android (Gradle)

Add the repository to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://sdk.uxcam.com/android/") }
    }
}
```

Add the dependency to your module's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("dev.onexeor:uxcam-kmp:<version>")
}
```

### iOS (CocoaPods)

Add to your `Podfile`:

```ruby
pod 'uxcam-kmp', :git => 'https://github.com/OneXeor/UXCam-KMP.git'
```

Then run:

```bash
pod install
```

## Quick Start

### Initialize UXCam

```kotlin
import dev.onexeor.uxcam.UXCam
import dev.onexeor.uxcam.UXConfig

// Basic initialization
UXCam.startWithConfiguration(
    key = "YOUR_UXCAM_API_KEY"
) { success ->
    println("UXCam initialized: $success")
}

// With custom configuration
UXCam.startWithConfiguration(
    key = "YOUR_UXCAM_API_KEY",
    config = UXConfig(
        enableAutomaticScreenNameTagging = true,
        enableImprovedScreenCapture = true, // Android only
        enableCrashHandling = true
    )
) { success ->
    println("UXCam initialized: $success")
}
```

### User Identification

```kotlin
UXCam.setUserIdentity("user-123")

UXCam.setUserProperty("plan", "premium")
UXCam.setUserProperty("age", 25)
UXCam.setUserProperty("verified", true)
```

### Event Logging

```kotlin
UXCam.logEvent("button_clicked")

UXCam.logEvent("purchase_completed", mapOf(
    "product_id" to "SKU-123",
    "amount" to 29.99
))
```

### Session Control

```kotlin
// Pause/resume recording
UXCam.pauseScreenRecording()
UXCam.resumeScreenRecording()

// Session management
UXCam.startNewSession()
UXCam.stopSessionAndUploadData()
UXCam.cancelCurrentSession()

// Get current session URL
val sessionUrl = UXCam.urlForCurrentSession()
```

### Screen Privacy

```kotlin
// Ignore specific screens from recording
UXCam.addScreenNameToIgnore("PaymentScreen")
UXCam.addScreenNamesToIgnore(listOf("LoginScreen", "SettingsScreen"))
```

## API Reference

### UXCam Object

| Method | Description |
|--------|-------------|
| `startWithConfiguration(key, config, completionHandler)` | Initialize UXCam with API key and configuration |
| `tagScreenName(screenName)` | Manually tag current screen with a name |
| `setUserIdentity(identity)` | Set user identifier |
| `setUserProperty(key, value)` | Set custom user property |
| `logEvent(eventName, properties?)` | Log custom event |
| `pauseScreenRecording()` | Pause screen recording |
| `resumeScreenRecording()` | Resume screen recording |
| `startNewSession()` | Start a new recording session |
| `stopSessionAndUploadData()` | Stop session and upload data |
| `cancelCurrentSession()` | Cancel current session |
| `urlForCurrentSession()` | Get URL for current session |
| `urlForCurrentUser()` | Get URL for all user's sessions |
| `isRecording()` | Check if recording is currently active |
| `pendingUploads()` | Get count of sessions pending upload |
| `optOutOverall()` | Opt user out of all recording (GDPR) |
| `optInOverall()` | Opt user back into recording |
| `optInOverallStatus()` | Check if user is opted in |
| `optOutOfSchematicRecordings()` | Opt out of schematic recordings (iOS only) |
| `optIntoSchematicRecordings()` | Opt into schematic recordings (iOS only) |
| `optInSchematicRecordingStatus()` | Check schematic recording status (iOS only) |
| `occludeSensitiveView(view)` | Hide sensitive view from recordings |
| `unOccludeSensitiveView(view)` | Remove occlusion from a view |
| `addScreenNameToIgnore(screenName)` | Exclude screen from recording |
| `addScreenNamesToIgnore(screenNames)` | Exclude multiple screens |
| `removeScreenNameToIgnore(screenName)` | Remove screen from ignore list |
| `removeAllScreenNamesToIgnore()` | Clear all ignored screens |
| `allowShortBreakForAnotherApp(b)` | Allow short app switches |

### UXConfig

| Property | Type | Default | Description |
|----------|------|---------|-------------|
| `enableAutomaticScreenNameTagging` | Boolean | `true` | Auto-tag screen names |
| `enableImprovedScreenCapture` | Boolean | `false` | Improved capture (Android only) |
| `enableCrashHandling` | Boolean | `true` | Enable crash reporting |
| `enableMultiSessionRecord` | Boolean | `true` | Record multiple sessions |
| `enableIntegrationLogging` | Boolean | `false` | Enable verbose debug logging |
| `enableAdvancedGestureRecognition` | Boolean | `false` | Advanced gestures (iOS only) |

## Platform-Specific Notes

### Android
- Uses verification listener callback for initialization status
- Supports `enableImprovedScreenCapture` for enhanced recording quality

### iOS
- `enableImprovedScreenCapture` is ignored (Android-only feature)
- Automatically calls `optIntoSchematicRecordings()` during initialization

## Building from Source

```bash
# Build the library
./gradlew :uxcam-kmp:build

# Run tests
./gradlew :uxcam-kmp:allTests

# Generate iOS framework
./gradlew :uxcam-kmp:generateDummyFramework
```

## Roadmap

This project is actively maintained. See our [GitHub Milestones](https://github.com/OneXeor/UXCam-KMP/milestones) for planned releases:

- [**v1.4.0**](https://github.com/OneXeor/UXCam-KMP/milestone/3) - Testing & Documentation
- [**v2.1.0**](https://github.com/OneXeor/UXCam-KMP/milestone/5) - Project Modernization

Contributions are welcome! Check the [open issues](https://github.com/OneXeor/UXCam-KMP/issues) to find something to work on.

## Related Links

- [UXCam Official Documentation](https://developer.uxcam.com/docs)
- [UXCam Android SDK](https://developer.uxcam.com/docs/android)
- [UXCam iOS SDK](https://developer.uxcam.com/docs/ios)

## Contributing

Contributions are welcome! Please read our [Contributing Guidelines](CONTRIBUTING.md) before submitting a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

**Note:** This is a wrapper library. The underlying UXCam SDK is subject to [UXCam's Terms and Conditions](https://help.uxcam.com/en/articles/10222767-terms-and-conditions). You need a valid UXCam account to use this library.
