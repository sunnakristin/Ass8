# HBV202GAssignment8
A Maven project skeleton. The provided Maven POM sets the Java version to 17.

All classes need to be located in Java package `is.hi.hbv202g.assignment8`.

Class and method names of the submitted solution need to be **exactly** the same 
as in the UML class diagram in the assignment PDF. 

If you like, you can import from project directory `UML` the file 
`library_system.uxf` into the online UML editor https://www.umletino.com/ 
and copy/paste from there class and method names: click on a class and then, 
you can copy from the `properties` window on the right hand side class 
and method names.

# Implemantion
Both the implementation and the tests are in Java package `is.hi.hbv202g.ass5`, 
but in the usual separate Maven `src` directories:

- `src/main/java/is/hi/hbv202g/assignment8`:
  - `Author.java`:
  - `Book.java`:
  - `EmptyAuthorListException.java`:
  - `FacultyMember`:
  - `Lending.java`:
  - `LibrarySystem.java`:
  - `Main.java`:
  - `Student.java`:
  - `User.java`:
  - `UserOrBookDoesNotExistException.java`:

- `src/main/java/is/hi/hbv202g/assignment8`:
  - `Alltests.java`:
  - `BookTest.java`:
  - `LendingTest.java`:
  - `LibrarySystemTest.java`:
  - `MainTest.java`:
  - `StudentTest.java`:



# Run program with jar
java -jar target/Assignment8-1.0-SNAPSHOT-jar-with-dependencies.jar
