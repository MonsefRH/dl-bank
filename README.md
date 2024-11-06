# Bank Management System

This project is a **Bank Management System** built using Java and JavaFX, with MySQL integration. It provides essential banking functionalities, including account management, transaction execution, and information search, all through an intuitive JavaFX interface. The system interacts with a MySQL database for secure, persistent data storage.

## Features

### 1. Account Management
- **Add New Accounts**: Create accounts for clients, specifying details like account type, initial balance, and associated bank.
- **Account Types**: Supports multiple types such as Checking, Savings, and Business accounts.
- **Data Storage**: Newly created accounts are securely stored in a MySQL database.

### 2. Transaction Execution
- **Fund Transfers**: Allows transferring funds between accounts in real time.
- **Debit and Credit Management**: Handles debits and credits, with balance adjustments for both accounts involved.
- **Transaction History**: Maintains a record of all transactions with details such as timestamp, amount, description, and account information.
- **Balance Management**: Ensures accurate account balances and prevents overdrafts.

### 3. Client and Account Search
- **Search Clients**: Find clients by ID, name, or other details to view their information.
- **Search Accounts**: Locate accounts by ID, type, or associated client.
- **Display Results**: Shows search results in a readable format within the JavaFX interface.

### 4. User Interface (JavaFX)
- **Tabbed Navigation**: The application has tabs for easy navigation between Clients, Banks, Accounts, Transactions, and Search.
- **Form-Based Input**: Includes forms for creating new clients, accounts, and banks.
- **Real-Time Updates**: Each operation updates both the interface and the database.

### 5. MySQL Database Integration
- **DAO Layer**: Uses a Data Access Object (DAO) layer to handle all database interactions.
- **Persistent Storage**: All data is stored in a MySQL database, ensuring data integrity and long-term storage.
- **Exception Handling**: Manages SQLExceptions and provides error messages to guide users.


## Technical Stack

- **Java**: Core programming language for logic implementation.
- **JavaFX**: Provides a graphical user interface (GUI).
- **MySQL**: Stores client, account, and transaction data securely.
- **DAO Pattern**: Abstracts database operations, improving code readability and reusability.
- **Gson**: Used for JSON serialization and deserialization.

## Project Structure

```plaintext
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── org.example
│   │   │   │   ├── MyApp.java  # to implement an interface for the project 
│   │   │   │   ├── Main.java   # for testing the classes           
│   │   │   │   ├── Client.java          
│   │   │   │   ├── Account.java         
│   │   │   │   ├── Bank.java            
│   │   │   │   ├── Transaction.java     
│   │   │   │   ├── DatabaseDAO.java     
│   │   │   │   ├── MySQLconnector.java     
│   ├── test
│   │   ├── java         
│   │   │   ├── ClientTest.java          
│   │   │   ├── AccountTest.java         
│   │   │   ├── BankTest.java            
│   │   │   ├── TransactionTest.java     
│   │   │   ├── DatabaseDAOTest.java        
│   ├── resources                      
└── README.md
````

##  Database Setup :

### Create Database :
Create DATABASE dl_bank ;
### Add the tables structure :
CREATE TABLE Client (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(20),
    address VARCHAR(255)
);

CREATE TABLE Bank (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bank_name VARCHAR(100),
    country VARCHAR(100)
);

CREATE TABLE Account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_creation DATE,
    date_update DATE,
    account_type VARCHAR(20),
    balance DECIMAL(10, 2),
    client_id INT,
    bank_id INT,
    FOREIGN KEY (client_id) REFERENCES Client(id),
    FOREIGN KEY (bank_id) REFERENCES Bank(id)
);

CREATE TABLE Transaction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(10, 2),
    date_transaction DATE,
    description VARCHAR(255),
    debit_id INT,
    credit_id INT,
    FOREIGN KEY (debit_id) REFERENCES Account(id),
    FOREIGN KEY (credit_id) REFERENCES Account(id)
);

