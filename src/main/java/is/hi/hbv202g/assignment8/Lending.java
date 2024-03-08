package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

public class Lending {

    private LocalDate duDate;
    private Book book;

    public LocalDate getDuDate() {
        return duDate;
    }

    public void setDuDate(LocalDate duDate) {
        this.duDate = duDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Lending(Book book, User user) {
        this.book = book;
        this.duDate = LocalDate.now();
    }

}
