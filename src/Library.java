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

    public double averagePageNumber(List<String> titles){
        if (titles.isEmpty())
            return 0.0;
        int pagesSum=0;
        for (Book book : books){
            if (titles.contains(book.getTitle())){
                pagesSum+= book.getNumberOfPages();
            }
        }
        double average=(double)pagesSum/titles.size();
        return Math.round(average*100.0)/100.0;
    }

    public List<String> filterBooks(double price){
        List<String> withinPrice=new ArrayList<>();
        for (Book book : books){
            if (book.getPrice()<=price){
                withinPrice.add(book.getTitle());
            }
        }
        return withinPrice;
    }

    public String mostExpensive(List<String> titles){
        double max=0;
        String title = "";
        for (Book book : books){
            if(titles.contains(book.getTitle())){
                if(book.getPrice()>max){
                    max=book.getPrice();
                    title=book.getTitle();
                }
            }
        }
        return title;
    }

}