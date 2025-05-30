# Matrimonial Match App

This is an Android application built with Kotlin and Jetpack Compose that simulates a basic Matrimonial matching interface, similar to apps like Shaadi.com. It fetches potential matches from an API and allows users to accept or decline them. All user decisions are stored locally and persist across offline sessions.

---

## Features

- ✅ Fetches user profiles from the [RandomUser API](https://randomuser.me/api/?results=10)
- ✅ Displays match cards using Jetpack Compose
- ✅ Accept or Decline matches with instant UI feedback
- ✅ Offline support using Room database
- ✅ Modern MVVM architecture with Repository pattern
- ✅ Persistent match status (accepted/declined)
- ✅ Error handling for API and database operations

---

## Architecture

The app follows **MVVM (Model-View-ViewModel)** 

## Libraries Used

| Library | Purpose |
|--------|---------|
| **Jetpack Compose** | Declarative UI framework |
| **Retrofit** | Network API calls |
| **Room** | Local database persistence |
| **LiveData / ViewModel / Lifecycle** | MVVM state management |
| **Glide** (via [Landscapist](https://github.com/skydoves/landscapist)) | Image loading in Compose |
| **Kotlin Coroutines** | Background threading and suspending API calls |

---

## How to Run the App

### 1. Clone the Repository

git clone https://github.com/your-username/Project_Matchmate.git


### 2. Open in Android Studio
Open Android Studio
Click "Open an Existing Project"
Select the cloned directory

### 3. Enable Required Settings
Make sure Jetpack Compose is enabled in the build.gradle
Use minimum SDK 21+
Ensure internet permission is present in AndroidManifest.xml:
<uses-permission android:name="android.permission.INTERNET" />


### 4. Build & Run
Run on emulator or physical device with Android 5.0+.
Internet connection is required for initial fetch.

### 5. Offline Mode Behavior
First fetch stores user data in Room DB.
Once fetched, the app continues to work without internet.
Accept/Decline decisions are stored locally.
When internet is available again, you can optionally trigger re-sync logic.

