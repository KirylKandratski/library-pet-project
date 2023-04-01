package kandratski.library.service;

import kandratski.library.dto.BookDTO;
import kandratski.library.entity.Book;
import kandratski.library.entity.Person;
import kandratski.library.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final BooksService booksService;
    private final PeopleService peopleService;

    @Autowired
    public LibraryService(BooksService booksService, PeopleService peopleService) {
        this.booksService = booksService;
        this.peopleService = peopleService;
    }

    public List<BookDTO> getBooksByPersonId(Integer personId) {
        return booksService.getBooksByPersonId(personId).stream()
                .map(this::convertToBookDTO)
                .collect(Collectors.toList());
    }

    public Person getPersonById(int personId) {
        return peopleService.findById(personId);
    }

    public List<Person> getPersonList() {

        return peopleService.findAll();
    }

    public BookDTO convertToBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(book.getBookId());
        bookDTO.setName(book.getName());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setYearOfPublishing(book.getYearOfPublishing());

        if (book.getLoanDate() != null) {
            bookDTO.setOverdue(DateUtils.isOverdue(book.getLoanDate(), 10));
        } else {
            bookDTO.setOverdue(false);
        }

        return bookDTO;
    }
}
