# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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
