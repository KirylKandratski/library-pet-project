# Library Pet Project

This project is a simple web application for a library, written in Java using Spring Framework and Thymeleaf. It allows users to add, edit, delete, and view books and readers in the library.

## Project Features

* Add, edit, delete, and view books and readers
* Use Hibernate Validator for data validation
* Use Spring JDBC and PostgreSQL for data storage
* Use Thymeleaf for page rendering

## Installation Requirements

To install and run this project, you will need:

* JDK 8 or higher
* Apache Maven
* PostgreSQL

## Installation Steps

1. Clone this repository to your local computer.
2. Create a PostgreSQL database.
3. Edit the src/main/resources/application.properties file to match your database. Specify the URL, username, and password.
4. Open a terminal and navigate to the project's root directory.
5. Run the command mvn clean install to build the project.
6. Start the application using the command java -jar target/library-pet-project-1.0-SNAPSHOT.war.
7. Open a web browser and go to http://localhost:8080.

## Usage

After starting the application, you will be able to:

* Add new books and readers
* Edit information about existing books and readers
* Delete books and readers
* View a list of all books and readers
* View detailed information about each book and reader, including a list of books checked out by a particular reader
* Check out books to readers and return them

## License

This project is licensed under the terms of the MIT license.

## Contact

If you have any questions or suggestions, please contact me by email: `kiryl.kandratski@gmail.com`.