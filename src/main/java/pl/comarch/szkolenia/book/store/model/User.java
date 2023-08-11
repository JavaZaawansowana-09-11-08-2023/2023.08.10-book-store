package pl.comarch.szkolenia.book.store.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "tuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    /*@Enumerated(value = EnumType.STRING)
    private Privilages privilages;*/
    /*@Transient
    private int cos;*/

    /*public enum Privilages {
        ADMIN,
        USER
    }*/
}
