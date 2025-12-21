# Student Management System

A full-stack application for managing student records with a React frontend and Spring Boot REST API backend.

## Tech Stack

### Backend
- **Java 21**
- **Spring Boot 4.0.3**
- **Spring Data JPA** – persistence layer
- **PostgreSQL** – database
- **Lombok** – reduces boilerplate code
- **Maven** – build tool

### Frontend
- **React 19**
- **React Router** – client-side routing
- **Tailwind CSS** – styling
- **Axios** – HTTP client for API calls

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- Node.js 18+ and npm
- PostgreSQL (running locally or remotely)

## Setup

### 1. Database

Create a PostgreSQL database:

```sql
CREATE DATABASE student_db;
```

### 2. Backend Configuration

Update `backend/src/main/resources/application.properties` with your database credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### 3. Run the Backend

From the project root:

```bash
cd backend
./mvnw spring-boot:run
```

Or on Windows:

```bash
cd backend
mvnw.cmd spring-boot:run
```

The API runs at `http://localhost:8080`.

### 4. Run the Frontend

In a new terminal, from the project root:

```bash
cd frontend
npm install
npm start
```

The React app runs at `http://localhost:3000` and connects to the backend API.

> **Note:** Ensure the backend is running before using the frontend, as it fetches data from `http://localhost:8080/api/students`.

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/students` | Create a new student |
| `GET` | `/api/students` | Get all students |
| `GET` | `/api/students/{id}` | Get student by ID |
| `PUT` | `/api/students/{id}` | Update a student |
| `DELETE` | `/api/students/{id}` | Delete a student |

### Student Model

| Field | Type |
|-------|------|
| `id` | Long (auto-generated) |
| `firstName` | String |
| `lastName` | String |
| `email` | String |
| `password` | String |
| `age` | int |
| `course` | String |

### Example Requests

**Create a student:**

```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@example.com",
    "password": "secret123",
    "age": 22,
    "course": "Computer Science"
  }'
```

**Get all students:**

```bash
curl http://localhost:8080/api/students
```

You can also use the `test-api.http` file in the `backend` folder with HTTP client extensions (e.g. REST Client in VS Code).

## Project Structure

```
Student Management System/
├── backend/
│   ├── src/main/java/org/yared/backend/
│   │   ├── BackendApplication.java
│   │   ├── controller/StudentController.java
│   │   ├── dto/StudentDTO.java
│   │   ├── model/Student.java
│   │   ├── repository/StudentRepository.java
│   │   └── service/
│   │       ├── StudentService.java
│   │       └── StudentServiceImpl.java
│   ├── src/main/resources/
│   │   └── application.properties
│   ├── pom.xml
│   └── test-api.http
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── components/
│   │   │   ├── AddStudent.js
│   │   │   ├── EditStudent.js
│   │   │   └── StudentList.js
│   │   ├── pages/
│   │   │   └── Home.js
│   │   ├── services/
│   │   │   └── StudentService.js
│   │   ├── App.js
│   │   └── index.js
│   ├── package.json
│   └── tailwind.config.js
└── README.md
```

## License

This project is open source and available under the MIT License.
