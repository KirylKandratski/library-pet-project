package kandratski.library.service;

import kandratski.library.entity.Book;
import kandratski.library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Page<Book> findAll(PageRequest pageRequest) {
        return booksRepository.findAll(pageRequest);
    }


    public Book findById(int id) {
        Optional<Book> bookById = booksRepository.findById(id);
        return bookById.orElse(null);
    }

    public Book findByName(String searchTerm) {
        return booksRepository.findFirstByNameContains(searchTerm);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setPersonId(id);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    public List<Book> getBooksByPersonId(Integer personId) {
        return booksRepository.findBooksByPersonId(personId);
    }

    @Transactional
    public void returnBook(int id) {
        booksRepository.returnBook(id);
    }

    @Transactional
    public void lendBook(Integer personId, int id) {
        booksRepository.lendBook(personId, id);
    }


}
