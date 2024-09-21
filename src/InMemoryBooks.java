import java.util.List;

public class InMemoryBooks {

    private static final Author TOLKIEN = InMemoryAuthors.geAuthors().get(0);
    private static final Author ROWLING = InMemoryAuthors.geAuthors().get(1);

    static List<Book> books = List.of(
            new Book("The Hobbit", TOLKIEN),
            new Book("The Lord of the Rings", TOLKIEN),
            new Book("Harry Potter and the Philosopher's Stone", ROWLING)
    );

    public static List<Book> getBooks() {
        return books;
    }

    public static Book findById(Integer id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<Book> findAll() {
        return books;
    }
}
