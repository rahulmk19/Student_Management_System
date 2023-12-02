# Student Management System

A web application for managing students with basic CRUD operations. Users can add new students through a form, and existing students are displayed in a table with options to edit and delete.

## Technologies Used

**Backend:**
- Spring Boot
- Java
- JPA
- Hibernate
- MySQL

**Frontend:**
- HTML
- CSS
- AJAX
- JavaScript

## Deployed

**Front-End:**
[Student Management System Frontend](https://fanciful-yeot-67c9b6.netlify.app)

**Back-End:**
[Student Management System Backend](https://studentmanagementsystem-production-0c6a.up.railway.app)

## API Endpoints

### When deployed with Railway App

- **GET:** https://studentmanagementsystem-production-0c6a.up.railway.app/student
- **POST:** https://studentmanagementsystem-production-0c6a.up.railway.app/student
- **PUT:** https://studentmanagementsystem-production-0c6a.up.railway.app/student/{studentId}
- **DELETE:** https://studentmanagementsystem-production-0c6a.up.railway.app/student/{studentId}

### When using a local database

- **GET:** http://localhost:8080/student
- **POST:** http://localhost:8080/student
- **PUT:** http://localhost:8080/student/{studentId}
- **DELETE:** http://localhost:8080/student/{studentId}

## Add a New Student

**POST:** http://localhost:8080/student

**Body:**
```json
{
  "firstname": "Rahul",
  "lastname": "Thakur",
  "phone": "+911234567890",
  "gender": "FEMALE",
  "dob": "1999-03-19",
  "address": "Bettiah, Bihar"
}

## Update a Student

**PUT:** http://localhost:8080/student/{student-Id}

**Body:**
```json
{
  "firstname": "Rahul",
  "lastname": "Thakur",
  "phone": "+917667869850",
  "gender": "MALE",
  "dob": "1999-03-19",
  "address": "Bettiah, Bihar"
}

## Delete a Student

**DELETE:** http://localhost:8080/student/{student-Id}

## Get All Students

**GET:** http://localhost:8080/student/{student-Id}

#Message
Thank you so much for taking the time to visit my profile and delve into the project. Your interest is truly appreciated! If you have any questions or feedback, feel free to reach out. Happy exploring!
