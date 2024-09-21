import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>(InMemoryBooks.getBooks());
    private List<Author> authors = new ArrayList<>(InMemoryAuthors.geAuthors());
    private List<Rental> rentals = new ArrayList<>();

    public Library() {

    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        return books.stream().filter(book -> book.isAvailable()).toList();
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Rental rentBook(Integer bookId, String username) {
        var book = findBookById(bookId);
        findBook(book).rent();
        var rental = new Rental(book, username);
        rentals.add(rental);
        return rental;
    }

    public void createBook(Book book) {
        books.add(book);
        authors.add(book.getAuthor());
    }

    private Book findBook(Book book) throws RuntimeException {
        int indexOfBook = books.indexOf(book);

        if (indexOfBook == -1) {
            throw new RuntimeException("Livro não encontrado");
        }

        return books.get(indexOfBook);
    }

    private Book findBookById(Integer id) throws RuntimeException {
        var book = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        if (book == null) {
            throw new RuntimeException("Livro não encontrado");
        }
        return book;
    }

    private Rental findRental(Rental rental) throws RuntimeException {
        int indexOfRental = rentals.indexOf(rental);

        if (indexOfRental == -1) {
            throw new RuntimeException("Reserva não encontrado");
        }

        return rentals.get(indexOfRental);
    }
}
