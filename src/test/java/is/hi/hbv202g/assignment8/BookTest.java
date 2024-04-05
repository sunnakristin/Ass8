package is.hi.hbv202g.assignment8;

import java.util.List;

import org.junit.Test;

public class BookTest {

    @Test
    public void testAuthorList() throws EmptyAuthorListException {
        Book book = new Book("Title", List.of(new Author("Author1"), new Author("Author2")));
        assert book.getAuthors().size() == 2;
    }
}
