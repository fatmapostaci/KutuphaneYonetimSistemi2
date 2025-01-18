package book;

class Book {

    private String bookName;
    private String isbn;
    private String writer;
    private boolean statusInfo;

    public Book(String bookName, String isbn, String writer, boolean statusInfo) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.writer = writer;
        this.statusInfo = statusInfo;
    }

    public String getBookName() {

        System.out.println("deneme");
        int fatma;
        fatma=4;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
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
                ", writer='" + writer + '\'' +
                ", statusInfo=" + statusInfo +
                '}';
    }
}
//Mertay
