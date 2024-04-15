# HBV202G Assignment8
A Maven project skeleton. The provided Maven POM sets the Java version to 17.

All classes need to be located in Java package `is.hi.hbv202g.assignment8`.

Class and method names of the submitted solution need to be **exactly** the same 
as in the UML class diagram in the assignment PDF. 


# Implemantion
Both the implementation and the tests are in Java package `is.hi.hbv202g.assignment8`, 
but in the usual separate Maven `src` directories:

- `src/main/java/is/hi/hbv202g/assignment8`:
  - `Author.java`: Implementation of an author.
  - `Book.java`: Implementation of a book that has a name and a list of authors/author.
  - `EmptyAuthorListException.java`: An exception that is thrown if a list of authors is empty.
  - `FacultyMember`: Implementation of a faculty member that is a user.
  - `Lending.java`: Implementation of lending a book. 
  - `LibrarySystem.java`: Implementation of a single library system that keeps track of all books, all users and all lendings.
  - `Main.java`: A class with a simple text UI.
  - `Student.java`: Implementation of a student that is a user.
  - `User.java`: Implementation of a user.
  - `UserOrBookDoesNotExistException.java`: An excpeption that is thrown if book or user does not exist.

- `src/main/java/is/hi/hbv202g/assignment8`:
  - `Alltests.java`: A class that runs all the test classes.
  - `BookTest.java`: A skeleton for a class containing JUnit4 test cases for the `Book` class.
  - `LendingTest.java`: A skeleton for a class containing JUnit4 test cases for the `Lending` class.
  - `LibrarySystemTest.java`: A skeleton for a class containing JUnit4 test cases for the `LibrarySystem` class.
  - `MainTest.java`: A skeleton for a class containing JUnit4 test cases for the `Main` class.
  - `StudentTest.java`: A skeleton for a class containing JUnit4 test cases for the `Student` class.

# Run the program

## Maven
- `mvn compile` compiles all implementation classes.
- `mvn exec:java` executes the main method of the implementation.
- `mvn test` runs all test cases (i.e. all classes with a name that either starts with `Test` or ends with `Test`, `Tests`, or `TestCase`).

## Jar
- `java -jar target/Assignment8-1.0-SNAPSHOT-jar-with-dependencies.jar` executes the main method of the implementation.

# License
MIT license: [License](LICENSE)

UML: [UML](src/site/markdown/uml.md)
