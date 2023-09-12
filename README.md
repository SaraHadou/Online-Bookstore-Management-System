# Online-Bookstore-Management-System

The system offers our customers the ability to browse and search by category through available books, request books for borrowing for 3 days. Additionally, it enables administrators to maintain the inventory by adding, deleting or return books as needed.

**How to run this project:**

1- First, get SQL statements existing in `data.sql` file and run it on your MySQLWorkbench to create the database and insert `BOOKS` table with data.

2- Then, Open Postman app and let's run those two queries to register our users.
* POST Request with URL: http://localhost:8080/api/v1/auth/register 
  * for User Role -> insert this json data into the body
  
   `{
    "firstname": "user",  
    "lastname": "user", 
    "email": "user@user.com",
    "password": "12345", 
    "role": "USER"
    }`
  * for Admin Role -> insert this json data into the body
  
    `{
    "firstname": "admin",
    "lastname": "admin",
    "email": "admin@admin.com",
    "password": "12345",
    "role": "ADMIN"
    }`

3- Upload the code in `IntellJ` or whatever your favourite IDE.

4- Download the dependencies using `maven`.

5- On `Application.properties` file, update my url, username and password with yours to connect with your database.

6- Run the App and then do the following:
* enter your email and password we have just inserted through postman. (e.g. `user@user.com` & `12345`) to login as user.
* open the 'http://localhost:8080/api/v1/bookstore/' on your browser.

7- To logout, go to this url -> http://localhost:8080/logout

User can search by category, borrow and view books details.
Admin can view, add, delete and return the borrowed books as needed.

@Java @SpringBoot3.1.3, @Maven, @MYSQL
@Authentication @Authorization @Security 

Thank you :)

