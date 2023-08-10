package pl.comarch.szkolenia.book.store.validators;

import pl.comarch.szkolenia.book.store.exceptions.UserValidationException;

public class UserValidator {
    public static void validateLogin(String login) {
        String regex = ".{4,}";
        if(!login.matches(regex)) {
            throw new UserValidationException();
        }
    }
}
