package kandratski.library.repository;

import kandratski.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findBooksByPersonId(Integer personId);

    Book findFirstByNameContains(String searchTerm);

    @Override
    Page<Book> findAll(Pageable pageable);

    @Modifying
    @Query("UPDATE Book b SET b.personId=NULL, b.loanDate=NULL WHERE b.bookId = ?1")
    void returnBook(int id);

    @Modifying
    @Query("UPDATE Book b SET b.personId=?1, b.loanDate=NOW() WHERE b.bookId=?2")
    void lendBook(Integer personId, int id);

}
