# BookLibraryRestApi Application

      Spring Boot REST API application for managing books in a library.

      Features: add,fetch,delete,fetch all books from library etc.

      Tech Stack- Java17,SpringBoot,JPA,Maven,Mysql DB,Swagger etc.

      instructions- checkout out project from github in your IDE like intellij, setup MySql Db(Oracle SQl developer) and provide db config in properties file,
       compile and run application .once tomcate server started you can hit api's curl via postman and test.

      Postman  collection are attaching for GET,POST,PUT,DELETE operations.
    
 
   # curls for every opertions below-

Add a Book-

curl --request POST \
--url http://localhost:8080/library/books \
--header 'Content-Type: application/json' \
--data '{"title": "kafka3",
"author": "xyz"
}'


Get all books-

curl --request GET \
--url http://localhost:8080/library/books \
--header 'Content-Type: application/json'

   
Delete a book-

curl --request DELETE \
--url http://localhost:8080/library/books/3 \
--header 'Content-Type: application/json'


Get a book  by id-

curl --request GET \
--url http://localhost:8080/library/books/3 \
--header 'Content-Type: application/json'


update book--

curl --request PUT \
--url http://localhost:8080/library/books/1 \
--header 'Content-Type: application/json' \
--data '{"title": "SpringBoot", "author": "james", "isbn": "344567"}'


# for swagger documentation

run below url on local

http://localhost:8080/swagger-ui/index.html
