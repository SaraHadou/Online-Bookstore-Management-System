-- Create the database
CREATE DATABASE IF NOT EXISTS bookstoreDB;

-- Use the database
USE bookstoreDB;

-- Create the USERS table
CREATE TABLE IF NOT EXISTS USERS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    FIRSTNAME VARCHAR(255) NOT NULL,
    LASTNAME VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) UNIQUE NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
	ROLE ENUM('USER', 'ADMIN') NOT NULL
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
	BORROWINGDATE TIMESTAMP,
    FOREIGN KEY (BORROWER_ID) REFERENCES USERS(ID)
);

-- Insert data into USERS table
-- INSERT INTO USERS (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ROLE)
-- VALUES
--     ('sara', 'admin', 'admin@admin.com', '12345', 'ADMIN'),
--     ('sara', 'user', 'user@user.com', '12345', 'USER');

-- Insert data into BOOKS tabl
INSERT INTO BOOKS (TITLE, AUTHOR, CATEGORY, PRICE, AVAILABLE, BORROWINGDATE, BORROWER_ID)
VALUES
    ('Rich Dad Poor Dad', 'Robert Kiyosaki', 'Finance', 9.55, true, null, null),
    ('The Lord of the Rings', 'John Ronald', 'High-Fantasy', 9.99, true, null, null),
    ('The Alchemist', 'Paulo Coelho', 'Fantasy, Adventure, Fiction', 6.42, true, null, null),
    ('Your Best Day is Today!', 'Anupam Kherv', 'Self-Help', 4.22, true, null, null),
    ('Clean Code', 'Robert C. Martin', 'Technology', 3.33, true, null, null),
    ('Atomic Habits', 'James Clear', 'Self-Help', 6.78, true, null, null),
    ('How to Not Die Alone', 'Logan Ury', 'Relationships', 5.99, true, null, null),
    ('The Notebook', 'Nicholas Sparks', 'Romance', 4.87, true, null, null),
    ('Fourth Wing', 'Rebecca Yarros', 'Romance', 7.66, true, null, null),
	('Test', 'Test', 'Test', 6.5, true, null, null);

