package pl.comarch.szkolenia.book.store.controllers;

import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.comarch.szkolenia.book.store.exceptions.UserValidationException;
import pl.comarch.szkolenia.book.store.services.IAuthenticator;
import pl.comarch.szkolenia.book.store.session.SessionObject;
import pl.comarch.szkolenia.book.store.validators.UserValidator;

@Controller
@Log4j2
public class AuthenticationController {
    @Autowired
    IAuthenticator authenticator;

    @Resource
    SessionObject sessionObject;

    @GetMapping(path = "/login")
    public String login(Model model) {
        //model.addAttribute("logged", this.sessionObject.isLogged());
        return "login";
    }

    @PostMapping(path = "/login")
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        try {
            UserValidator.validateLogin(login);
        } catch (UserValidationException e) {
            return "redirect:/login";
        }
        this.authenticator.authenticate(login, password);
        if(sessionObject.isLogged()) {
            return "redirect:/main";
        }
        return "redirect:/login";
    }

    @GetMapping(path = "/logout")
    public String logout() {
        this.authenticator.logout();
        return "redirect:/main";
    }
}
