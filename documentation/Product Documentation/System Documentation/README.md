# System Documentation for Car Rental Program

---

## 1. Overview
This document provides detailed technical information about the architecture, components, and behavior of the browser-based car rental system. It serves as a reference for developers, architects, QA testers, and support engineers, detailing design decisions, database schema, APIs, and server configurations.

---

## 2. Purpose
The system enables users to browse available vehicles, book rentals, manage bookings, and process payments through a web-based interface. The backend ensures secure and efficient management of rental transactions, vehicle inventory, and user data.

---

## 3. System Architecture

### 3.1 Architecture Overview
The system follows a **three-tier architecture**:
- **Presentation Layer:** Web-based front end, accessible via browsers.
- **Business Logic Layer:** Handles application logic and communicates between the front and data layers.
- **Data Layer:** Manages data storage and retrieval.

### 3.2 System Architecture Diagram
[tähän kuva arkkitehtuurista]

---

## 4. API Documentation

### 4.1 API Gateway
The API Gateway facilitates communication between the front end and microservices. It provides endpoints for:
- **User Management:** Authentication, registration, profile updates.
- **Vehicle Management:** Listing available vehicles, filtering by location, date, or type.
- **Booking Management:** Creating, updating, canceling bookings.
- **Payment Processing:** Handling secure payments via third-party APIs.

#### Example Endpoint
**Endpoint:** `/api/rentals`  
**Method:** `POST`  
**Description:** Creates a new booking.

**Request Body:**
```json
{
  "userId": "12345",
  "vehicleId": "67890",
  "startDate": "2024-11-01",
  "endDate": "2024-11-05",
  "paymentToken": "abc123"
}
```

example Response
```json
{
  "bookingId": "98765",
  "status": "confirmed",
  "totalPrice": 250.00
}
```
## 5. Database Schema
### 5.1 Relational Database: MariaDB
**Database Name:** `CarRentalSystem`

**Tables:**
- **Vehicle:** Stores vehicle details (id, make, model, year, location, availability).
- **User:** Stores user information (id, name, email, password).
- **User_fi** Stores user information in Finnish (id, name, email, password).
- **user_en** Stores user information in English (id, name, email, password).
- **user_fr** Stores user information in French (id, name, email, password).
- **user_jp** Stores user information in Japanese (id, name, email, password).
- **user_cn** Stores user information in Chinese (id, name, email, password).
- **Rental_Transaction:** Stores booking details (id, userId, vehicleId, startDate, endDate, status, totalPrice).

**Database Schema:**
[tähän joku kuva tai sql setti]

## 6. Change Logs
### 6.1 Version 1.0.0
- Initial release of the car rental system.
- Implemented user authentication and registration.
- Added vehicle listing and booking functionality.
- Profile management and vehicle filtering features.
- multi-language support for user information.

## 7. Future Enhancements
- Implement vehicle tracking and location services.
- Integrate with third-party payment gateways.
- Enhance user experience with interactive maps and vehicle previews.
- optimize database queries and improve system performance.
- Implement real-time notifications and alerts.





