package pl.comarch.szkolenia.book.store.services;

public interface IAuthenticator {
    void authenticate(String login, String password);
    void logout();
}
