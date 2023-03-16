package kandratski.library.models;

public class Book {

    private int bookId;

    private String name;

    private String author;

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
