<p align="center">
  <img src="https://github.com/user-attachments/assets/82d330dd-3c91-4c48-95f6-c34464c7fc9f" alt="logo">
</p>

<h1 align="center">🚗 Car Rental Web Application</h1>

Car Rental Web is a web application designed for managing car rentals. It provides users with a seamless experience for browsing available cars, making reservations, and managing their rentals.

---

<h3 align="center">🎨 Design</h3>

## Design Style - Created in Figma
🔗 [Figma File](https://www.figma.com/design/HLULD5z6pEzlhatXqrLef8/Car-Rental-Web?node-id=76-178&t=fdV6qBFEQg8gVF7b-1)

### Figma File Preview
![Figma Preview](https://github.com/user-attachments/assets/f703bbde-6895-4d5c-bb23-44983c2923f6)

---

<h3 align="center">💻 Application Features</h3>

### Key Features
- 🔐 **User Authentication**: Secure registration and login for users.
- 🚗 **Car Listings**: View available cars and apply filters to find the ideal rental.
- 📅 **Reservation System**: Easily select rental dates and confirm reservations.

---

<h3 align="center">🛠️ Tech Stack</h3>

| **Tech**          | **Description**                              |
|-------------------|----------------------------------------------|
| ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)           | Backend logic and business operations     |
| ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)  | Framework for backend services            |
| ![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)     | Database for storing rental and user data |
| ![HTML](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)          | Frontend structure                        |
| ![CSS](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)            | Styling for the user interface            |
| ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) | Interactivity in the frontend             |

---

<h3 align="center">📦 Dependencies</h3>

- **Spring Boot**
- **Java**
- **HTML/CSS**
- **JavaScript**
- **MariaDB**

---

<h3 align="center">🗄️ Database Structure</h3>

### User Table
| Field           | Description                                   |
|-----------------|-----------------------------------------------|
| **UserId**      | Unique identifier for each user.              |
| **UserFirstName** | The first name of the user.                  |
| **UserLastName**  | The last name of the user.                   |
| **UserHetu**    | A unique identifier (similar to SSN).         |
| **UserPassword** | Password for the user’s account.             |
| **UserEmail**   | User's email address.                         |

### Vehicle Table
| Field             | Description                                |
|-------------------|--------------------------------------------|
| **VehicleId**      | Unique identifier for each vehicle.        |
| **VehicleReg**     | Vehicle registration number.               |
| **VehicleAvailable** | Availability status for rentals.        |
| **VehicleColor**   | Color of the vehicle.                     |
| **VehicleType**    | Vehicle type (e.g., Sedan, SUV).          |
| **VehiclePrice**   | Rental price of the vehicle.              |
| **VehicleModel**   | Vehicle model.                            |
| **VehicleMF**      | Manufacturer of the vehicle.              |
| **VehicleTrans**   | Transmission type (manual/automatic).     |

### Rental Table
| Field             | Description                                |
|-------------------|--------------------------------------------|
| **RentalId**       | Unique identifier for each rental.         |
| **RentalDate**     | Start date of the rental.                  |
| **RentalEndDate**  | End date of the rental.                    |

---

## 📊 ER Diagram
![ER Diagram](https://github.com/user-attachments/assets/a3498790-a376-432c-9b90-186e248400a3)

## 🔗 ER Relational Schema
![Relation Schema](https://github.com/user-attachments/assets/7faf8e76-a301-40c6-935c-fceb5708f4ef)

