import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public Library() {
        books = new ArrayList<>();
    }

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> authorsBooks(String author) {
        List<Book> authorsBooks = new ArrayList<>();
        for (Book book : books) {
            if (Objects.equals(book.getAuthor(), author)) {
                authorsBooks.add(book);
            }
        }
        return authorsBooks;
    }

    public double averagePageNumber(List<Book> bookList) {
        if (bookList.isEmpty())
            return 0.0;
        int pagesSum = 0;
        for (Book book : bookList) {
                pagesSum += book.getNumberOfPages();
        }
        double average = (double) pagesSum / bookList.size();
        return Math.round(average * 100.0) / 100.0;
    }

    public List<Book> filterBooksByPrice(List<Book> bookList, int price) {
        List<Book> withinPrice = new ArrayList<>();
        if(bookList==null){
            return withinPrice;
        }
        for (Book book : bookList) {
            if (book.getPrice() <= price) {
                withinPrice.add(book);
            }
        }
        return withinPrice;
    }

    public Book mostExpensive(List<Book> bookList) {
        if (bookList.isEmpty()){
            return null;
        }
        Book mostExpensiveBook=bookList.get(0);
        for(int i=1;i<bookList.size();i++){
            Book current =bookList.get(i);
            if(current.getPrice()>mostExpensiveBook.getPrice()){
                mostExpensiveBook=current;
            }
        }
        return mostExpensiveBook;
    }

    public List<Book> minimumNumberOfPages(List<Book> bookList, int numberOfPages) {
        List<Book> withMinimumPages=new ArrayList<>();
        if(bookList==null){
            return withMinimumPages;
        }
        for (Book book : bookList) {
            if (book.getNumberOfPages() >= numberOfPages) {
                withMinimumPages.add(book);
            }
        }
        return withMinimumPages;
    }

    public List<Book> validBooks(List<Book> bookList, int price) {
        List<Book> chosenBooks=new ArrayList<>();
        if(bookList==null || bookList.size()<2)
            return chosenBooks;
        Book firstBook=null;
        Book secondBook=null;
        int max = -1;
        for (int i = 0; i < bookList.size() - 1; i++) {
            for (int j = i + 1; j < bookList.size(); j++) {
                int sum = bookList.get(i).getPrice() + bookList.get(j).getPrice();
                if (sum <= price) {
                    if (firstBook==null || sum > max || ( sum == max && firstBook.getNumberOfPages() + secondBook.getNumberOfPages() < bookList.get(i).getNumberOfPages() + bookList.get(j).getNumberOfPages())) {
                        max = sum;
                        firstBook=bookList.get(i);
                        secondBook=bookList.get(j);
                    }
                }
            }
        }
        if(firstBook!=null && secondBook!=null){
            chosenBooks.add(firstBook);
            chosenBooks.add(secondBook);
        }
        return chosenBooks;
    }
}