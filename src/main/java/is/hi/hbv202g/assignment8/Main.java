package is.hi.hbv202g.assignment8;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) throws EmptyAuthorListException {
        LibrarySystem myLibrarySystem = new LibrarySystem();

        myLibrarySystem.addBookWithTitleAndAuthorList("The Hobbit", List.of(new Author("JRR Tolkien")));
        myLibrarySystem.addBookWithTitleAndAuthorList("The Fellowship of the Ring", List.of(new Author("JRR Tolkien")));
        myLibrarySystem.addBookWithTitleAndAuthorList("The Two Towers", List.of(new Author("JRR Tolkien")));
        myLibrarySystem.addBookWithTitleAndAuthorList("The Return of the King", List.of(new Author("JRR Tolkien")));
    }
}
