package pl.comarch.szkolenia.book.store.repository.impl.hibernate;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.comarch.szkolenia.book.store.model.User;
import pl.comarch.szkolenia.book.store.repository.IUserRepository;

import java.util.Optional;

@Repository
public class UserDAO implements IUserRepository {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Optional<User> getByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery(
                "FROM pl.comarch.szkolenia.book.store.model.User WHERE login = :login", User.class);
        query.setParameter("login", login);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            session.close();
        }
    }
}
