package pl.comarch.szkolenia.book.store.repository.impl.hibernate;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.comarch.szkolenia.book.store.model.Order;

import java.util.Optional;

@Repository
public class OrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void persist(Order order) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public Optional<Order> getById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Order> query = session.createQuery(
                "FROM pl.comarch.szkolenia.book.store.model.Order WHERE id = :id",
                Order.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            //session.close();
        }
    }
}
