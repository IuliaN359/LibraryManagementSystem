import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void add(Book book) {
        books.add(book);
    }

    public List<String> authorsBooks(String author){
        List<String> authorsBooks = new ArrayList<>();
        for (Book book : books){
            if (Objects.equals(book.getAuthor(), author)){
                authorsBooks.add(book.getTitle());
            }
        }
        return authorsBooks;
    }


}