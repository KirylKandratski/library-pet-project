package kandratski.library.controller;

import kandratski.library.dao.PersonDAO;
import kandratski.library.models.Person;
import kandratski.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;
    private final LibraryService libraryService;

    @Autowired
    public PeopleController(PersonDAO personDAO, LibraryService libraryService) {
        this.personDAO = personDAO;
        this.libraryService = libraryService;
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personDAO.create(person);
        return "redirect:/people";
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("people", personDAO.getAll());
        return "people/getAll";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.getById(id));
        model.addAttribute("bookList", libraryService.getBooksByPersonId(id));
        return "people/getById";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.getById(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute Person person) {
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }


}
