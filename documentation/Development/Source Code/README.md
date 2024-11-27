# **Source Code Documentation**

---

## **Purpose**
The purpose of this documentation is to provide a structured overview of the key components of the source code, facilitating understanding, navigation, and maintenance for developers and other stakeholders.

---

## **Audience**
This documentation is designed for:
1. **Developers**: To help understand the architecture, responsibilities, and functionality of each component.
2. **Maintainers**: To simplify debugging, enhancements, and updates.
3. **New Contributors**: To ease onboarding by providing clear insights into the system’s design and behavior.

---

### **Config**
- **[Security Config](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/Config/SecurityConfig.java)**  
  **Purpose**: Define and customize security settings, including authentication, authorization, CSRF protection, session management, and security headers.
  
- **[Web Config](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/Config/WebConfig.java)**  
  **Purpose**: Configure web-related settings, such as view resolvers, resource handlers, CORS settings, and message converters.  

---

### **DTO**
- **[RentalVehicleResponse](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/DTO/RentalVehicleResponse.java)**  
  **Purpose**: Define a Data Transfer Object (DTO) for representing rental vehicle responses.  

- **[UserDTO](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/DTO/UserDTO.java)**  
  **Purpose**: Define a DTO for representing user details.  

---

### **Controller**
- **[AccessController](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/controller/AccessController.java)**  
  **Purpose**: Handle user profile access by providing endpoints to retrieve user profile information.  

- **[LocalizationController](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/controller/LocalizationController.java)**  
  **Purpose**: Manage localization, offering endpoints for localized messages based on language, country, and page.  

- **[PageController](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/controller/PageController.java)**  
  **Purpose**: Route HTML pages by providing endpoints to serve specific views.  

- **[RentalController](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/controller/RentalController.java)**  
  **Purpose**: Manage rental operations, including renting vehicles and retrieving rental details for authenticated users.  

- **[UserController](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/controller/UserController.java)**  
  **Purpose**: Handle user registration and login functionalities.  

- **[VehicleController](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/controller/VehicleController.java)**  
  **Purpose**: Manage vehicle operations, including retrieving and adding vehicles.  

---

### **Filter**
- **[JwtRequestFilter](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/Filter/JwtRequestFilter.java)**  
  **Purpose**: Validate JWT tokens in incoming requests, ensuring only authenticated requests proceed.  

---

### **Model**
- **[AuthenticationResponse](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/model/AuthenticationResponse.java)**  
  **Purpose**: Represent authentication response details, including username, email, and JWT token.  

- **[RentalTransaction](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/model/RentalTransaction.java)**  
  **Purpose**: Represent rental transactions, detailing rental dates, user, and vehicle information.  

- **[User](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/model/User.java)**  
  **Purpose**: Represent user entity details, such as username, password, email, and localized names.  

- **[Vehicle](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/model/Vehicle.java)**  
  **Purpose**: Represent vehicle entity details, such as registration number, title, year, and availability.  

---

### **Repository**
- **[RentalTransactionRepository](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/repository/RentalTransactionRepository.java)**  
  **Purpose**: Provide database interaction methods for `RentalTransaction` entities.  

- **[UserRepository](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/repository/UserRepository.java)**  
  **Purpose**: Provide database interaction methods for `User` entities.
  
- **[VehicleRepository](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/repository/VehicleRepository.java)**  
  **Purpose**: Provide database interaction methods for `Vehicle` entities.  

---

### **Service**
- **[UserDetailsServiceImpl](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/service/UserDetailsServiceImpl.java)**  
  **Purpose**: Implement the `UserDetailsService` interface, enabling user detail retrieval by username.  

- **[UserService](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/service/UserService.java)**  
  **Purpose**: Provide methods for user registration and login, including password encoding and validation.  

- **[VehicleService](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/service/VehicleService.java)**  
  **Purpose**: Manage vehicle-related operations, such as retrieval and addition of vehicles.  

---

### **Util**
- **[JwtUtil](https://github.com/umuttig37/CarRentalWeb/blob/master/src/main/java/CarRentalWeb/Util/JwtUtil.java)**  
  **Purpose**: Provide utility methods for generating, validating, and extracting JWT token information.  
