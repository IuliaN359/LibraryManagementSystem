public class Main {
    public static void main() {
        Library library = new Library();
        library.add(new Book("Clean Code", "Robert Martin", 45, 464));
        library.add(new Book("1984", "George Orwell", 18, 328));
        library.add(new Book("Animal Farm", "George Orwell", 12, 112));
        library.add(new Book("Java Basics", "Max Müller", 35, 520));
        library.add(new Book("The Hobbit", "J. R. R. Tolkien", 28, 310));
    }
}