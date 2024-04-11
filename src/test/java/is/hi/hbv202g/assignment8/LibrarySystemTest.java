package is.hi.hbv202g.assignment8;

import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class LibrarySystemTest {
    /**
     * test add book with title and name of single author
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void addBookWithTitleAndNameOfSingleAuthorTest() {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Title", "Name");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Title", "Name");
        assert librarySystem.getBooks().size() == 2;
    }

    /**
     * test add book with title and more than one name of authors
     * 
     * @throws EmptyAuthorListException
     */
    @Test
    public void addBookWithTitleAndAuthorListTest() throws EmptyAuthorListException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBookWithTitleAndAuthorList("Title", List.of(new Author("Author1"), new Author("Author2")));
        assert librarySystem.getBooks().size() == 1;
    }

    /**
     * test add student user
     */
    @Test
    public void addStudentUserTest() {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addStudentUser("Name", true);
        assert librarySystem.getUsers().size() == 1;
    }

    /**
     * test add faculty member
     */
    @Test
    public void addFacultyMemberUserTest() {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addFacultyMemberUser("Name", "Department");
        assert librarySystem.getUsers().size() == 1;
    }

    /**
     * test find book by title
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void findBookByTitleTest() throws UserOrBookDoesNotExistException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Title", "Name");
        assert librarySystem.findBookByTitle("Title").getTitle().equals("Title");
    }

    /**
     * test find book by title
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void findBookByTitleThrowsExceptionTest() throws UserOrBookDoesNotExistException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Title", "Name");
        assertThrows(UserOrBookDoesNotExistException.class, () -> librarySystem.findBookByTitle("Title2"));
    }

    /**
     * test find user by name
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void findUserByNameTest() throws UserOrBookDoesNotExistException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addStudentUser("Name", true);
        assert librarySystem.findUserByName("Name").getName().equals("Name");
    }

    /**
     * test that find user by name throws exception if user does not exist
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void findUserByNameThrowsExceptionTest() throws UserOrBookDoesNotExistException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addStudentUser("Name", true);
        assertThrows(UserOrBookDoesNotExistException.class, () -> librarySystem.findUserByName("Name2"));
    }

    /**
     * test borrow book
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void borrowBookTest() throws UserOrBookDoesNotExistException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addStudentUser("Name", true);
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Title", "Name");
        librarySystem.borrowBook(librarySystem.findUserByName("Name"), librarySystem.findBookByTitle("Title"));
        assert librarySystem.getLendings().size() == 1;
    }

    /**
     * A method to test the extension of lending in the Library System.
     *
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    @Test
    public void extendLendingTest() throws UserOrBookDoesNotExistException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addFacultyMemberUser("NameOfFacultyMember", "Department");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Title", "NameOfAuthors");
        librarySystem.borrowBook(librarySystem.findUserByName("NameOfFacultyMember"),
                librarySystem.findBookByTitle("Title"));
        LocalDate newDueDate = librarySystem.getLendings().get(0).getDueDate().plusDays(1);
        librarySystem.extendLending((FacultyMember) librarySystem.findUserByName("NameOfFacultyMember"),
                librarySystem.findBookByTitle("Title"), newDueDate);
        assert librarySystem.getLendings().get(0).getDueDate().equals(newDueDate);
    }

    /**
     * A description of the entire Java function.
     *
     * @param paramName description of parameter
     * @return description of return value
     */
    @Test
    public void returnBookTest() throws UserOrBookDoesNotExistException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addStudentUser("Name", true);
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Title", "Name");
        librarySystem.borrowBook(librarySystem.findUserByName("Name"), librarySystem.findBookByTitle("Title"));
        librarySystem.returnBook(librarySystem.findUserByName("Name"), librarySystem.findBookByTitle("Title"));
        assert librarySystem.getLendings().size() == 0;
    }
}
