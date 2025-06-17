# 📚 Online Bookstore

A Java-based console application simulating a real-world e-commerce bookstore, backed by MySQL. Built with **Java 11**, **Maven**, and **JDBC**, it's designed to showcase clean code, object-oriented principles, and backend development best practices.

---

## 🌟 Project Overview

This app allows users to:

* Browse books from a MySQL database 📖
* Add books to a shopping cart 🛒
* View cart contents and total price 💸
* Exit the program cleanly 🚪

Whether you're applying for backend or full-stack roles, this project is a great portfolio piece. 💼

---

## ✨ Features

* **📚 Browse Books** – View all available books with ID, title, and price.
* **🛒 Add to Cart** – Add books to cart by entering their ID.
* **💸 View Cart** – Displays cart contents and total price.
* **🚪 Exit Gracefully** – Clean exit with confirmation message.
* **🛡️ Error Handling** – Input and DB errors are handled robustly.
* **✅ Sample Data** – Comes preloaded with sample books.

---

## 🛠️ Tech Stack

| Technology  | Purpose                       |
| ----------- | ----------------------------- |
| **Java 11** | Application logic (OOP)       |
| **MySQL**   | Book storage (relational DB)  |
| **Maven**   | Dependency & build management |
| **Git**     | Version control               |
| **JDBC**    | Java-DB connectivity          |

---

## 🚀 Getting Started

### ✅ Prerequisites

Ensure the following are installed:

* Git – [https://git-scm.com](https://git-scm.com)
* Java JDK 11+ – [https://oracle.com/java](https://oracle.com/java)
* Maven – [https://maven.apache.org](https://maven.apache.org)
* MySQL – [https://mysql.com](https://mysql.com)
* IDE – VS Code, IntelliJ, etc.

Add them to your system's PATH if commands aren’t recognized.

---

### 🧰 Setup Instructions

#### 1. Clone the Repository

```bash
git clone https://github.com/your-username/online-bookstore.git
cd online-bookstore
```

---

#### 2. Set Up MySQL Database

```bash
# Start MySQL (Linux/macOS)
sudo service mysql start

# Log in
mysql -u root -p

# Create database
CREATE DATABASE bookstore_db;
SHOW DATABASES;
EXIT;
```

---

#### 3. Configure Application

Open `src/main/java/com/bookstore/Bookstore.java`
Update the DB password:

```java
private static final String PASS = "your_password"; // ← Replace this
```

---

#### 4. Build the Project

```bash
mvn clean install
```

Look for `BUILD SUCCESS`.

---

#### 5. Run the App

```bash
java -cp target/online-bookstore-1.0-SNAPSHOT.jar com.bookstore.Bookstore
```

---

## 📂 Project Structure

```
online-bookstore/
├── pom.xml                    # Maven configuration
├── README.md                  # Project documentation
├── src/
│   └── main/
│       └── java/
│           └── com/bookstore/
│               └── Bookstore.java  # Main app logic
├── target/                    # Compiled output (.jar)
```

---

## 🎮 How to Use

You’ll see a simple menu:

```
=== Online Bookstore ===
1. View Books
2. Add to Cart
3. View Cart
4. Exit
```

### Example Flow:

```
Choose an option: 1
Available Books:
1. Java Programming ($29.99)
2. Python Basics ($19.99)
3. SQL Essentials ($24.99)

Choose an option: 2
Enter book ID: 1
Java Programming added to cart.

Choose an option: 3
Cart Contents:
1. Java Programming ($29.99)
Total: $29.99
```

---

## 💼 Why It Matters

This project demonstrates:

* **🛠️ Technical Mastery** – Java, JDBC, MySQL, Maven
* **✅ Industry Standards** – Clean code, modular design, error handling
* **🛍️ E-commerce Functionality** – Inventory and cart logic
* **📈 Scalable Design** – Easy to extend with GUI or REST API
* **📝 Professionalism** – Clear documentation & version control

Perfect for roles in **backend development**, **full-stack engineering**, or **database design**.

---

## 🔮 Roadmap

Planned enhancements:

* 💾 Persistent cart using MySQL
* 🧾 Checkout system
* 🖼️ GUI with JavaFX or Swing
* 🔒 PreparedStatement for SQL injection protection
* 👤 User login and account features
* 🌐 REST API for web integration

---

## 🤝 Contributing

Contributions are welcome!

```bash
# Fork, then clone your fork
git checkout -b feature/your-feature

# Make changes
git add .
git commit -m "Add your feature"

# Push and submit a pull request
git push origin feature/your-feature
```

✅ Be sure to follow existing code style and test your changes.

---

## 📜 License

This project is licensed under the **MIT License**.
See `LICENSE` file for details (create it if not already added).

---

