package test.classes;

import main.classes.Book;
import main.classes.Library;
import main.classes.Student;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class LendTest {
    @Test
    public void lendBookTest() {
        Library library = new Library();
        Book book1 = new Book("Book-1", "Author-1", 10);
        Student student1 = new Student("Alice", 10);

        library.addBook(book1);

        boolean is_successful = library.lendBook(book1, student1);

        // should fail because library doesn't have the student
        assertFalse(is_successful);
    }
}
