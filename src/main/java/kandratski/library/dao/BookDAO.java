package kandratski.library.dao;

import kandratski.library.models.Book;
import kandratski.library.models.Person;
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
        jdbcTemplate.update("INSERT INTO Book (name, author, year_of_publishing) VALUES (?, ?, ?)",
                book.getName(),
                book.getAuthor(),
                book.getYearOfPublishing());
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
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, year_of_publishing=? WHERE book_id=?",
                updatedBook.getName(),
                updatedBook.getAuthor(),
                updatedBook.getYearOfPublishing(),
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id = ?", id);
    }
}
