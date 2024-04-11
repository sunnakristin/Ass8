package is.hi.hbv202g.assignment8;

import java.util.List;

public class Book {

    // fields
    private String title;
    private List<Author> authors;

    /**
     * Constructor
     * 
     * @param title      title of the book
     * @param authorName name of the author
     */
    public Book(String title, String authorName) {
        this.title = title;
        this.authors = List.of(new Author(authorName));
    }

    /**
     * Constructor
     * 
     * @param title   title of the book
     * @param authors list of authors
     * @throws EmptyAuthorListException if the list of authors is null or empty
     */
    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        if (authors == null || authors.isEmpty()) {
            throw new EmptyAuthorListException("Author list cannot be null or empty.");
        }
        this.title = title;
        this.authors = authors;
    }

    /**
     * Gets the title of the object.
     *
     * @return the title of the object
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the object.
     * 
     * @param title the new title of the object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the authors of the object.
     *
     * @return a description of return value
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Sets the authors of the object.
     * 
     * @param authors the new authors of the object
     * @throws EmptyAuthorListException if the list of authors is null or empty
     */
    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()) {
            throw new EmptyAuthorListException("Author list cannot be empty.");
        }
        this.authors = authors;
    }

    /**
     * Adds an author to the list of authors.
     *
     * @param author the author to be added
     * @return void
     */
    public void addAuthor(Author author) {
        authors.add(author);
    }
}
