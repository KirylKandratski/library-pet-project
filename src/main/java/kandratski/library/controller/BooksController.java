package kandratski.library.controller;

import kandratski.library.entity.Book;
import kandratski.library.service.BooksService;
import kandratski.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final LibraryService libraryService;
    private final BooksService booksService;

    @Autowired
    public BooksController(LibraryService libraryService, BooksService booksService) {
        this.libraryService = libraryService;
        this.booksService = booksService;
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }
        booksService.save(book);
        return "redirect:/books";
    }

    @GetMapping()
    public String getAll(@RequestParam(name = "page", defaultValue = "1") int page,
                         @RequestParam(name = "size", defaultValue = "10") int size,
                         @RequestParam(name = "sort", defaultValue = "name") String sort,
                         Model model) {

        Page<Book> bookPage = booksService.findAll(PageRequest.of(page, size, Sort.by(sort)));

        model.addAttribute("books", bookPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("sort", sort);
        model.addAttribute("totalPages", bookPage.getTotalPages());

        return "books/getAll";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {

        model.addAttribute("book", booksService.findById(id));

        if (booksService.findById(id).getPersonId() != null) {
            model.addAttribute("person", libraryService.getPersonById(booksService.findById(id).getPersonId()));
        } else {
            model.addAttribute("people", libraryService.getPersonList());
        }

        return "books/getById";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {

        model.addAttribute("book", booksService.findById(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }

        booksService.update(id, book);
        return "redirect:/books";
    }

    @PostMapping("/{id}/return")
    public String returnBook(@PathVariable("id") int id) {

        booksService.returnBook(id);
        return "redirect:/books";
    }

    @PostMapping("/{id}/lend")
    public String lendBook(@PathVariable("id") int id, @ModelAttribute Book book) {

        booksService.lendBook(book.getPersonId(), id);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {

        booksService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "searchTerm", defaultValue = "") String searchTerm,
                         Model model) {

        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return "books/search";
        }

        Book book = booksService.findByName(searchTerm);
        model.addAttribute("book", book);

        if (book.getPersonId() != null) {
            model.addAttribute("person", libraryService.getPersonById(book.getPersonId()));
        }

        return "books/search";
    }
}
