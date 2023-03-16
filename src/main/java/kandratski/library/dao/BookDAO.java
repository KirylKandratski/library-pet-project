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
}
