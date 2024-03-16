package test.classes;

import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

public class SearchBookTest {
    private Library library;
    private Book book;
    private Book book2;
    private Book book3;
    private Book book4;


    @Before
    public void setUpData() {
        this.library = new Library();

        this.book = new Book("book1", "author-1", 1);
        this.book2 = new Book("book2", "author-2", 2);
        this.book3 = new Book("book3", "author-3", 3);
        this.book4 = new Book("book4", "author-4", 4);

        library.addBook(this.book);
        library.addBook(this.book2);
        library.addBook(this.book3);
        library.addBook(this.book4);
    }

    @Test
    public void searchBookByTitleTest() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(this.book.getTitle());
        keys.add(this.book2.getTitle());

        ArrayList<Book> searchResult = this.library.searchBooks(SearchByType.TITLE, keys);
        ArrayList<Book> expectedSearchResult = new ArrayList<>();
        expectedSearchResult.add(this.book);
        expectedSearchResult.add(this.book2);

        assert (searchResult.equals(expectedSearchResult));

    }

    @Test
    public void searchBookByAuthorTest() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(this.book3.getAuthor());
        keys.add(this.book4.getAuthor());

        ArrayList<Book> searchResult = this.library.searchBooks(SearchByType.AUTHOR, keys);
        ArrayList<Book> expectedSearchResult = new ArrayList<>();
        expectedSearchResult.add(this.book3);
        expectedSearchResult.add(this.book4);

        assert (searchResult.equals(expectedSearchResult));

    }

    @Test
    public void searchBookByIdTest() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(this.book.getId());
        keys.add(this.book4.getId());

        ArrayList<Book> searchResult = this.library.searchBooks(SearchByType.ID, keys);
        ArrayList<Book> expectedSearchResult = new ArrayList<>();
        expectedSearchResult.add(this.book);
        expectedSearchResult.add(this.book4);

        assert (searchResult.equals(expectedSearchResult));

    }

    @Test
    public void searchBookByNameTest() {
        ArrayList<Object> keys = new ArrayList<>();
        ArrayList<Book> searchResult = this.library.searchBooks(SearchByType.NAME, keys);
        assert (searchResult == null);
    }

}