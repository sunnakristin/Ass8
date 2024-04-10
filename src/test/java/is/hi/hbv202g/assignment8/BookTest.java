package is.hi.hbv202g.assignment8;

import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.Test;

public class BookTest {

    @Test
    public void testAuthorList() throws EmptyAuthorListException {
        Book book = new Book("Title", List.of(new Author("Author1"), new Author("Author2")));
        assert book.getAuthors().size() == 2;
    }

    @Test
    public void testAuthorListEmpty() throws EmptyAuthorListException {
        Book book = new Book("Title", List.of());
        assert book.getAuthors().size() == 0;
    }

    @Test
    public void testAuthorListThrowsExcpetion() throws EmptyAuthorListException {
        assertThrows(EmptyAuthorListException.class, () -> new Book("Title", (List<Author>) null));
    }

    @Test
    public void addAuthorTest() throws EmptyAuthorListException {
        List<Author> authors = List.of(new Author("Author1"), new Author("Author2"));
        Book book = new Book("Title", authors);
        Author author = new Author("Author3");
        book.addAuthor(author);
        assert book.getAuthors().size() == 3;
    }

    @Test
    public void getAuthorsTest() throws EmptyAuthorListException {
        Book book = new Book("Title", List.of(new Author("Author1"), new Author("Author2")));
        assert book.getAuthors().size() == 2;
    }
}
