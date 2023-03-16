package kandratski.library.models;

public class Book {

    private int book_id;

    private String name;

    private String author;

    private int yearOfPublishing;

    public Book() {
    }

    public Book(int book_id, String name, String author, int yearOfPublishing) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
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

    @Override
    public String toString() {
        return "Book{" +
               "book_id=" + book_id +
               ", name='" + name + '\'' +
               ", author='" + author + '\'' +
               ", yearOfPublishing=" + yearOfPublishing +
               '}';
    }
}
