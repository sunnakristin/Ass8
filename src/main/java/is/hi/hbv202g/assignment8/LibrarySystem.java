package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.List;

public class LibrarySystem{

    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    public LibrarySystem() {
        this.books = List.of();
        this.users = List.of();
        this.lendings = List.of();
    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) throws EmptyAuthorListException {
        Book book = new Book(title, authorName);
        books.add(book);
    }

    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) {
        Book book = new Book(title, authors);
        books.add(book);
    }

    public void addStudentUser(String name, boolean feePaid) {
        Student student = new Student(name, feePaid);
        users.add(student);
    }

    public void addFacultyMemberUser(String name, String department) {
        FacultyMember facultyMember = new FacultyMember(name, department);
        users.add(facultyMember);
    }

    public Book findBookByTitle(String title) {
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getTitle().equals(title)) {
                return books.get(i);
            }
        }
        return null;
    }

    public User findUserByName(String name) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getName().equals(name)) {
                return users.get(i);
            }
        }
        return null;
    }

    public void borrowBook(User user, Book book) {
        Lending lending = new Lending(book, user);
        lendings.add(lending);
    }

    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
        Lending lending = new Lending(book, facultyMember);
        lending.setDuDate(newDueDate);
    }

    public void returnBook(User user, Book book) {
        Lending lending = new Lending(book, user);
        lendings.remove(lending);
    }
}
