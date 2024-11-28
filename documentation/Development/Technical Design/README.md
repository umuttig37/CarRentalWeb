# **Technical Design**

---

## **Table of Contents**

1. **System Designs**<br>
   1.1 [ER Diagram](#11-er-diagram)  
   1.2 [Relational Schema](#12-relational-schema)  
   1.3 [Use Case Diagram](#13-use-case-diagram)  
   1.4 [Activity Diagram](#14-activity-diagram)  
   1.5 [Sequence Diagram](#15-sequence-diagram)  
   1.6 [Class Diagram](#16-class-diagram)  
   1.7 [Deployment Diagram](#17-deployment-diagram)  
2. **Figma Designs**  
   2.1 [Overview](#21-overview)  
   2.2 [Design Style](#22-design-style)  

---

## **1. System Diagrams**

### **1.1 ER Diagram**  
The Entity-Relationship (ER) Diagram models the database structure, focusing on key entities such as `Users`, `Cars`, and `Rentals`, along with their relationships. This serves as the foundation for the system's database design.  

![ER Diagram](https://github.com/user-attachments/assets/3bad45b2-3d58-4f95-bd6e-e3207e9fd253)  

---

### **1.2 Relational Schema**  
The relational schema translates the ER diagram into a tabular structure. It includes:  
- **Primary Keys**: Unique identifiers for each table.  
- **Foreign Keys**: Keys that link related tables.  

For example:  
- `Users(User_ID, Name, Email)`  
- `Rentals(Rental_ID, User_ID, Car_ID, Rental_Date)`  

![Relational Schema](https://github.com/user-attachments/assets/1ae07ec4-87bf-4e87-87c3-12cf0042529e)  

---

### **1.3 Use Case Diagram**  
This diagram represents the interactions between actors (e.g., Users, Admins) and the system. It highlights functionalities such as **"Search for Cars"**, **"Book Rentals"**, and **"Manage Inventory"**.  

![Use Case Diagram](https://github.com/user-attachments/assets/229c4595-fffc-4cff-9223-677eb7cbe1a6)  

---

### **1.4 Activity Diagram**  
The activity diagram outlines the flow of processes in the system, such as booking a car. Key steps include user authentication, car selection, and payment processing.  

![Activity Diagram](https://github.com/user-attachments/assets/c2f10999-8c75-4b8b-8ee8-c9480da8bf17)  

---

### **1.5 Sequence Diagram**  
The sequence diagram demonstrates the interaction between components during key processes. For example, during a booking request, the sequence includes:  
1. **User sends booking request.**  
2. **System validates availability.**  
3. **Database updates rental record.**  

![Sequence Diagram](https://github.com/user-attachments/assets/13ed01e8-856c-4e3b-9dd5-fb75ebbf59a9)  

---

### **1.6 Class Diagram**  
This diagram shows the system's object-oriented structure, including the `User`, `Car`, and `Rental` classes with their attributes and methods. Relationships such as inheritance and composition are depicted.  

![Class Diagram](https://github.com/user-attachments/assets/5f93b293-4d98-4fa6-adb5-29e686fab287)  

---

### **1.7 Deployment Diagram**  
The deployment diagram illustrates the physical architecture of the system. It identifies servers, databases, and user devices, along with communication paths.  

![Deployment Diagram](https://github.com/user-attachments/assets/dc4ce6f5-61c1-4fc2-affc-9b764414c7e3)  

---

## **2. Figma Designs**

### **2.1 Overview**  
The Figma designs demonstrate the system's user interface (UI), with an emphasis on a user-friendly experience. These designs are focused on achieving:  

[View the complete Figma designs here](https://www.figma.com/design/HLULD5z6pEzlhatXqrLef8/Car-Rental-Web?node-id=0-1&t=3G8UnRdMZG5jSltz-1).  

#### **Sample Screenshots**  
![Figma Screenshot 1](https://github.com/user-attachments/assets/8ac7fec7-7ead-4e88-880d-eabc4f43db18)  
![Figma Screenshot 2](https://github.com/user-attachments/assets/44f2c7a2-738b-4256-8179-ea68106dfdd3)  
![Figma Screenshot 3](https://github.com/user-attachments/assets/0c522417-593e-4c2e-bf3e-916f3e0c850f)  

---

### **2.2 Design Style** 
![Design Style](https://github.com/user-attachments/assets/223fd51a-c40a-4507-9ca5-c0ac22588269)  

---
