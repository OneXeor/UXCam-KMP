# Contributing to UXCam-KMP

Thank you for your interest in contributing to UXCam-KMP! This document provides guidelines and instructions for contributing.

## Code of Conduct

By participating in this project, you agree to abide by our [Code of Conduct](CODE_OF_CONDUCT.md).

## How to Contribute

### Reporting Bugs

Before creating a bug report, please check existing issues to avoid duplicates.

When reporting a bug, include:
- A clear, descriptive title
- Steps to reproduce the issue
- Expected behavior vs actual behavior
- Platform (Android/iOS) and version
- Kotlin and SDK versions
- Code samples if applicable

### Suggesting Features

Feature requests are welcome. Please:
- Check existing issues for similar suggestions
- Provide a clear description of the feature
- Explain the use case and benefits
- Consider how it fits with existing functionality

### Pull Requests

1. **Fork the repository** and create your branch from `main`

2. **Set up the development environment:**
   ```bash
   # Clone your fork
   git clone https://github.com/YOUR_USERNAME/UXCam-KMP.git
   cd UXCam-KMP

   # Build the project
   ./gradlew :uxcam-kmp-shared:build
   ```

3. **Make your changes:**
   - Follow the existing code style
   - Write clear commit messages
   - Add tests if applicable
   - Update documentation if needed

4. **Test your changes:**
   ```bash
   # Run tests
   ./gradlew :uxcam-kmp-shared:allTests

   # Build the library
   ./gradlew :uxcam-kmp-shared:build
   ```

5. **Submit a Pull Request:**
   - Target the `main` branch
   - Provide a clear description of changes
   - Link related issues
   - Ensure CI checks pass

## Development Setup

### Requirements

- JDK 17+
- Android Studio or IntelliJ IDEA
- macOS (required for iOS builds)
- Xcode (for iOS development)
- CocoaPods (for iOS dependency management)

### Building

```bash
# Full build
./gradlew :uxcam-kmp-shared:build

# Clean build
./gradlew clean :uxcam-kmp-shared:build

# Generate iOS framework
./gradlew :uxcam-kmp-shared:generateDummyFramework
```

### Running Example Apps

**Android:**
```bash
./gradlew :UXCamExample:androidExample:assembleDebug
```

**iOS:**
```bash
./gradlew :uxcam-kmp-shared:generateDummyFramework
cd UXCamExample/iosApp && pod install
# Open UXCamExample/iosApp/iosApp.xcworkspace in Xcode
```

## Code Style

- Follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable and function names
- Keep functions focused and concise
- Add KDoc comments for public APIs

## Commit Messages

- Use present tense ("Add feature" not "Added feature")
- Use imperative mood ("Move cursor to..." not "Moves cursor to...")
- Keep the first line under 72 characters
- Reference issues when applicable

**Examples:**
```
Add user property logging support

Fix session URL returning null on iOS

Update UXCam SDK to version 3.6.12
```

## Questions?

If you have questions, feel free to open an issue for discussion.

Thank you for contributing!
