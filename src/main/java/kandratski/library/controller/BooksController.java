package kandratski.library.controller;

import kandratski.library.dao.BookDAO;
import kandratski.library.models.Book;
import kandratski.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final BookDAO bookDAO;
    private final LibraryService libraryService;

    @Autowired
    public BooksController(BookDAO bookDAO, LibraryService libraryService) {
        this.bookDAO = bookDAO;
        this.libraryService = libraryService;
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") Book book) {
        bookDAO.create(book);
        return "redirect:/books";
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("books", bookDAO.getAll());
        return "books/getAll";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.getById(id));
        if (bookDAO.getById(id).getPersonId() != null) {
            model.addAttribute("person", libraryService.getPersonById(bookDAO.getById(id).getPersonId()));
        } else {
            model.addAttribute("people", libraryService.getPersonList());
        }

        return "books/getById";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.getById(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute Book book) {
        bookDAO.update(id, book);
        return "redirect:/books";
    }

    @PostMapping("/{id}/return")
    public String returnBook(@PathVariable("id") int id) {
        bookDAO.returnBook(id);
        return "redirect:/books";
    }

    @PostMapping("/{id}/lend")
    public String lendBook(@PathVariable("id") int id, @ModelAttribute Book book) {
        System.out.println(book.getPersonId());
        bookDAO.lendBook(id, book.getPersonId());
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/people";
    }
}
