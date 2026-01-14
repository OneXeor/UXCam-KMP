# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [2.0.0] - 2026-01-14

### Breaking Changes

- **Artifact renamed**: `dev.onexeor:uxcam-kmp-shared` → `dev.onexeor:uxcam-kmp`

  Update your dependencies:
  ```kotlin
  // Before
  implementation("dev.onexeor:uxcam-kmp-shared:<version>")

  // After
  implementation("dev.onexeor:uxcam-kmp:<version>")
  ```

## [1.3.0] - 2026-01-14

### Added

- View-level occlusion APIs: `occludeSensitiveView()`, `unOccludeSensitiveView()`
- Screen ignore list management: `removeScreenNameToIgnore()`, `removeAllScreenNamesToIgnore()`

## [1.2.0] - 2026-01-13

### Added

- Manual screen tagging with `tagScreenName()`
- User URL retrieval with `urlForCurrentUser()`
- Recording status APIs: `isRecording()`, `pendingUploads()`
- GDPR opt-in/opt-out controls:
  - `optOutOverall()`, `optInOverall()`, `optInOverallStatus()`
  - `optOutOfSchematicRecordings()`, `optIntoSchematicRecordings()`, `optInSchematicRecordingStatus()` (iOS only)
- New UXConfig options:
  - `enableMultiSessionRecord`
  - `enableIntegrationLogging`
  - `enableAdvancedGestureRecognition` (iOS only)

## [1.1.1] - 2026-01-13

### Changed

- Switch CI/CD to macOS runners for iOS artifacts support
- Publish iOS artifacts to Maven Central (iosArm64, iosSimulatorArm64, iosX64)

## [1.1.0] - 2026-01-13

### Changed

- Upgrade Kotlin to 2.3.0
- Upgrade Gradle to 8.13
- Upgrade Android Gradle Plugin to 8.13.2
- Migrate from `com.android.library` to `com.android.kotlin.multiplatform.library` plugin
- Update compileSdk/targetSdk to 36
- Update JVM target to 21
- Update Compose BOM to 2025.12.00
- Update UXCam Android SDK to 3.8.8

### Fixed

- Add `@OptIn(ExperimentalForeignApi::class)` for iOS cinterop compatibility with Kotlin 2.x
- Update CI workflows for new KMP plugin task names

### Dependencies

- Kotlin: 2.3.0
- Gradle: 8.13
- AGP: 8.13.2
- UXCam Android SDK: 3.8.8
- Compose BOM: 2025.12.00

## [1.0.0] - 2026-01-12

### Added

- Initial release of UXCam-KMP
- Unified Kotlin API for UXCam SDK (Android & iOS)
- Session recording controls (pause/resume)
- User identification with `setUserIdentity()`
- Custom user properties with `setUserProperty()`
- Event logging with `logEvent()` and optional properties
- Screen privacy controls with `addScreenNameToIgnore()`
- Session management (`startNewSession()`, `stopSessionAndUploadData()`, `cancelCurrentSession()`)
- Session URL retrieval with `urlForCurrentSession()`
- Configuration options:
  - `enableAutomaticScreenNameTagging`
  - `enableImprovedScreenCapture` (Android only)
  - `enableCrashHandling`

### Platform Support

- Android: minSdk 23, compileSdk 33
- iOS: 12.0+
- Kotlin: 1.9.21+

### Dependencies

- UXCam Android SDK: 3.6.12
- UXCam iOS SDK: via CocoaPods
- Napier: 2.7.1 (logging)
