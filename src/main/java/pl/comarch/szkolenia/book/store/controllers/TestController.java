package pl.comarch.szkolenia.book.store.controllers;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.model.Order;
import pl.comarch.szkolenia.book.store.repository.IBookRepository;
import pl.comarch.szkolenia.book.store.repository.impl.hibernate.OrderDAO;

import java.util.Optional;

@Controller
public class TestController {
    @Autowired
    IBookRepository bookRepository;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    SessionFactory sessionFactory;

    @GetMapping(path = "/test1")
    public String test1() {
        Book book = new Book(0, "nowa ksiazka", "jakis autor", 500.0, 50);
        this.bookRepository.persist(book);
        this.bookRepository.persist(book);
        System.out.println(book);
        return "redirect:/contact";
    }
    @GetMapping(path = "/test2")
    public String test2() {
        Book book = this.bookRepository.getById(8).get();
        book.setAuthor("Janusz");
        this.bookRepository.update(book);
        return "redirect:/contact";
    }
    @GetMapping(path = "/test3")
    public String test3() {
        Book book = this.bookRepository.getById(10).get();
        this.bookRepository.remove(book);
        return "redirect:/contact";
    }

    @GetMapping(path = "/test4")
    public String test4() {
        Book book = this.bookRepository.getById(1).get();

        Order order = new Order(0, 345.34, book);
        this.orderDAO.persist(order);

        return "redirect:/contact";
    }

    @GetMapping(path = "/test5")
    public String test5() {
        Optional<Order> order = this.orderDAO.getById(1);

        System.out.println(order.get().getId());
        System.out.println(order.get().getTotal());
        System.out.println("Teraz chwile czekam");
        System.out.println(order.get().getBook());

        Book book = this.bookRepository.getById(1).get();
        System.out.println(book);

        System.out.println(book == order.get().getBook());

        /*Session session = this.sessionFactory.openSession();

        Query<Book> query = session.createQuery(
                "FROM pl.comarch.szkolenia.book.store.model.Book WHERE id = :id", Book.class);
        query.setParameter("id", 1);
        Book book = query.getSingleResult();

        Query<Order> query2 = session.createQuery(
                "FROM pl.comarch.szkolenia.book.store.model.Order WHERE id = :id",
                Order.class);
        query2.setParameter("id", 1);
        Order order = query2.getSingleResult();

        System.out.println(book);
        System.out.println(order.getBook());

        session.close();*/


        return "redirect:/contact";
    }

    @GetMapping(path = "/test6")
    public String test6() {
        Order order = new Order();
        order.setTotal(500.0);

        order.getBooks().add(new Book(0, "ksiazka 1", "jakis autor", 30.0, 10));
        order.getBooks().add(new Book(0, "ksiazka 2", "jakis inny autor", 50.0, 15));

        this.orderDAO.persist(order);
        return "redirect:/contact";
    }

    @GetMapping(path = "/test7")
    public String test7() {
        Order order = this.orderDAO.getById(1).get();
        System.out.println(order.getId());
        System.out.println(order.getTotal());
        System.out.println(order.getBooks());
        return "redirect:/contact";
    }
}
