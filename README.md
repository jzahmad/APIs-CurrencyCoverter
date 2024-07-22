## USD Converter App

This Android application provides real-time currency conversion rates for various currencies based on the US Dollar
(USD). It fetches exchange rates from a third-party API and displays them in a user-friendly list format.

### Features

* **Fetch live exchange rates:** Retrieves latest conversion rates from the ExchangeRate-API.
* **Store and display rates:** Caches fetched rates for offline viewing and efficient access.
* **User-friendly interface:** Presents conversion rates in a clear and organized list view.

### Tech Stack

* **Languages:** Kotlin
* **Framework:** Android SDK
* **Technologies:**
* **Retrofit:** Network library for fetching data from API.
* **Room Persistence Library:** SQLite database for local data storage.
* **RecyclerView:** Displays currency conversion rates in a scrollable list.
* **ViewModel:** Manages UI data and business logic.

### Installation & Setup

1. **Install Android Studio:** Download and install the latest version of Android Studio from
[https://developer.android.com/studio](https://developer.android.com/studio).
2. **Clone the repository:** Clone this repository to your local machine.
3. **Open in Android Studio:** Open the cloned project folder in Android Studio.
4. **Install Dependencies:** Ensure all dependencies are installed by syncing the project with Gradle files. (Android
Studio should prompt you for this)
5. **Obtain API Key:**
* Visit [https://exchangerate-api.com/](https://exchangerate-api.com/) and sign up for a free account.
* Get your API key from your account dashboard.
6. **Configure API Key:**
* Open `app/src/main/java/com/example/partb/ApiInterface/ApiUtilities.kt`.
* Replace the placeholder `\"144fd292bc37de3553dc2e47/\"` in the `BASE_URL` constant with your actual API key.


### Running the Project

1. **Build and run:** In Android Studio, click the "Run" button or select "Run > Run 'app'" from the menu.
2. **Connect a device or emulator:** Connect a physical Android device or use an emulator to run the app.
3. **View conversion rates:** The app will automatically fetch the latest exchange rates and display them in the list
view.

### Testing

* **Unit testing:** The project includes basic unit tests for some classes. You can run them from Android Studio's "Run"
menu.
* **UI testing:** Consider adding UI tests for more comprehensive coverage.

### Contributing

Contributions are welcome! To contribute:

1. Fork this repository.
2. Create a new branch for your feature or fix.
3. Commit your changes with clear and descriptive messages.
4. Push your changes to your fork.
5. Create a pull request to the main repository.

### Licensing

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
