package pl.comarch.szkolenia.book.store.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.comarch.szkolenia.book.store.model.User;

@RestController
@RequestMapping(path = "/api")
public class TestRestController {
    @GetMapping(path = "/test1")
    public User getUser() {
        User user = new User();
        user.setId(10);
        user.setLogin("wiesiek");
        user.setPassword("wiesiek1");

        return user;
    }

    @PostMapping(path = "/test2")
    public User test2(@RequestBody User user) {
        //logika
        System.out.println(user);
        user.setId(100);
        return user;
    }

    @PostMapping(path = "/test3/{id}")
    public User test3(@RequestBody User user,
                      @PathVariable int id,
                      @RequestParam String param1,
                      @RequestParam String param2,
                      @RequestHeader("cos") String h1) {
        System.out.println(user);
        System.out.println(id);
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(h1);

        return new User();
    }

    @GetMapping(path = "/test4")
    public ResponseEntity<User> test4() {
        User user = new User(17, "waldek", "tajnehaslo");

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Content-Type", "application/xml")
                .header("n2", "header2")
                .body(user);
    }
}
