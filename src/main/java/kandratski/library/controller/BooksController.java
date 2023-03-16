package kandratski.library.controller;

import kandratski.library.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final BookDAO bookDAO;

    @Autowired
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("books", bookDAO.getAll());
        return "books/getAll";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.getById(id));
        return "books/getById";
    }
}
