import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Author {

    private final Integer id;
    private final String name;
    private final LocalDate birthDate;

    public Author(String name, LocalDate birthDate) {
        this.id = new Random().nextInt(999) + 1;
        ;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
