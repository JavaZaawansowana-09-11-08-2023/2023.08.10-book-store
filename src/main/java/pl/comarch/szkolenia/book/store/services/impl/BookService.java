package pl.comarch.szkolenia.book.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.repository.IBookRepository;
import pl.comarch.szkolenia.book.store.services.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.getAll();
    }

    @Override
    public List<Book> getBooksByPattern(String pattern) {
        //?????
        return this.bookRepository.getByPattern(pattern);
    }
}
