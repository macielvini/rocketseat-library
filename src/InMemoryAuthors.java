import java.time.LocalDate;
import java.util.List;

public class InMemoryAuthors {

    static List<Author> authors = List.of(
            new Author("J.R.R. Tolkien", LocalDate.of(1892, 8, 21)),
            new Author("J.K. Rowling", LocalDate.of(1965, 7, 31))
    );


    public static Author findById(Integer id) {
        return authors
                .stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Author> geAuthors() {
        return authors;
    }
}
