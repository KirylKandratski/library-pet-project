package kandratski.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "Author cannot be blank")
    @Size(min = 2, max = 30, message = "Author name must be between 2 and 30 characters")
    @Column(name = "author")
    private String author;
    @Min(value = 1800, message = "Year of publishing should not be less than 1800")
    @Max(value = 2023, message = "Year of publishing should not be more than 2023")
    @Column(name = "year_of_publishing")
    private int yearOfPublishing;
    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "loan_date")
    private Date loanDate;

    public Book() {
    }

    public Book(int bookId, String name, String author, int yearOfPublishing, Integer personId, Date loanDate) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.personId = personId;
        this.loanDate = loanDate;
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

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loadDate) {
        this.loanDate = loadDate;
    }

    @Override
    public String toString() {
        return "Book{" +
               "bookId=" + bookId +
               ", name='" + name + '\'' +
               ", author='" + author + '\'' +
               ", yearOfPublishing=" + yearOfPublishing +
               ", personId=" + personId +
               ", loadDate=" + loanDate +
               '}';
    }

}
