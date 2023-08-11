package pl.comarch.szkolenia.book.store.repository.impl;

import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.repository.IBookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository implements IBookRepository {

    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        this.books.add(new Book(1, "Tytul 1", "autor 1", 40.00, 10));
        this.books.add(new Book(2, "Tytul 2", "autor 2", 50.00, 10));
        this.books.add(new Book(3, "Tytul 3", "autor 3", 70.00, 10));
        this.books.add(new Book(4, "Tytul 4", "autor 4", 80.00, 10));
        this.books.add(new Book(5, "Tytul 5", "autor 5", 90.00, 10));
    }

    @Override
    public List<Book> getAll() {
        return this.books;
    }

    @Override
    public Optional<Book> getById(final int id) {
        return this.books.stream().filter(b -> b.getId() == id).findFirst();
    }

    @Override
    public List<Book> getByPattern(final String pattern) {
        return this.books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(pattern.toLowerCase()))
                .filter(b -> b.getAuthor().toLowerCase().contains(pattern.toLowerCase()))
                .toList();
    }

    @Override
    public void persist(Book book) {
        throw new RuntimeException();
    }

    @Override
    public void update(Book book) {
        throw new RuntimeException();
    }

    @Override
    public void remove(Book book) {
        throw new RuntimeException();
    }
}
