package pl.comarch.szkolenia.book.store.repository.impl.hibernate;

import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.repository.IBookRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDAO implements IBookRepository {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Book> getAll() {
        Session session = this.sessionFactory.openSession();
        Query<Book> query = session.createQuery("FROM pl.comarch.szkolenia.book.store.model.Book", Book.class);
        List<Book> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Optional<Book> getById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Book> query = session.createQuery(
                "FROM pl.comarch.szkolenia.book.store.model.Book WHERE id = :id", Book.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Book> getByPattern(String pattern) {
        Session session = this.sessionFactory.openSession();
        Query<Book> query = session.createQuery(
                "FROM pl.comarch.szkolenia.book.store.model.Book WHERE title LIKE :pattern OR author LIKE :pattern", Book.class);
        query.setParameter("pattern", "%"+pattern+"%");
        List<Book> books = query.getResultList();
        session.close();
        return books;
    }

    @Override
    public void persist(Book book) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Book book) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.merge(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(Book book) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.remove(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
