package book;

public class Book {

    private String bookName;
    private String isbn;
    private String author;
    private boolean available;
    private String currentBorrower;

    public Book(String bookName, String isbn, String author, boolean available,String currentBorrower) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.available = available;
        this.currentBorrower = currentBorrower;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(String currentBorrower) {
        this.currentBorrower = currentBorrower;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isStatusInfo() {
        return available;
    }

    public void setStatusInfo(boolean statusInfo) {
        this.available = statusInfo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book Name: " + bookName + "\nISBN: " + isbn + "\nWriter: " + author + "\nAvailable: " + (available ? "Yes" : "No") + "\n";
    }
}

