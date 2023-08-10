package pl.comarch.szkolenia.book.store.services;

import pl.comarch.szkolenia.book.store.model.Book;
import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    List<Book> getBooksByPattern(String pattern);
}
