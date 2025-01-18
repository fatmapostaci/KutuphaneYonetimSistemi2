package book;

import java.util.HashMap;
import java.util.Map;

class Book {

    private String bookName;
    private String isbn;
    private String author;
    private boolean statusInfo;

    public Book(String bookName, String isbn, String author, boolean statusInfo) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.statusInfo = statusInfo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(boolean statusInfo) {
        this.statusInfo = statusInfo;
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
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", writer='" + author + '\'' +
                ", statusInfo=" + statusInfo +
                '}';
    }
}

