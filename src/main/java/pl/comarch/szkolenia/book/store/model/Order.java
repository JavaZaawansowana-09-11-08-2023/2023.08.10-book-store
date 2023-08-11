package pl.comarch.szkolenia.book.store.model;

import jakarta.persistence.*;
import lombok.*;
import org.yaml.snakeyaml.events.Event;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "torder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double total;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public Order(int id, double total, Book book) {
        this.id = id;
        this.total = total;
        this.books.add(book);
    }

    public Book getBook() {
        return null;
    }
}
