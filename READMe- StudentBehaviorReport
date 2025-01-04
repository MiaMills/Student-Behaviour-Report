# Student Behaviour Report API

This project is a Spring Boot application for managing student behaviour reports. It provides CRUD operations for students and their teacher comments.

## Table of Contents

- [Overview](#overview)
- [Setup](#setup)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Deliverables](#deliverables)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Student Behaviour Report API is a RESTful web service built with Spring Boot that manages student behaviour reports. This application allows users to perform CRUD (Create, Read, Update, Delete) operations on student records and their associated teacher comments. The API leverages Spring Data JPA for database interactions and stores data in a MySQL database.

Key features of the Student Behaviour Report API include:

- **CRUD Operations:** Create, read, update, and delete student records.
- **Teacher Comments:** Add and retrieve teacher comments for students.
- **Filtering:** Filter students based on specific criteria such as teacher comments.
- **Exception Handling:** Robust error handling to manage various exceptions.
- **Data Persistence:** Persistent storage of student data using MySQL.
- **API Documentation:** Comprehensive documentation of API endpoints and usage.

The project is designed to demonstrate best practices in API development using Java and Spring Boot, including proper use of HTTP methods, request and response handling, and integration with a relational database.

## Setup

### Prerequisites

- JDK 21 or higher
- Git
- Visual Studio Code
- Extension Pack for Java
- Spring Boot Extension Pack
- MySQL

### Installation

1. **Clone the Repository:**
   - Open your terminal or command prompt.
   - Navigate to the directory where you want to clone the repository.
   - Run the following command to clone the repository:
     ```sh
     git clone https://github.com/your-username/student-behaviour-report.git
     cd student-behaviour-report
     ```

2. **Configure the Database:**
   - Ensure you have MySQL installed and running.
   - Create a MySQL database named `studentbehaviorreportdatabase`.
   - Update the `application.properties` file with your database credentials. The `application.properties` file is typically located in the `resources` directory. Here is an example configuration:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/studentbehaviorreportdatabase
     spring.datasource.username=your_mysql_username
     spring.datasource.password=your_mysql_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

   Note: 
   - Please replace `your_mysql_username` with your actual username.
   - Please replace `your_mysql_password` with your actual password.

3. **Build the Project:**

   **Install Maven (if not already installed):**
   - Maven is a build automation tool used primarily for Java projects. If you don't have Maven installed, you can download and install it from the [Maven website](https://maven.apache.org/download.cgi).

   **On Windows:**
   - Download the Maven binary zip archive from the Maven website.
   - Extract the archive to a directory of your choice (e.g., `C:\Program Files\Apache\Maven`).
   - Add the `bin` directory of the extracted directory to the `PATH` environment variable.
   - Verify the installation by opening a command prompt and running:
     ```sh
     mvn -version
     ```

   **On macOS:**
   - You can install Maven using Homebrew:
     ```sh
     brew install maven
     ```
   - Verify the installation by opening a terminal and running:
     ```sh
     mvn -version
     ```

   **On Linux:**
   - You can install Maven using your package manager. For example, on Ubuntu:
     ```sh
     sudo apt update
     sudo apt install maven
     ```
   - Verify the installation by opening a terminal and running:
     ```sh
     mvn -version
     ```

   **Navigate to the Project Directory:**
   - Open your terminal or command prompt.
   - Navigate to the root directory of your project where the 

pom.xml

 file is located.
     ```sh
     cd /path/to/your/project
     ```

   **Build the Project:**
   - Run the following command to build the project using Maven. This command will compile the source code, run tests, and package the compiled code into a JAR file.
     ```sh
     mvn clean install
     ```

   - The `clean` goal will remove any previously compiled Java sources and resources.
   - The `install` goal will compile the code, run tests, and install the resulting JAR file into the local Maven repository.

4. **Run the Application:**
   - After the build is successful, you can run the Spring Boot application using the following command:
     ```sh
     mvn spring-boot:run
     ```

   - This command will start the embedded Tomcat server and deploy your application.

5. **Access the API:**
   - Once the application is running, you can access the API at `http://localhost:8080`.

### Export Database

To ensure that your project can be assessed correctly, you must include a database dump file that can be used to restore a usable database and document the file's location in your 

README.md

 file.

#### Command Line

Execute the following command to export the database:
```sh
mysqldump -u root -p --databases studentbehaviorreportdatabase > studentbehaviorreportdatabase_dump.sql
```

#### Location of Database Dump File

The database dump file is located in the root directory of the project and is named 

studentbehaviorreportdatabase_dump.sql

.

#### Restoring the Database

To restore the database from the dump file, execute the following command:
```sh
mysql -u root -p < studentbehaviorreportdatabase_dump.sql
```

## Usage

### API Endpoints

#### Create a New Student

- **URL:** `/api/v1/students`
- **Method:** `POST`
- **Body:**
  ```json
  {
    "studentId": "S001",
    "studentName": "John Doe",
    "studentClass": "Class A",
    "teacherComment": "Excellent student"
  }
  ```

#### Get All Students

- **URL:** `/api/v1/students`
- **Method:** `GET`

#### Get a Student's Teacher Comment by ID

- **URL:** `/api/v1/students/{id}/getTeacherComment`
- **Method:** `GET`

#### Get Students by Teacher Comment

- **URL:** `/api/v1/students/filter`
- **Method:** `GET`
- **Query Parameter:** `comment=someComment`

#### Get Students by Name

- **URL:** `/api/v1/students/findByName`
- **Method:** `GET`
- **Query Parameter:** `name=John Doe`

#### Update a Student

- **URL:** `/api/v1/students/{id}`
- **Method:** `PUT`
- **Body:**
  ```json
  {
    "studentName": "John Doe",
    "studentClass": "Class A",
    "teacherComment": "Updated comment"
  }
  ```

#### Delete a Student by ID

- **URL:** `/api/v1/students/deleteById/{id}`
- **Method:** `DELETE`

#### Delete a Student by Name

- **URL:** `/api/v1/students/deleteByName`
- **Method:** `DELETE`
- **Query Parameter:** `name=Emily Davis`

#### Add a Teacher Comment

- **URL:** `/api/v1/students/{id}/addTeacherComment`
- **Method:** `POST`
- **Body:**
  ```json
  {
    "comment": "Excellent progress in the last semester."
  }
  ```

## Testing

You can use Postman or any other API testing tool to test the endpoints. Here are the APIs that have been tested:

1. `http://localhost:8080/api/v1/students`
2. `http://localhost:8080/api/v1/students/S001/getTeacherComment`
3. `http://localhost:8080/api/v1/students/S007/getTeacherComment`
4. `http://localhost:8080/api/v1/students/filter?comment=someComment`
5. `http://localhost:8080/api/v1/students/findByName?name=John Doe`
6. `http://localhost:8080/api/v1/students/S002`
7. `http://localhost:8080/api/v1/students/deleteById/4`
8. `http://localhost:8080/api/v1/students/deleteById/S009`
9. `http://localhost:8080/api/v1/students`
10. `http://localhost:8080/api/v1/students/S003/addTeacherComment`
11. `http://localhost:8080/api/v1/students/deleteByName?name=Emily Davis`
12. `http://localhost:8080/api/v1/students/deleteByName?name=Emily Denis`

## Deliverables

Ensure that your work is merged to the main branch of your GitHub repository.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the LICENSE file for details.
