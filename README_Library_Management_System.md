
# 📚 Library Management System

A **console-based Java application** for managing core library operations. Built using **Java**, integrated with **MySQL** via **JDBC**, and structured for use in **Eclipse IDE**. This project demonstrates modular architecture with DAO, DTO, and service layers.

---

## 🌟 Features

- 🔐 **User Login**
  - Supports secure login for `admin` and `student`.

- 🛠️ **Admin Functionalities**
  - Search books by serial number or author.
  - Add new books or update quantities.
  - View all books.
  - Register new students.
  - View registered students.

- 🎓 **Student Functionalities**
  - Search for books.
  - Check out and return books.

- 📦 **Book Management**
  - Add, update, and list books.

- 👥 **Student Management**
  - Register and list students.

- 🔄 **Book Borrowing & Returning**
  - Track borrow/return transactions and quantities.

- 🖥️ **Console-Based Interface**
  - Simple CLI interface for interacting with users.

- 🗂️ **Modular Structure**
  - Organized into packages: `dao`, `dto`, `login`, `service`.

- 🛢️ **Database Connectivity**
  - Uses MySQL for persistent data storage.

---

## 🧰 Technologies Used

- **Java (JDK 8 or newer)**
- **MySQL Database**
- **JDBC (Java Database Connectivity)**
- **MySQL Connector/J (v9.4.0)**
- **Eclipse IDE**

---

## 📁 Project Structure

```
LibraryManagementSystem/
├── .classpath
├── .project
├── src/
│   └── com/jts/lms/
│       ├── LibraryManagementSystem.java
│       ├── dao/
│       │   ├── BookDao.java
│       │   ├── DatabaseService.java
│       │   ├── LoginDao.java
│       │   └── StudentDao.java
│       ├── dto/
│       │   ├── Book.java
│       │   └── BookingDetails.java
│       ├── login/
│       │   └── LoginService.java
│       └── service/
│           ├── BookService.java
│           └── StudentService.java
├── lib/
│   └── mysql-connector-j-9.4.0.jar
├── bin/
```

---

## 🚀 Getting Started

### 🔧 Prerequisites

- JDK 8 or newer
- MySQL Server
- MySQL Connector/J (`mysql-connector-j-9.4.0.jar`)
- Eclipse IDE (optional but recommended)

---

### 🛠️ Installation & Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/LibraryManagementSystem.git
   cd LibraryManagementSystem
   ```

2. **Add MySQL Connector:**
   - Place `mysql-connector-j-9.4.0.jar` in the `lib/` folder.
   - You can download it from: https://dev.mysql.com/downloads/connector/j/

3. **Configure MySQL Database:**

   ```sql
   CREATE DATABASE library_management_system;
   USE library_management_system;

   CREATE TABLE login (
       id INT AUTO_INCREMENT PRIMARY KEY,
       user_name VARCHAR(50) NOT NULL UNIQUE,
       password VARCHAR(50) NOT NULL,
       user_type VARCHAR(10) NOT NULL
   );

   CREATE TABLE books (
       id INT AUTO_INCREMENT PRIMARY KEY,
       sr_no INT NOT NULL UNIQUE,
       name VARCHAR(255) NOT NULL,
       author_name VARCHAR(255) NOT NULL,
       qty INT NOT NULL
   );

   CREATE TABLE students (
       id INT AUTO_INCREMENT PRIMARY KEY,
       std_name VARCHAR(255) NOT NULL,
       reg_num VARCHAR(50) NOT NULL UNIQUE
   );

   CREATE TABLE booking_details (
       id INT AUTO_INCREMENT PRIMARY KEY,
       std_id INT NOT NULL,
       book_id INT NOT NULL,
       qty INT NOT NULL,
       FOREIGN KEY (std_id) REFERENCES students(id),
       FOREIGN KEY (book_id) REFERENCES books(id)
   );
   ```

4. **Insert Sample Data (Optional):**

   ```sql
   INSERT INTO login (user_name, password, user_type) VALUES ('admin', 'admin123', 'admin');
   INSERT INTO login (user_name, password, user_type) VALUES ('student', 'student123', 'student');

   INSERT INTO books (sr_no, name, author_name, qty) VALUES
   (101, 'The Great Gatsby', 'F. Scott Fitzgerald', 5),
   (102, '1984', 'George Orwell', 3);
   ```

5. **Update DB Credentials:**
   Modify `DatabaseService.java` if your MySQL username/password is different:

   ```java
   conn = DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/library_management_system",
       "your_username",
       "your_password"
   );
   ```

---

## ▶️ Running the Application

### 🧩 Option 1: Using Eclipse IDE

1. **Import Project:**
   - Go to `File` → `Import...` → `Existing Projects into Workspace`
   - Select the project root and click `Finish`.

2. **Run Application:**
   - Open `LibraryManagementSystem.java`
   - Right-click → `Run As` → `Java Application`

---

### 💻 Option 2: Command Line (Manual Compilation)

```bash
# Windows
javac -d bin -cp "lib/mysql-connector-j-9.4.0.jar;src" src/com/jts/lms/**/*.java
java -cp "bin;lib/mysql-connector-j-9.4.0.jar" com.jts.lms.LibraryManagementSystem

# Linux/macOS
javac -d bin -cp "lib/mysql-connector-j-9.4.0.jar:src" src/com/jts/lms/**/*.java
java -cp "bin:lib/mysql-connector-j-9.4.0.jar" com.jts.lms.LibraryManagementSystem
```

---

## 📝 Development Notes

- `LibraryManagementSystem.java` contains the `main()` method.
- `DatabaseService.java` manages DB connection.
- DAO classes handle DB queries.
- DTO classes model the data.
- Service classes contain the business logic.

---

## 💡 Future Enhancements

- 🔐 Secure password hashing
- 🛡️ Input validation & error handling
- 📊 Reports: borrowing history, popular books, overdue tracking
- 💻 GUI using JavaFX/Swing or convert to Web App
- ⚙️ Config files instead of hardcoded DB credentials
- 🧪 Unit & integration testing
- 📋 Logging with Log4j or SLF4J

---

## 🤝 Contributing

Feel free to fork the repository, submit issues, or create pull requests to help improve the project!

