package book;

import mertay.exceptionsclasses.Child_Book_Not_Available_Ex;
import mertay.exceptionsclasses.Child_Book_Not_Found_Ex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService implements IBookService {
    /*
    ### Adım 4: Sistem Fonksiyonları
- Kitap ekleme/silme/güncelleme

- Kitap ödünç alma/iade etme
- Kitap arama

     #### BookService
- IBookService interface'ini implement eder
- Kitap verilerini ArrayList veya HashMap'te saklar
- CRUD operasyonlarını yönetir
- Kitap arama ve filtreleme işlemlerini gerçekleştirir
     */

    private Map<String, Book> books = new HashMap<>();

    /**
     * (First if) code block is control checking is there a null value,
     * it does not add it and throws an error check the valid and useful book information.
     * (Second if)code block is checking same ISBN if same throw already exist.
     * (Third else) one is if everything is unique and has valid value and key added successfully.
     * @param book
     */
    @Override
    public void addBook(Book book) {

        if (book == null || book.getIsbn() == null || book.getIsbn().isEmpty()) {
            throw new Child_Book_Not_Available_Ex("Book or ISBN cannot be null/empty.");
        }
        if (books.containsKey(book.getIsbn())) {
            throw new Child_Book_Not_Available_Ex("Book with ISBN " + book.getIsbn() + " already exists.");
        } else {
            books.put(book.getIsbn(), book);
            System.out.println("Book with ISBN " + book.getIsbn() + " added successfully.");
        }

    }

    /**
     * (First if) is checking isbn value null or empty everything is useful continue or not throw something.
     * (Second if) controlof the isbn number is same or no if not throw something
     * @param isbn
     */
    @Override
    public void removeBook(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new Child_Book_Not_Available_Ex("ISBN cannot be null or empty.");
        }

        if (books.containsKey(isbn)) {
            books.remove(isbn);
            System.out.println("Book with ISBN " + isbn + " has been removed successfully.");
        } else {
            throw new Child_Book_Not_Found_Ex("No book found with ISBN " + isbn + ".");
        }

    }

    /**
     * (first if) is checking isbn in terms of null or empty unless is it throw expception
     * (Second if) is control the book value is null throw excepciton
     * (Switch case) is on condition that contains isbn same update book but don't have it throw exception we use lambda with switch
     * @param isbn
     * @param updatedBook
     */
    @Override

    public void updateBook(String isbn, Book updatedBook) {
        if (isbn == null || isbn.isEmpty()) {
            throw new Child_Book_Not_Found_Ex("ISBN cannot be null or empty.");
        }

        if (updatedBook == null) {
            throw new Child_Book_Not_Available_Ex("Updated book cannot be null.");
        }

    }
/*
    @Override
    public void updateBook(String isbn, Book book) {

        switch (books.containsKey(isbn)) {
            case true -> {
                books.put(isbn, updatedBook);
                System.out.println("Book with ISBN " + isbn + " has been updated successfully.");
            }
            case false -> throw new Child_Book_Not_Available_Ex("No book found with ISBN " + isbn + ". Update failed.");
        }
    }
*/
    /**
     * (first if)  the ISBN is invalid (null or empty), an IllegalArgumentException is thrown.
     * (Second if) not assigned .get isbn to foundbook it turns null and throw the exception
     * @param isbn
     * @return
     */
    @Override

    public Book findBook(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new Child_Book_Not_Available_Ex("ISBN cannot be null or empty.");
        }

        Book foundBook = books.get(isbn);

        if (foundBook == null) {
            throw new Child_Book_Not_Available_Ex("No book found with ISBN: " + isbn);
        } else {
            System.out.println("Book found: " + foundBook.getBookName());
        }

        return foundBook;

    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public boolean isBookAvailable(String isbn) {
        return false;
    }

    @Override
    public List<Book> searchBooks(String keyword) {
        return List.of();

    }
}
