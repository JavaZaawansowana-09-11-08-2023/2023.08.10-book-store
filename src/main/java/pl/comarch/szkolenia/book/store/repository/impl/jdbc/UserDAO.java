package pl.comarch.szkolenia.book.store.repository.impl.jdbc;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.comarch.szkolenia.book.store.model.User;
import pl.comarch.szkolenia.book.store.repository.IUserRepository;

import java.util.Optional;

@Repository
public class UserDAO implements IUserRepository {
    @Override
    public Optional<User> getByLogin(String login) {
        return Optional.empty();
    }
}
