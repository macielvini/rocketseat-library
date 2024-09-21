import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Book {

    private final Integer id;
    private final String title;
    private final Author author;
    private Boolean isAvailable;
    private final LocalDate createdAt;
    private LocalDate updatedAt;

    public Book(String title, Author author) {
        this.id = new Random().nextInt(999) + 1;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
        this.updatedAt = LocalDate.now();
    }


    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("%-36.36s | %-40.40s | %-20.20s", id, title, author.getName());
    }
}
