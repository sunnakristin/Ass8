package is.hi.hbv202g.assignment8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LibrarySystemTest {

    // instance variables
    private String studentName;
    private String title;
    private String authorName;

    /**
     * Set up the test environment before each test case.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        studentName = "StudentName";
        authorName = "AuthorName";
        title = "Title";
        LibrarySystem.getInstance().resetSystem();
    }

    /**
     * test add book with title and name of single author
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void addBookWithTitleAndNameOfSingleAuthorTest() {
        LibrarySystem.getInstance().addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        assert LibrarySystem.getInstance().getBooks().size() == 1;
    }

    /**
     * test add book with title and more than one name of authors
     * 
     * @throws EmptyAuthorListException
     */
    @Test
    public void addBookWithTitleAndAuthorListTest() throws EmptyAuthorListException {
        LibrarySystem.getInstance().addBookWithTitleAndAuthorList(title,
                List.of(new Author(authorName), new Author("Author2")));
        assertEquals(1, LibrarySystem.getInstance().getBooks().size());
    }

    /**
     * test add student user
     */
    @Test
    public void addStudentUserTest() {
        LibrarySystem.getInstance().addStudentUser(studentName, true);
        assertEquals(1, LibrarySystem.getInstance().getUsers().size());
    }

    /**
     * test add faculty member
     */
    @Test
    public void addFacultyMemberUserTest() {
        LibrarySystem.getInstance().addFacultyMemberUser("Name", "Department");
        assertEquals(1, LibrarySystem.getInstance().getUsers().size());
    }

    /**
     * test find book by title
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void findBookByTitleTest() throws UserOrBookDoesNotExistException {
        LibrarySystem.getInstance().addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        assert LibrarySystem.getInstance().findBookByTitle(title).getTitle().equals(title);
    }

    /**
     * test find book by title
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void findBookByTitleThrowsExceptionTest() throws UserOrBookDoesNotExistException {
        LibrarySystem.getInstance().addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        assertThrows(UserOrBookDoesNotExistException.class,
                () -> LibrarySystem.getInstance().findBookByTitle("Title2"));
    }

    /**
     * test find user by name
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void findUserByNameTest() throws UserOrBookDoesNotExistException {
        LibrarySystem.getInstance().addStudentUser(studentName, true);
        assert LibrarySystem.getInstance().findUserByName(studentName).getName().equals(studentName);
    }

    /**
     * test that find user by name throws exception if user does not exist
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void findUserByNameThrowsExceptionTest() throws UserOrBookDoesNotExistException {
        LibrarySystem.getInstance().addStudentUser(studentName, true);
        assertThrows(UserOrBookDoesNotExistException.class, () -> LibrarySystem.getInstance().findUserByName("Name2"));
    }

    /**
     * test borrow book
     * 
     * @throws UserOrBookDoesNotExistException
     */
    @Test
    public void borrowBookTest() throws UserOrBookDoesNotExistException {
        LibrarySystem.getInstance().addStudentUser(studentName, true);
        LibrarySystem.getInstance().addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        LibrarySystem.getInstance().borrowBook(LibrarySystem.getInstance().findUserByName(studentName),
                LibrarySystem.getInstance().findBookByTitle(title));
        assert LibrarySystem.getInstance().getLendings().size() == 1;
    }

    /**
     * A method to test the extension of lending in the Library System.
     *
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    @Test
    public void extendLendingTest() throws UserOrBookDoesNotExistException {
        String facultyMember = "NameOfFacultyMember";
        LibrarySystem.getInstance().addFacultyMemberUser(facultyMember, "Department");
        LibrarySystem.getInstance().addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        LibrarySystem.getInstance().borrowBook(LibrarySystem.getInstance().findUserByName(facultyMember),
                LibrarySystem.getInstance().findBookByTitle(title));
        LocalDate newDueDate = LibrarySystem.getInstance().getLendings().get(0).getDueDate().plusDays(1);
        LibrarySystem.getInstance().extendLending(
                (FacultyMember) LibrarySystem.getInstance().findUserByName(facultyMember),
                LibrarySystem.getInstance().findBookByTitle(title), newDueDate);
        assertEquals(newDueDate, LibrarySystem.getInstance().getLendings().get(0).getDueDate());
        ;
    }

    /**
     * A description of the entire Java function.
     *
     * @param paramName description of parameter
     * @return description of return value
     */
    @Test
    public void returnBookTest() throws UserOrBookDoesNotExistException {
        LibrarySystem.getInstance().addStudentUser(studentName, true);
        LibrarySystem.getInstance().addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        LibrarySystem.getInstance().borrowBook(LibrarySystem.getInstance().findUserByName(studentName),
                LibrarySystem.getInstance().findBookByTitle(title));
        LibrarySystem.getInstance().returnBook(LibrarySystem.getInstance().findUserByName(studentName),
                LibrarySystem.getInstance().findBookByTitle(title));
        assertEquals(0, LibrarySystem.getInstance().getLendings().size());
    }
}
