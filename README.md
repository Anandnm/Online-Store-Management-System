# Online-Store-Management-System
Model:
Product class: Represents a single product in the store.

View:
StoreView class: Responsible for displaying the products and messages to the user.

Controller:
StoreController class: Acts as an intermediary between the model and view. Handles adding, retrieving, updating, and deleting products.

Security Configuration:

SecurityConfig class: Configures Spring Security for the application. It extends WebSecurityConfigurerAdapter and overrides the configure(HttpSecurity http) method to define security rules.
The security configuration specifies that accessing the /products endpoint requires the role "ADMIN". Any other request must be authenticated.
It configures form-based login and logout functionality.
In the configureGlobal(AuthenticationManagerBuilder auth) method, an in-memory user "admin" with the password "admin123" and the role "ADMIN" is set up for testing purposes.

Application:
OnlineStoreMarketingSystemApplication class: The main class that bootstraps the Spring Boot application.
The program follows the Model-View-Controller (MVC) architectural pattern, where the model represents the data and business logic, the view handles the presentation of data, and the controller manages user interactions and updates the model and view accordingly.
Spring Security is integrated into the application to handle authentication and authorization. The SecurityConfig class specifies the security rules, while the configureGlobal() method sets up an in-memory user for testing purposes. The application requires the role "ADMIN" to access the /products endpoint.
By implementing Spring Security, the Online Store Marketing System ensures that only authorized users with the appropriate role can access certain parts of the system, providing an added layer of security to the application.
