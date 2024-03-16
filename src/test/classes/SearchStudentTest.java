package test.classes;

import main.classes.Student;
import main.classes.Library;
import main.classes.SearchByType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SearchStudentTest {
    private Library library;
    private Student student;
    private Student student2;
    private Student student3;
    private Student student4;


    @Before
    public void setUpData() {
        this.library = new Library();

        this.student = new Student("student1", 1);
        this.student2 = new Student("student2", 2);
        this.student3 = new Student("student3", 3);
        this.student4 = new Student("student4", 4);

        library.addStudent(this.student);
        library.addStudent(this.student2);
        library.addStudent(this.student3);
        library.addStudent(this.student4);
    }

    @Test
    public void searchStudentByNameTest() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(this.student3.getName());
        keys.add(this.student4.getName());

        ArrayList<Student> searchResult = this.library.searchStudents(SearchByType.NAME, keys);
        ArrayList<Student> expectedSearchResult = new ArrayList<>();
        expectedSearchResult.add(this.student3);
        expectedSearchResult.add(this.student4);

        assert (searchResult.equals(expectedSearchResult));

    }

    @Test
    public void searchStudentByIdTest() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(this.student.getId());
        keys.add(this.student2.getId());

        ArrayList<Student> searchResult = this.library.searchStudents(SearchByType.ID, keys);
        ArrayList<Student> expectedSearchResult = new ArrayList<>();
        expectedSearchResult.add(this.student);
        expectedSearchResult.add(this.student2);

        assert (searchResult.equals(expectedSearchResult));

    }

    @Test
    public void searchStudentByAuthorTest() {
        ArrayList<Object> keys = new ArrayList<>();
        ArrayList<Student> searchResult = this.library.searchStudents(SearchByType.AUTHOR, keys);
        assert (searchResult == null);
    }

    @Test
    public void searchStudentByTitleTest() {
        ArrayList<Object> keys = new ArrayList<>();
        ArrayList<Student> searchResult = this.library.searchStudents(SearchByType.TITLE, keys);
        assert (searchResult == null);
    }

}