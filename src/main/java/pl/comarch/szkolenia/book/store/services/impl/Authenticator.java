package pl.comarch.szkolenia.book.store.services.impl;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.comarch.szkolenia.book.store.model.User;
import pl.comarch.szkolenia.book.store.repository.IUserRepository;
import pl.comarch.szkolenia.book.store.services.IAuthenticator;
import pl.comarch.szkolenia.book.store.session.SessionObject;

import java.util.Optional;

@Service
public class Authenticator implements IAuthenticator {

    @Autowired
    private IUserRepository userRepository;

    @Resource
    private SessionObject sessionObject;
    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = this.userRepository.getByLogin(login);
        if(userBox.isPresent() && userBox.get().getPassword().equals(DigestUtils.md5Hex(password))) {
            this.sessionObject.setLogged(true);
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setLogged(false);
    }
}
