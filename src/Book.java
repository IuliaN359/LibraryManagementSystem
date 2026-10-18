public class Book {
    private String title;
    private String author;
    private int price;
    private int numberOfPages;

    public Book(String title, String author, int price, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getAuthor() {
        return author;
    }
}
