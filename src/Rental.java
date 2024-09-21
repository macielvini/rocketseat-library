import java.util.Objects;
import java.util.Random;

public class Rental {

    private final Integer id;
    private final Book book;
    private final String username;

    public Rental(Book book, String name) {
        this.id = new Random().nextInt(999) + 1;
        this.book = book;
        this.username = name;
    }

    public Integer getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
