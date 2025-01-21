package book;

public class Book {

    private String bookName;
    private final String isbn;
    private String author;
    private boolean available;
    private String currentBorrower;
    private static int isbnCounter=10000;

    public Book(String bookName, String author, boolean available,String currentBorrower) {
        this.bookName = bookName;
        this.isbn = "ISBN"+isbnCounter;   //ISBN10001,ISBN10002
        this.author = author;
        this.available = available;
        this.currentBorrower = currentBorrower;
        isbnCounter++;
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

    @Override
    public String toString() {
        return "Book Name: " + bookName + "\nISBN: " + isbn + "\nAuthor: " + author +
                "\nAvailable: " + (available ? "Yes" : "No") + "\nCurrent Borrower: " + (currentBorrower.equals("") ? "Ödünç alınmadı" : currentBorrower)  +"\n";

    }

}

