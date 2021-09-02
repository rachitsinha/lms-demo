# lms-demo
## Instructions to run:

1. Download the project and extract the zip file.
2. Open Windows command line (cmd).
3. Navigate to the folder "lms-demo"
4. Type the following command and enter: 
	mvnw spring-boot:run
5. This will start the REST service
6. Refer to the APIs.txt file for a list of all REST APIs and request payloads.

## APIs 

1. Add new book
http://localhost:8080/books/add
Type: POST
Request:
    {
        "title": "IKIGAI",
        "isbn" : "123-456-333",
        "cost" : 1230.56
    }

2. Get all books
http://localhost:8080/books/all
Type: GET 

3. Update a book 
http://localhost:8080/books/update/{bookId}
Type: POST
Request:
    {
        "title": "IKIGAI version 2.0",
        "isbn" : "123-456-333",
        "cost" : 1230.56
    }

4. Delete a book
http://localhost:8080/books/delete/{bookId}
Type: POST 
Request:
{ }

5. Find a book by isbn
http://localhost:8080/books/findByIsbn/{isbn}
Type: GET 

6. Find a book by title
http://localhost:8080/books/findByTitle/{title}
Type: GET 

7. Add a new user (patron)
http://localhost:8080/users/add
Type: POST 
Request:
{
    "name" : "Rachit",
    "phone" : "8233355889",
    "dateOfBirth" : "1990-06-15"
}

8. Get all users
http://localhost:8080/users/all
Type: GET 

9. Update a user
http://localhost:8080/users/update/{userId}
Type: POST 
Request: 
{
    "name" : "Rachit Sinha",
    "phone" : "+918233355889",
    "dateOfBirth" : "1990-06-30"
}

10. Delete a user
http://localhost:8080/users/delete/{userId}
Type: POST
Request: 
{}

11. Borrow a book
http://localhost:8080/inventory/borrow 
Type: POST
Request: 
{
    "isbn" : "123-456-7890",
    "userId" : "5"
}

12. Return a book
http://localhost:8080/inventory/return 
Type: POST
Request: 
{
    "userId" : "1",
    "bookId" : "4",
    "isbn" : "123-456-7890"
}

13. Number of available books in inventory
http://localhost:8080/inventory/availablebookscount 
Type: GET 

14. Number of available books by ISBN 
http://localhost:8080/inventory/availablebookscount/{isbn} 
Type: GET 

15. Number of borrowed books 
http://localhost:8080/inventory/borrowedbookscount 
Type: GET 

16. Number of borrowed books by User userId
http://localhost:8080/inventory/borrowedbookscount/{userId} 
Type: GET 
