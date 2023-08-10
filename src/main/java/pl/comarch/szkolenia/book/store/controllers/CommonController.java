package pl.comarch.szkolenia.book.store.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.repository.IBookRepository;
import pl.comarch.szkolenia.book.store.services.IBookService;
import pl.comarch.szkolenia.book.store.session.SessionObject;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    private IBookService bookService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(path = {"/", "/main"}, method = RequestMethod.GET)
    public String main(Model model, @RequestParam(required = false) String pattern) {
        if(pattern == null) {
            model.addAttribute("books", this.bookService.getAllBooks());
        } else {
            model.addAttribute("books", this.bookService.getBooksByPattern(pattern));
        }
        //model.addAttribute("logged", this.sessionObject.isLogged());
        return "main";
    }

    @GetMapping(path = "/contact")
    public String contact(Model model) {
        //model.addAttribute("logged", this.sessionObject.isLogged());
        return "contact";
    }
}
