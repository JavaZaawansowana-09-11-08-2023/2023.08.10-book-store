package pl.comarch.szkolenia.book.store.repository.impl;

import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.book.store.model.User;
import pl.comarch.szkolenia.book.store.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User(1, "admin", "21232f297a57a5a743894a0e4a801fc3"));
        this.users.add(new User(2, "janusz", "087d9c5e13bdd64a82bef8e013625c32"));
    }

    @Override
    public Optional<User> getByLogin(final String login) {
        return this.users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
    }
}
