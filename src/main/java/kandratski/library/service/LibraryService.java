package kandratski.library.service;

import kandratski.library.dao.BookDAO;
import kandratski.library.dao.PersonDAO;
import kandratski.library.models.Book;
import kandratski.library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final PersonDAO personDAO;
    private final BookDAO bookDAO;

    @Autowired
    public LibraryService(PersonDAO personDAO, BookDAO bookDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    public List<Book> getBooksByPersonId(int personId) {
        return bookDAO.getBooksByPersonId(personId);
    }

    public Person getPersonById(int personId) {
        return personDAO.getById(personId);
    }

    public List<Person> getPersonList() {
        return personDAO.getAll();
    }
}
