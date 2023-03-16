package kandratski.library.dao;

import kandratski.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO Book (name, author, year_of_publishing, person_id) VALUES (?, ?, ?, ?)",
                book.getName(),
                book.getAuthor(),
                book.getYearOfPublishing(),
                book.getPersonId());
    }

    public List<Book> getAll() {
        return jdbcTemplate.query("SELECT * FROM Book",
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getById(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, year_of_publishing=?, person_id=? WHERE book_id=?",
                updatedBook.getName(),
                updatedBook.getAuthor(),
                updatedBook.getYearOfPublishing(),
                updatedBook.getPersonId(),
                id);
    }

    public void returnBook(int id) {
        jdbcTemplate.update("UPDATE book SET person_id=NULL WHERE book_id=?",
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id = ?", id);
    }

    public List<Book> getBooksByPersonId(int personId) {
        String sql = "SELECT * FROM book WHERE person_id = ?";
        List<Book> books = jdbcTemplate.query(sql, new Object[]{personId}, new BeanPropertyRowMapper<>(Book.class));
        return books;
    }

    public void lendBook(int id, Integer personId) {
        jdbcTemplate.update("UPDATE book SET person_id=? WHERE book_id=?",
                personId,
                id);
    }
}
