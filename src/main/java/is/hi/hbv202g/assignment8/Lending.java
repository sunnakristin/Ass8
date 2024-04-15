package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

public class Lending {

    // instance variables
    private LocalDate duDate;
    private Book book;
    private User user;

    /**
     * Constructor
     * 
     * @param book book
     * @param user user
     */
    public Lending(Book book, User user) {
        this.duDate = LocalDate.now().plusDays(30);
        this.book = book;
        this.user = user;
    }

    /**
     * Get user
     * 
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set user
     * 
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get due date
     * 
     * @return due date
     */
    public LocalDate getDueDate() {
        return duDate;
    }

    /**
     * Set due date
     * 
     * @param duDate due date
     */
    public void setDueDate(LocalDate duDate) {
        this.duDate = duDate;
    }

    /**
     * Get book
     * 
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Set book
     * 
     * @param book book
     */
    public void setBook(Book book) {
        this.book = book;
    }

}
