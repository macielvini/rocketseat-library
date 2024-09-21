import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final Library library = new Library();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Bem-vindo(a) à biblioteca Rocket, selecione uma opção:");
        int option;
        do {
            option = displayMainMenu(scanner);
        } while (option != 0);

    }


    private static int displayMainMenu(Scanner scanner) {
        System.out.println("\n0 - Sair | 1 - Listar livros - 2 Alugar um livro - 3 Adicionar um novo livro");
        int option = scanner.nextInt();
        switch (option) {
            case 0:
                return 0;
            case 1:
                displayAvailableBooks();
                return 1;
            case 2:
                rentBook(scanner);
                return 2;
            case 3:
                createBook(scanner);
                return 3;
            default:
                return option;
        }
    }

    private static void displayAvailableBooks() {
        System.out.printf("%-36.36s | %-40.40s | %-20.20s%n", "ID", "Título", "Autor");
        System.out.printf("%-36.36s | %-40.40s | %-20.20s%n", "-".repeat(36), "-".repeat(40), "-".repeat(20));
        library
                .getAvailableBooks()
                .forEach(book -> System.out.println(book.toString()));

    }

    private static void rentBook(Scanner scanner) {
        System.out.println("Qual o ID do livro que deseja alugar?");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Qual o nome do leitor?");
        String username = scanner.nextLine();

        var rental = library.rentBook(bookId, username);

        System.out.printf("Locação realizada com sucesso! Leitor: %s - Livro: %s", rental.getUsername(), rental.getBook().getTitle());
    }

    private static void createBook(Scanner scanner) {
        scanner.nextLine();

        System.out.println("Qual o nome do livro?");
        String title = scanner.nextLine();

        System.out.println("Qual o nome do autor?");
        String author = scanner.nextLine();

        System.out.println("Qual a data de nascimento do autor? (DD/MM/AAAA)");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        var book = new Book(title, new Author(author, birthDate));
        library.createBook(book);

        System.out.println("Livro adicionado com sucesso!");
    }

}
