<p align="center">
  <img src="https://github.com/user-attachments/assets/82d330dd-3c91-4c48-95f6-c34464c7fc9f" alt="logo">
</p>

<h1 align="center">Car Rental Web Application</h1>

Car Rental Web is a web application designed for managing car rentals. It provides users with a seamless experience for browsing available cars, making reservations, and managing their rentals.

<h3 align="center">Design</h3>

## Design Style - Created in Figma
[Figma File](https://www.figma.com/design/HLULD5z6pEzlhatXqrLef8/Car-Rental-Web?node-id=76-178&t=fdV6qBFEQg8gVF7b-1)

### Figma File Preview
![image](https://github.com/user-attachments/assets/f703bbde-6895-4d5c-bb23-44983c2923f6)

<h3 align="center">Application</h3>

### Features
- **User Authentication**: Secure registration and login process for users to access their accounts.
- **Car Listings**: Users can view available cars and apply filters to find their ideal rental.
- **Reservation System**: Streamlined booking process for selecting rental dates and confirming reservations.

### Tech Stack
- **Frontend**: Developed using Spring Boot with HTML, CSS, and JavaScript for a responsive user interface.
- **Backend**: Java serves as the primary language for handling business logic and database interactions.
- **Database**: MariaDB is used for storing user and car rental data.

### Dependencies
- **Spring Boot**
- **Java**
- **HTML/CSS**
- **JavaScript**
- **MariaDB**

<h3 align="center">Database Structure</h3>

### User
- **UserId**: Unique identifier for each user.
- **UserFirstName**: The first name of the user.
- **UserLastName**: The last name of the user.
- **UserHetu**: A user identifier similar to a social security number.
- **UserPassword**: The password for the user’s account.
- **UserEmail**: The email address of the user.

### Vehicle
- **VehicleId**: Unique identifier for each vehicle.
- **VehicleReg**: Registration number of the vehicle.
- **VehicleAvailable**: Indicates if the vehicle is available for rental.
- **VehicleColor**: The color of the vehicle.
- **VehicleType**: Type of the vehicle (e.g., sedan, SUV).
- **VehiclePrice**: Rental price of the vehicle.
- **VehicleModel**: Model of the vehicle.
- **VehicleMF**: Manufacturer of the vehicle.
- **VehicleTrans**: Transmission type of the vehicle (manual/automatic).

### Rental
- **RentalId**: Unique identifier for each rental transaction.
- **RentalDate**: Date when the rental starts.
- **RentalEndDate**: Date when the rental ends.

## ER Diagram
![ER Diagram](https://github.com/user-attachments/assets/a3498790-a376-432c-9b90-186e248400a3)

## ER Relational Schema
![Relational Schema](https://github.com/user-attachments/assets/c1581fa6-a564-4e81-869a-93dc941dcb70)
