# Doctor-Patient Booking API Service

## Overview

A comprehensive REST API service for managing doctor appointments and patient bookings, built for Rx.Now's AI-powered preventive healthcare platform. This implementation uses **in-memory storage** with arrays and dictionaries as requested for the technical assessment.

## 🚀 Features

### Core Functionality
- **Doctor Management**: Complete CRUD operations for doctor profiles
- **Patient Management**: Patient registration and profile management
- **Appointment Booking**: Smart appointment scheduling with conflict detection
- **Role-based Access**: Separate views for doctors and patients
- **Real-time Availability**: Dynamic doctor availability checking

### Technical Features
- **Clean Architecture**: Separation of concerns with controllers, services, and repositories
- **Input Validation**: Comprehensive request validation with detailed error messages
- **Exception Handling**: Global exception handling with meaningful error responses
- **In-Memory Storage**: Uses ConcurrentHashMap and ArrayList for thread-safe data storage
- **API Documentation**: Interactive Swagger UI documentation
- **Sample Data**: Pre-loaded sample data for immediate testing

## 🛠️ Technology Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **In-Memory Storage** (ConcurrentHashMap, ArrayList)
- **Maven**
- **Swagger/OpenAPI 3**
- **Docker**

## 📋 API Endpoints

### Doctor Management
- `GET /api/doctors` - List all doctors (with filtering)
- `GET /api/doctors/{id}` - Get doctor details
- `GET /api/doctors/specialization/{specialization}` - Filter by specialization
- `POST /api/doctors` - Create new doctor
- `PUT /api/doctors/{id}` - Update doctor
- `DELETE /api/doctors/{id}` - Delete doctor

### Appointment Management
- `POST /api/appointments` - Book an appointment
- `GET /api/appointments?doctor_id={id}` - View doctor's appointments
- `GET /api/appointments?patient_id={id}` - View patient's appointments
- `PUT /api/appointments/{id}/status` - Update appointment status
- `DELETE /api/appointments/{id}` - Cancel appointment

### Patient Management
- `GET /api/patients` - List all patients
- `GET /api/patients/{id}` - Get patient details
- `POST /api/patients` - Create new patient
- `PUT /api/patients/{id}` - Update patient
- `DELETE /api/patients/{id}` - Delete patient

## 🏃‍♂️ Running the Application

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- Docker (optional)

### Local Development

1. **Clone the repository**
```bash
git clone <repository-url>
cd doctor-patient-booking
```

2. **Run with Maven**
```bash
./mvnw spring-boot:run
```

3. **Run with Docker**
```bash
docker-compose up --build
```

### Accessing the Application

- **API Base URL**: `http://localhost:8080`
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`

## 📝 Sample API Usage

### 1. Get All Doctors
```bash
curl -X GET "http://localhost:8080/api/doctors"
```

### 2. Get Doctor by ID
```bash
curl -X GET "http://localhost:8080/api/doctors/1"
```

### 3. Book an Appointment
```bash
curl -X POST "http://localhost:8080/api/appointments" \
  -H "Content-Type: application/json" \
  -d '{
    "doctorId": 1,
    "patientId": 1,
    "appointmentDateTime": "2024-01-20T10:00:00",
    "reason": "Regular checkup"
  }'
```

### 4. Get Doctor's Appointments
```bash
curl -X GET "http://localhost:8080/api/appointments?doctor_id=1"
```

### 5. Get Patient's Appointments
```bash
curl -X GET "http://localhost:8080/api/appointments?patient_id=1"
```

## 🧪 Testing

### Sample Test Data

The application comes pre-loaded with sample data using in-memory initialization:

**Doctors:**
- Dr. Sarah Johnson (Cardiology)
- Dr. Michael Chen (Pediatrics)
- Dr. Emily Rodriguez (Dermatology)
- Dr. James Wilson (Orthopedics)
- Dr. Lisa Kumar (Internal Medicine)

**Patients:**
- John Smith, Emma Johnson, Robert Brown, Jennifer Davis, David Miller

**Sample Appointments:**
- Pre-scheduled appointments between various doctors and patients

### Data Storage Implementation

The application uses in-memory storage with:
- **ConcurrentHashMap**: Thread-safe key-value storage for entities
- **AtomicLong**: Thread-safe ID generation
- **ArrayList**: Dynamic arrays for collections
- **Stream API**: For filtering and data manipulation

### Testing with Postman

Import the API endpoints into Postman using the OpenAPI specification available at:
`http://localhost:8080/api-docs`

## 🔧 Configuration

### Application Properties

Key configuration options in `application.properties`:

```properties
# Server Configuration
server.port=8080
# Logging Configuration
logging.level.com.rxnow.booking=DEBUG
```

## 📊 Architecture

### Project Structure
```
src/main/java/com/rxnow/booking/
├── controller/          # REST Controllers
├── service/            # Business Logic
├── repository/         # In-Memory Data Access Layer
├── model/             # Entity Classes
├── dto/               # Data Transfer Objects
├── exception/         # Custom Exceptions
└── config/            # Configuration & Data Initialization
```

### Key Design Patterns
- **Repository Pattern**: In-memory data access abstraction
- **Service Layer Pattern**: Business logic encapsulation
- **DTO Pattern**: Data transfer and API response formatting
- **Global Exception Handling**: Centralized error management
- **Command Line Runner**: Data initialization on startup

## 🚦 Error Handling

The API provides comprehensive error handling with detailed error messages:

- **400 Bad Request**: Validation errors
- **404 Not Found**: Resource not found
- **409 Conflict**: Appointment scheduling conflicts
- **500 Internal Server Error**: Unexpected errors

## 📈 Performance Features

- **Thread-Safe Collections**: ConcurrentHashMap for concurrent access
- **Stream Processing**: Efficient filtering and data manipulation
- **Atomic Operations**: Thread-safe ID generation
- **In-Memory Speed**: Fast data access without database overhead

## 🔒 Security Considerations

While authentication is not implemented as per requirements, the API includes:
- Input validation and sanitization
- Thread-safe data operations
- Error message sanitization to prevent information leakage
- Concurrent access protection

## 🐳 Docker Support

The application includes Docker support for easy deployment:

```bash
# Build and run with Docker Compose
docker-compose up --build

# Build Docker image manually
docker build -t rxnow-booking-api .

# Run Docker container
docker run -p 8080:8080 rxnow-booking-api
```

## 📚 API Documentation

Complete API documentation is available through Swagger UI at:
`http://localhost:8080/swagger-ui.html`

The documentation includes:
- Interactive API testing
- Request/response schemas
- Example payloads
- Authentication requirements (when implemented)

## 🎯 Future Enhancements

- Database persistence (PostgreSQL/MySQL)
- JWT-based authentication and authorization
- Email notifications for appointment confirmations
- SMS reminders for upcoming appointments
- Payment integration
- Real-time notifications using WebSocket
- Advanced scheduling algorithms
- Multi-language support
- Audit logging
- Performance monitoring
- Data persistence and backup mechanisms

  ## Screenshots
  ![Uploading image.png…]()
![Uploading image.png…]()
![Uploading image.png…]()
etc........



---
