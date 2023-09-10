-- Create the database
CREATE DATABASE IF NOT EXISTS bookstoreDB;

-- Use the database
USE bookstoreDB;

-- Create the USERS table
CREATE TABLE IF NOT EXISTS USERS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL
);

-- Create the ROLES table
CREATE TABLE IF NOT EXISTS ROLES (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);

-- Create the BOOKS table with an 'available' column
CREATE TABLE IF NOT EXISTS BOOKS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    TITLE VARCHAR(255) NOT NULL,
    AUTHOR VARCHAR(255) NOT NULL,
    CATEGORY VARCHAR(255),
    PRICE DECIMAL(10, 2) NOT NULL,
    BORROWER_ID INT,
    AVAILABLE BOOLEAN NOT NULL DEFAULT TRUE, -- 'AVAILABLE' column with NOT NULL constraint and a default value of TRUE
    FOREIGN KEY (BORROWER_ID) REFERENCES USERS(ID)
);

-- Create the USERS_ROLES table with an 'available' column
CREATE TABLE IF NOT EXISTS USERS_ROLES (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    USER_ID INT NOT NULL,
    ROLE_ID INT NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
    FOREIGN KEY (ROLE_ID) REFERENCES ROLES(ID)
);

-- Insert data into USERS table
INSERT INTO USERS (USERNAME, PASSWORD)
VALUES
    ('admin_1', 'admin_123'),
    ('user_1', 'user_123'),
    ('admin_user', '12345');

-- Insert data into ROLES table
INSERT INTO ROLES (NAME)
VALUES
    ('USER'),
    ('ADMIN');

-- Insert data into USERS_ROLES table
INSERT INTO USERS_ROLES (USER_ID, ROLE_ID)
VALUES
    (1, 2),
    (2, 1),
    (3, 1),
    (3, 2);

-- Insert data into BOOKS table with all BORROWER_ID values as null
INSERT INTO BOOKS (TITLE, AUTHOR, CATEGORY, PRICE, AVAILABLE, BORROWER_ID)
VALUES
    ('Rich Dad Poor Dad', 'Robert Kiyosaki', 'Finance', 9.55, true, null),
    ('The Lord of the Rings', 'John Ronald', 'High-Fantasy', 9.99, true, null),
    ('The Alchemist', 'Paulo Coelho', 'Fantasy, Adventure, Fiction', 6.42, true, null),
    ('Your Best Day is Today!', 'Anupam Kherv', 'Self-Help', 4.22, true, null),
    ('Clean Code', 'Robert C. Martin', 'Technology', 3.33, true, null),
    ('Atomic Habits', 'James Clear', 'Self-Help', 6.78, true, null),
    ('How to Not Die Alone', 'Logan Ury', 'Relationships', 5.99, true, null),
    ('The Notebook', 'Nicholas Sparks', 'Romance', 4.87, true, null),
    ('Fourth Wing', 'Rebecca Yarros', 'Romance', 7.66, true, null),
	('Test', 'Test', 'Test', 6.5, false, 2);

