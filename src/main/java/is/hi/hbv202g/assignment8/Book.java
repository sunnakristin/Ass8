package is.hi.hbv202g.assignment8;

import java.util.List;

public class Book {

    private String title;
    private List<Author> authors;

    public Book(String title, String authorName) {
        this.title = title;
        this.authors = List.of(new Author(authorName));
    }

    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        if (authors == null || authors.isEmpty()) {
            throw new EmptyAuthorListException("Author list cannot be null or empty.");
        }
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

    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()) {
            throw new EmptyAuthorListException("Author list cannot be empty.");
        }
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }
}
