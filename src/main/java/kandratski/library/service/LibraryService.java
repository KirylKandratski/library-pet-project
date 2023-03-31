package kandratski.library.service;

import kandratski.library.entity.Book;
import kandratski.library.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final BooksService booksService;
    private final PeopleService peopleService;

    @Autowired
    public LibraryService(BooksService booksService, PeopleService peopleService) {
        this.booksService = booksService;
        this.peopleService = peopleService;
    }

    public List<Book> getBooksByPersonId(Integer personId) {
        return booksService.getBooksByPersonId(personId);
    }

    public Person getPersonById(int personId) {
        return peopleService.findById(personId);
    }

    public List<Person> getPersonList() {

        return peopleService.findAll();
    }
}
