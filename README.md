# Student_Management_System
A web page for managing students with basic CRUD operations. The user can add a new student through a form. Existing students are displayed in a table with options to edit and delete.

#Technologies Used
Backend: Spring Boot, Java, JPA, Hibernate, MySQL
Frontend: HTML, CSS, AJAX and JavaScript

The API documentation is available at the following URL:

#Deployed
Deployed Front-End : https://fanciful-yeot-67c9b6.netlify.app
Deployed Back-End : studentmanagementsystem-production-0c6a.up.railway.app

#API Endpoints

# API Endpoint Postman When deployed with Railway App
GET	- https://studentmanagementsystem-production-0c6a.up.railway.app/student
POST- https://studentmanagementsystem-production-0c6a.up.railway.app/student
PUT - https://studentmanagementsystem-production-0c6a.up.railway.app/student/{studentId} 
DELETE - https://studentmanagementsystem-production-0c6a.up.railway.app/student/{studentId}

# API Endpoint Postman When use local database
GET	- http://localhost:8080/student
POST- http://localhost:8080/student
PUT - http://localhost:8080/student/{studentId} 
DELETE - http://localhost:8080/student/{studentId}

Add a New Student:
POST http://localhost:8080/student
Body:

{
  "firstname": "John",
  "lastname": "Doe",
  "phone": "+1234567890",
  "gender": "MALE",
  "dob": "1990-01-01",
  "address": "123 Main Street"
}

Update a Student:
PUT http://localhost:8080/student/{student-id}
Body:

{
  "firstname": "Jane",
  "lastname": "Doe",
  "phone": "+9876543210",
  "gender": "FEMALE",
  "dob": "1995-02-02",
  "address": "456 Elm Street"
}
Delete a Student:
DELETE http://localhost:8080/student/{student-id}

#Special Thanks to visit on my profile and explore my project.
