package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.List;

public class LibrarySystem {

    private static LibrarySystem instance;

    // fields
    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    /**
     * Constructor
     * 
     * vil breyta í private
     */
    private LibrarySystem() {
        lendings = new java.util.ArrayList<>();
        books = new java.util.ArrayList<>();
        users = new java.util.ArrayList<>();
    }

    /**
     * Get instance of the library system
     * 
     * @return
     */
    public static LibrarySystem getInstance() {
        if (instance == null) {
            instance = new LibrarySystem();
        }
        return instance;
    }

    /**
     * Add book with title and name of single author
     * 
     * @param title      title of the book
     * @param authorName name of the author
     */
    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) {
        Book book = new Book(title, authorName);
        books.add(book);
    }

    /**
     * Add book with title and more than one name of authors
     * 
     * @param title   title of the book
     * @param authors list of authors
     * @throws EmptyAuthorListException
     */
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()) {
            throw new EmptyAuthorListException("Author list cannot be empty.");
        }
        Book book = new Book(title, authors);
        books.add(book);
    }

    /**
     * Creates a new Student object with the given name and feePaid status, then
     * adds it to the users list.
     *
     * @param name    the name of the student
     * @param feePaid the fee payment status of the student
     */
    public void addStudentUser(String name, boolean feePaid) {
        Student student = new Student(name, feePaid);
        users.add(student);
    }

    /**
     * Creates a new FacultyMember object with the given name and department, then
     * adds it to the users list.
     * 
     * @param name       name of the faculty member
     * @param department department of the faculty member
     */
    public void addFacultyMemberUser(String name, String department) {
        FacultyMember facultyMember = new FacultyMember(name, department);
        users.add(facultyMember);
    }

    /**
     * Find book by title
     * 
     * @param title title of the book
     * @return book
     * @throws UserOrBookDoesNotExistException
     */
    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                return books.get(i);
            }
        }
        throw new UserOrBookDoesNotExistException("Book does not exist.");
    }

    /**
     * Find user by name
     * 
     * @param name name of the user
     * @return user
     * @throws UserOrBookDoesNotExistException
     */
    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return users.get(i);
            }
        }
        throw new UserOrBookDoesNotExistException("User does not exist.");
    }

    /**
     * Borrow book
     * 
     * @param user user
     * @param book book
     */
    public void borrowBook(User user, Book book) {

        Lending lending = new Lending(book, user);
        lendings.add(lending);
    }

    /**
     * Extend lending
     * 
     * @param facultyMember faculty member
     * @param book          book
     * @param newDueDate    new due date
     * @throws UserOrBookDoesNotExistException
     */
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate)
            throws UserOrBookDoesNotExistException {
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(facultyMember)) {
                lending.setDueDate(newDueDate);
                return;
            }
        }

        throw new UserOrBookDoesNotExistException("No lending found for the specified book and faculty member.");
    }

    /**
     * Return book
     * 
     * @param user user
     * @param book book
     * @throws UserOrBookDoesNotExistException
     */
    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException {
        Lending matchingLending = null;
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(user)) {
                matchingLending = lending;
                break;
            }
        }

        if (matchingLending != null) {
            lendings.remove(matchingLending);
        } else {
            throw new UserOrBookDoesNotExistException("Book has not been rented or was not borrowed by this user.");
        }
    }

    /**
     * Get books
     * 
     * @return list of books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Get users
     * 
     * @return list of users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Get lendings
     * 
     * @return list of lendings
     */
    public List<Lending> getLendings() {
        return lendings;
    }
}
