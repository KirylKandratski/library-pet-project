package kandratski.library.models;

public class Book {

    private int book_id;

    private String name;

    private String author;

    private int yearOfPublishing;


    private Integer person_id;


    public Book() {
    }

    public Book(int book_id, String name, String author, int yearOfPublishing, Integer personId) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        person_id = personId;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
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

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Book{" +
               "book_id=" + book_id +
               ", name='" + name + '\'' +
               ", author='" + author + '\'' +
               ", yearOfPublishing=" + yearOfPublishing +
               ", person_id=" + person_id +
               '}';
    }

}
