package kandratski.library.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Book {

    private int bookId;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Author cannot be blank")
    @Size(min = 2, max = 30, message = "Author name must be between 2 and 30 characters")
    private String author;
    @Min(value = 1800, message = "Year of publishing should not be less than 1800")
    @Max(value = 2023, message = "Year of publishing should not be more than 2023")
    private int yearOfPublishing;


    private Integer personId;


    public Book() {
    }

    public Book(int bookId, String name, String author, int yearOfPublishing, Integer personId) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.personId = personId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Book{" +
               "book_id=" + bookId +
               ", name='" + name + '\'' +
               ", author='" + author + '\'' +
               ", yearOfPublishing=" + yearOfPublishing +
               ", person_id=" + personId +
               '}';
    }

}
