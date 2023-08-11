package pl.comarch.szkolenia.book.store;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.client.RestTemplate;
import pl.comarch.szkolenia.book.store.model.User;

import java.util.HashMap;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("janusz"));

        RestTemplate restTemplate = new RestTemplate();

        User user = restTemplate
                .getForObject("http://localhost:8080/", User.class, new HashMap<>());

        //restTemplate.exchange()
    }
}
