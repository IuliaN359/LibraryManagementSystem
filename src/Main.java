import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main() {
        Library library = new Library();
        library.add(new Book("Clean Code", "Robert Martin", 45, 464));
        library.add(new Book("1984", "George Orwell", 18, 328));
        library.add(new Book("Animal Farm", "George Orwell", 12, 112));
        library.add(new Book("Java Basics", "Max Müller", 35, 520));
        library.add(new Book("The Hobbit", "J. R. R. Tolkien", 28, 310));
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while (run) {

            System.out.println("------Menu------");
            System.out.println("1. All books of a certain author");
            System.out.println("2. Average number of pages");
            System.out.println("3. All books in a certain price range");
            System.out.println("4. The most expensive book");
            System.out.println("5. Books with a given minimum number of pages");
            System.out.println("6. 2 books that fit the budget of a client");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    for (String title : library.authorsBooks(author)) {
                        System.out.println(title);
                    }
                    break;
                case 2:
                    List<String> titles = new ArrayList<>();
                    while (true) {
                        String text = scanner.nextLine();
                        if (text.isEmpty()) {
                            break;
                        }
                        titles.add(text);
                    }
                    System.out.println(library.averagePageNumber(titles));
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }
}