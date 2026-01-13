# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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
