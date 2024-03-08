package is.hi.hbv202g.assignment8;

import java.util.List;

public class Book {

    private String title;
    private List<Author> authors;

    public Book(String title, String authorName) throws EmptyAuthorListException {
        this.title = title;
        try {
            this.authors = List.of(new Author(authorName));
        } catch (EmptyAuthorListException e) {
            this.authors = List.of();
        } // þurfum að laga þennan part
    }

    public Book(String title, List<Author> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }
}
