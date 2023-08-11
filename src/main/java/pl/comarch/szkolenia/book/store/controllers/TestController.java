package pl.comarch.szkolenia.book.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.repository.IBookRepository;

@Controller
public class TestController {
    @Autowired
    IBookRepository bookRepository;

    @GetMapping(path = "/test1")
    public String test1() {
        Book book = new Book(0, "jakis tytul", "jakis autor", 500.0, 50);
        this.bookRepository.persist(book);
        System.out.println(book);
        return "redirect:/contact";
    }
    @GetMapping(path = "/test2")
    public String test2() {
        Book book = this.bookRepository.getById(7).get();
        book.setAuthor("nowy autor");
        this.bookRepository.update(book);
        return "redirect:/contact";
    }
    @GetMapping(path = "/test3")
    public String test3() {
        Book book = this.bookRepository.getById(7).get();
        this.bookRepository.remove(book);
        return "redirect:/contact";
    }
}
