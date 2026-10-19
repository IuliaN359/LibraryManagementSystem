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
            System.out.println("------ Menue ------");
            System.out.println("1. Buecher eines Autors");
            System.out.println("2. Durchschnittliche Seitenanzahl");
            System.out.println("3. Buecher innerhalb eines Preislimits");
            System.out.println("4. Teuerstes Buch");
            System.out.println("5. Buecher mit einer Mindestseitenanzahl");
            System.out.println("6. Zwei Buecher innerhalb eines Budgets");
            System.out.println("0. Exit");
            System.out.print("Option waehlen: ");

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
                    List<Book> selectedBooks = readRows("Buchtitel fuer die durchschnittliche Seitenanzahl eingeben: ", scanner, library);
                    System.out.println(library.averagePageNumber(selectedBooks));
                    break;
                case 3:
                    System.out.print("Maximaler Preis: ");
                    String input = scanner.nextLine();
                    int price = Integer.parseInt(input.replaceAll("[^0-9]", ""));
                    for (Book book : library.filterBooksByPrice(library.getBooks(), price)) {
                        System.out.println(book.getTitle());
                    }
                    break;
                case 4:
                    selectedBooks=readRows("Buchtitel eingeben, um das teuerste Buch zu finden: ", scanner, library);
                    Book mostExpensiveBook=library.mostExpensiveBook(selectedBooks);
                    if(mostExpensiveBook!=null){
                        System.out.println(mostExpensiveBook.getTitle());
                    }
                    else{
                        System.out.println("null");
                    }
                    break;
                case 5:
                    System.out.print("Mindestseitenanzahl: ");
                    input=scanner.nextLine();
                    int numberOfPages = Integer.parseInt(input.replaceAll("[^0-9]", ""));
                    for (Book book : library.withMinimumNumberOfPages(library.getBooks(), numberOfPages)) {
                        System.out.println(book.getTitle());
                    }
                    break;
                case 6:
                    System.out.print("Budget: ");
                    input = scanner.nextLine();
                    price = Integer.parseInt(input.replaceAll("[^0-9]", ""));
                    List<Book> bookList = library.validBooks(library.getBooks(), price);
                    if(bookList.size()>=2) {
                        int sum = bookList.get(0).getPrice() + bookList.get(1).getPrice();
                        System.out.println(bookList.get(0).getTitle() + " + " + bookList.get(1).getTitle() + "\nGesamtpreis: " + sum + " Euro\n");
                    }
                    else{
                        System.out.println("Keine zwei passenden Buecher innerhalb des Budgets gefunden");
                    }
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Ungueltige Eingabe");
            }
        }
        scanner.close();
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