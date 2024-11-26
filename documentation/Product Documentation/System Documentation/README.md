# System Documentation for Car Rental Program

---

## Overview
This document provides detailed technical information about the architecture, components, and behavior of the browser-based car rental system. It serves as a reference for developers, architects, QA testers, and support engineers, detailing design decisions, database schema, APIs, and server configurations.

---

## Purpose
The system enables users to browse available vehicles, book rentals, manage bookings, and process payments through a web-based interface. The backend ensures secure and efficient management of rental transactions, vehicle inventory, and user data.

---

## System Architecture

### Architecture Overview
The system follows a **three-tier architecture**:
- **Presentation Layer:** Web-based front end, accessible via browsers.
- **Business Logic Layer:** Handles application logic and communicates between the front and data layers.
- **Data Layer:** Manages data storage and retrieval.

### System Architecture Diagram
![Untitled-5-01](https://github.com/user-attachments/assets/81190190-dbd7-4ddb-9179-e7c496c467ec)


---
## Audiences
Developers, system architects, QA testers, and support engineers.

## Database Schema
### Relational Database: MariaDB
**Database Name:** `CarRentalSystem`

**Tables:**
- **Vehicle:** Stores vehicle details ***(vehicle_reg, image, vehicle_available, vehicle_consumption, vehicle_fuel, vehicle_people, vehicle_price, vehicle_title, vehicle_transmission, vehicle_year)***
- **User:** Stores user information ***(user_id, language, user_name, user_email, user_password)***
- **user_fi** Stores user information in Finnish ***(user_first_name_fi, user_lastname_fi, user_id)***
- **user_en** Stores user information in English ***(user_first_name_ed, user_lastname_ed, user_id)***
- **user_fr** Stores user information in French ***(user_first_name_fr, user_lastname_fr, user_id)***
- **user_jp** Stores user information in Japanese ***(user_first_name_jp, user_lastname_jp, user_id)***
- **user_cn** Stores user information in Chinese ***(user_first_name_cn, user_lastname_cn, user_id)***
- **Rental_Transaction:** Stores rentals details ***(rental_id, rental_date, rental_end_date, vehicle_id)***

**Database Schema:**

![image](https://github.com/user-attachments/assets/72db7dac-096f-4352-960a-a3b5ab45cad5)


## Change Logs
### Version 1.0.0
- Initial release of the car rental system.
- Implemented user authentication and registration.
- Added vehicle listing and booking functionality.
- Profile management and vehicle filtering features.
- multi-language support for user information.

## Future Enhancements
- Implement vehicle tracking and location services.
- Integrate with third-party payment gateways.
- Enhance user experience with interactive maps and vehicle previews.
- optimize database queries and improve system performance.
- Implement real-time notifications and alerts.





