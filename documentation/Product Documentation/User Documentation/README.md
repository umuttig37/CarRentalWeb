# Car Rental System User Documentation

Welcome to the **Car Rental System** user guide! This document will help you understand and use the application effectively. This guide provides everything you need to get started.

---

## **Table of Contents**
1. [Overview](#overview)  
2. [Installation Guide](#installation-guide)  
3. [Getting Started](#getting-started)  
4. [Key Features](#key-features)  
5. [FAQs](#faqs)  
6. [Troubleshooting](#troubleshooting)   

---

## **Overview**  
The **Car Rental System** is a browser-based Java Spring Boot application designed to streamline the process of renting vehicles.  
- **Platform:** Accessible at `http://localhost:8080`  
- **Database:** MariaDB  

---

## **Installation Guide**  

### Prerequisites  
Before installing, ensure you have:  
- **Java 17** or later installed  
- **Maven** installed   
- **Browser** (e.g., Chrome, Firefox)

---

## **Steps to Install**

### 1. Clone the Repository  
Clone the project repository to your local machine:  
```bash
git clone https://github.com/umuttig37/CarRentalWeb.git
```

### 2. Navigate to the Project Directory  
Change to the project directory:  
```bash
cd car-rental-system
```

### 3. Build the Project  
Run Maven to build the project:  
```bash
mvn clean install
```

### 4. Create the MariaDB Database  
1. Log in to your MariaDB instance:  
   ```bash
   mysql -u your_username -p
   ```
2. Create a new database called `CarRentalSystem`:  
   ```sql
   CREATE DATABASE CarRentalSystem;
   ```

### 5. Configure the Database Connection  
Edit the `application.properties` file located in `src/main/resources/` to set your database credentials:  
```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/CarRentalSystem
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 6. Populate the `vehicle` Table  
Run the following SQL command to insert initial data into the `vehicle` table:  
```sql
USE CarRentalSystem;

CREATE TABLE IF NOT EXISTS vehicle (
    vehicle_reg VARCHAR(255) PRIMARY KEY,
    vehicle_title VARCHAR(255),
    vehicle_year INT,
    vehicle_people VARCHAR(255),
    vehicle_fuel VARCHAR(255),
    vehicle_consumption DECIMAL(5,2),
    vehicle_transmission VARCHAR(255),
    vehicle_price DECIMAL(10,2),
    vehicle_available BOOLEAN,
    image VARCHAR(500)
);

INSERT INTO vehicle (vehicle_reg, vehicle_title, vehicle_year, vehicle_people, vehicle_fuel, vehicle_consumption, vehicle_transmission, vehicle_price, vehicle_available, image)
VALUES
('BUG123', 'Bugatti Chiron', 2022, '2', 'Gasoline', '16.8', 'Automatic', 3500, true, 'https://raw.githubusercontent.com/umuttig37/carRentalimages/refs/heads/main/Bugatti-Chiron.jpg'),
('CAD456', 'Cadillac Escalade', 2021, '7', 'Gasoline', '12.4', 'Automatic', 2750, true, 'https://raw.githubusercontent.com/umuttig37/carRentalimages/refs/heads/main/Cadillac-Escalade.jpg'),
('AUD789', 'Audi R8', 2023, '2', 'Gasoline', '19.6', 'Automatic', 3000, true, 'https://raw.githubusercontent.com/umuttig37/carRentalimages/refs/heads/main/audi-r8.jpg'),
('BMW321', 'BMW M5', 2022, '5', 'Gasoline', '17.3', 'Automatic', 3250, true, 'https://raw.githubusercontent.com/umuttig37/carRentalimages/refs/heads/main/bmw-m5.jpg'),
('BMW987', 'BMW M3', 2021, '5', 'Gasoline', '15.2', 'Manual', 3150, true, 'https://raw.githubusercontent.com/umuttig37/carRentalimages/refs/heads/main/m3.jpg'),
('MER123', 'Mercedes GTS', 2022, '2', 'Gasoline', '18.0', 'Automatic', 2750, true, 'https://raw.githubusercontent.com/umuttig37/carRentalimages/refs/heads/main/mercedes-gts.jpg'),
('AUD654', 'Audi RS6', 2022, '5', 'Gasoline', '18.4', 'Automatic', 3600, true, 'https://raw.githubusercontent.com/umuttig37/carRentalimages/refs/heads/main/rs6.jpg');
```

### 7. Run the Application  
Start the application using Maven:  
```bash
mvn spring-boot:run
```

### 8. Open the Application in Your Browser  
Access the application at:  
[http://localhost:8080](http://localhost:8080)

--- 

## **Getting Started**  

### Step 1: Register an Account  
1. Navigate to the **Register** page at /register.  
2. Enter your details and Create Account.

![image](https://github.com/user-attachments/assets/c8aa07db-f1d6-4fe8-9ef7-1946d5214799)

### Step 2: Log In  
1. Use your Username and password to Login.  
2. Access the dashboard to explore rental options.

![image](https://github.com/user-attachments/assets/55e5aae0-9c0f-4891-9dcd-cf48a780ac6f)
![image](https://github.com/user-attachments/assets/fd475552-3538-41a6-91c6-2f21022a6022)

### Step 3: Book a Car  
1. Browse available cars using filters (e.g., price, year).  
2. Click **Rent Now** on a vehicle.

![image](https://github.com/user-attachments/assets/46c3adec-b1f6-41fb-b61a-150e0c9e2958)

3. Select start and end date and click Rent.
4. Click *OK* to any pop ups

![image](https://github.com/user-attachments/assets/134b5901-4a09-48d1-a9ee-e5230ddfab97)

### Step 4: View Profile & rentals
1. After Renting you will be redirected to your rentals page
2. There you can see your rented vehicles and details

![image](https://github.com/user-attachments/assets/4a58abda-b0af-4d55-ba00-2176de3eb1f5)

---

## **FAQs**  

**Q: What browsers are supported?**  
A: All browsers are supported.  

**Q: What languages are supported?**  
A: English, French, Finnish, Chinese and Japanese

**Q: Do I need an account to use the application?**
A: Yes, you must create an account to make rentings or access personalized features. You can browse available cars without logging in.

**Q: How do I create an account?**
A: Click the **Create One** button on the login page and fill out the required details, such as your name, email, and password.

---

## **Troubleshooting**  

**Problem:** Application doesn't start.  
**Solution:**  
1. Verify Java and Maven are installed.  
2. Check database connection settings in `application.properties`.  

**Problem:** Cannot connect to the database.  
**Solution:**  
1. Confirm MariaDB is running.  
2. Ensure credentials are correct.  

---
