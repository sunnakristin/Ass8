package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

import org.junit.Test;

public class LendingTest {

    /**
     * Test get due date
     */
    @Test
    public void getDueDateTest() {
        Book book = new Book("Title", "Author");
        User user = new Student("Name", true);
        Lending lending = new Lending(book, user);
        assert lending.getDueDate().equals(LocalDate.now().plusDays(30));
    }

    /**
     * Test set due date
     */
    @Test
    public void setDueDateTest() {
        Book book = new Book("Title", "Author");
        User user = new Student("Name", true);
        Lending lending = new Lending(book, user);
        lending.setDueDate(LocalDate.now().plusDays(2));
        assert lending.getDueDate().equals(LocalDate.now().plusDays(2));
    }

    /**
     * Test get book
     */
    @Test
    public void getBookTest() {
        Book book = new Book("Title", "Author");
        User user = new Student("Name", true);
        Lending lending = new Lending(book, user);
        assert lending.getBook().equals(book);
    }

    /**
     * Test set book
     */
    @Test
    public void setBookTest() {
        Book book = new Book("Title", "Author");
        User user = new Student("Name", true);
        Lending lending = new Lending(book, user);
        Book newBook = new Book("New Title", "New Author");
        lending.setBook(newBook);
        assert lending.getBook().equals(newBook);
    }

    /**
     * Test get user
     */
    @Test
    public void getUserTest() {
        Book book = new Book("Title", "Author");
        User user = new Student("Name", true);
        Lending lending = new Lending(book, user);
        assert lending.getUser().equals(user);
    }

    /**
     * Test set user
     */
    @Test
    public void setUserTest() {
        Book book = new Book("Title", "Author");
        User user = new Student("Name", true);
        Lending lending = new Lending(book, user);
        User newUser = new Student("New Name", true);
        lending.setUser(newUser);
        assert lending.getUser().equals(newUser);
    }
}
