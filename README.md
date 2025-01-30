### **Project Title**
E-Learning Platform

### **Project Description**
This is a web-based e-learning platform that allows trainers to create courses and students to enroll and access course content. The platform includes YouTube video integration for courses and user role management. The backend is built with **Spring Boot**, the frontend uses **Thymeleaf**, and the database is **MySQL**.

### **Technologies Used**
- **Backend**: Java 23, Spring Boot 3.4.1
- **Frontend**: Thymeleaf, CSS
- **Database**: MySQL
- **Tools**: Eclipse (IDE),  Maven (Dependency Management)

### **Installation**

1. Clone the repository to your local machine:
    ```bash
    git clone https://github.com/antonyrichard29/elearning-platform.git
    ```

2. Navigate to the project directory:
    ```bash
    cd elearning-platform
    ```

3. Set up the MySQL database:
    - Create a new database in MySQL (e.g., `el_db`).
    - Configure the database settings in the `application.properties` file.

4. Install the necessary dependencies:
    ```bash
    mvn install
    ```

5. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

6. Open your browser and go to `http://localhost:8080`.

### **Features**
- **User Registration**: Users can create accounts and log in.
- **Role-Based Access**: Differentiates between trainers and students with separate dashboards.
- **Course Management**: Trainers can create and manage courses.
- **YouTube Integration**: Courses can embed YouTube videos for enhanced learning.

### **Contributing**
If you would like to contribute to this project, please fork the repository, create a new branch, make your changes, and submit a pull request.

