import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                    System.out.print("Autor: ");
                    String author = scanner.nextLine();
                    for (Book book : library.authorsBooks(author)) {
                        System.out.println(book.getTitle());
                    }
                    break;
                case 2:
                    List<Book> selectedBooks = readRows("Enter books for the average number of pages", scanner, library);
                    System.out.println(library.averagePageNumber(selectedBooks));
                    break;
                case 3:
                    System.out.print("Maximum price: ");
                    int price = scanner.nextInt();
                    for (Book book : library.filterBooksByPrice(library.getBooks(), price)) {
                        System.out.println(book.getTitle());
                    }
                    break;
                case 4:
                    selectedBooks=readRows("Enter books to find the most expensive one", scanner, library);
                    Book mostExpensiveBook=library.mostExpensive(selectedBooks);
                    if(mostExpensiveBook!=null){
                        System.out.println(mostExpensiveBook.getTitle());
                    }
                    else{
                        System.out.println("null");
                    }
                    break;
                case 5:
                    System.out.print("Minimal number: ");
                    int numberOfPages = scanner.nextInt();
                    for (Book book : library.minimumNumberOfPages(library.getBooks(), numberOfPages)) {
                        System.out.println(book.getTitle());
                    }
                    break;
                case 6:
                    System.out.print("Budget: ");
                    price = scanner.nextInt();
                    List<Book> array = library.validBooks(library.getBooks(), price);
                    if(array.size()>=2) {
                        int sum = array.get(0).getPrice() + array.get(1).getPrice();
                        System.out.println(array.get(0).getTitle() + " + " + array.get(1).getTitle() + "\nGesamtpreis: " + sum + " Euro\n");
                    }
                    else{
                        System.out.println("No two books found within the budget");
                    }
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
     public static List<Book> readRows(String msg, Scanner scanner, Library library){
         System.out.println(msg);
         List <Book> selectedBooks=new ArrayList<>();
         while (true) {
             String text = scanner.nextLine();
             if (text.isEmpty()) {
                 break;
             }
             for(Book book: library.getBooks()){
                 if(book.getTitle().equals(text)){
                     selectedBooks.add(book);
                     break;
                 }
             }
         }
         return selectedBooks;
     }
}