# MVVM Shopping List
[![BCH compliance](https://bettercodehub.com/edge/badge/beyzanurakkuzu/ShoppingList?branch=main)](https://bettercodehub.com/)

**Architecture**
--
The architecture of this application relies and complies with the following points below:

- A single-activity architecture, using the Navigation Components to manage fragment operations.
- Pattern Model-View-ViewModel(MVVM) which facilitates a separation of development of the graphical user interface.
- Android architecture components which help to keep the application robust, testable, and maintainable.

**Technologies used:**

- **ViewModel:** to store and manage UI-related data in a lifecycle conscious way.
- **LiveData:** to handle data in a lifecycle-aware fashion.
- **Navigation Component:** to handle all navigations and also passing of data between destinations.
- **Kotlin Coroutines:** for managing background threads and reducing needs for callbacks.
- **Room:** persistence library which provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
- **Kodein:** a pure Kotlin dependency injection (DI) framework
