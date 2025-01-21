package book;

import mertay.exceptionsclasses.Child_Book_Not_Available_Ex;
import mertay.exceptionsclasses.Child_Book_Not_Found_Ex;
import person.Member;

import java.util.*;

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

    public static Map<String, Book> books = new HashMap<>();

    public static void main(String[] args) {
        BookService bookService = new BookService();

        Book book1 = new Book("Rich dad poor dad","Robert Kiyosaki",true,"");
        Book book2 = new Book("Smart investment","Benjamin Graham",true,"");
        Book book3 = new Book("Why we want to be rich","Donald Trump",true,"");
        Book book4 = new Book("Dağın öte yüzü üçlemesi","Yaşar kemal",false,"");
        Book book5 = new Book("Yaşar ne yaşar ne yaşamaz","Aziz nesin",false,"");
        Book book6 = new Book("Alemdağ'da var bir yılan","Sait faik abasıyanık",true,"");
        Book book7 = new Book("Günlerin getirdiği"," Nurullah ataç",true,"");

        /**
         * We are added 7 books here with addBook Methods in private HashMap
         */
        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);
        //bookService.addBook(book5); //Same isbn code with book1 so it can be throw exception with the runtime.
        //bookService.addBook(book6); //null isbn code will cause it can be throw exception with the runtime.
        bookService.addBook(book7);

        /**
         * We are called remove method and delete book7
         * we will encounter some problem when we will call isbn 10.
         */
        bookService.removeBook("7"); // isbn code will delete book7.
        //bookService.removeBook("10"); // isbn code will not delete book because don't have this number so it will be throwing runtime exception.


        //bookService.updateBook("1",book4);// Normally ıd one is Rich dad poor dad

        bookService.findBook("10");//return the book with number of book this method have return type don't need sout.


        //bookService.getAllBooks();//This method write to all books wit the for each loop in the map ı modifed to string method in the Book class

        bookService.isBookAvailable("10");//this method show us which book is avaiable for using

        bookService.searchBooks("Rich dad poor dad");

    }




    /**
     * (First if) code block is control checking is there a null value,
     * it does not add it and throws an error check the valid and useful book information.
     * (Second if)code block is checking same ISBN if same throw already exist.
     * (Third else) one is if everything is unique and has valid value and key added successfully.
     * @param book
     */
    @Override
    public void addBook(Book book) {

        System.out.println("book detayı " + book);
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
     * (first if) is checking ID in terms of null or empty unless is it throw expception
     * (Second if) is control the book value is null throw excepciton
     * (Switch case) is on condition that contains isbn same update book but don't have it throw exception we use lambda with switch
     * @param ID
     * @param updatedBook
     */
    @Override

    public void updateBook(String ID, Book updatedBook) {
        if (ID == null || ID.isEmpty()) {
            throw new Child_Book_Not_Found_Ex("ISBN cannot be null or empty.");
        }

        if (updatedBook == null) {

            throw new Child_Book_Not_Available_Ex("Updated book cannot be null.");

        }
        if (books.containsKey(ID)) {
            books.put(ID, updatedBook);
            System.out.println("Book with ISBN " + ID + " has been updated successfully.");
        } else {
            throw new Child_Book_Not_Available_Ex("No book found with ISBN " + ID + ". Update failed.");
        }

    }

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
    }

    @Override
    public Map<String, Book> getAllBooks() {
       for (Map.Entry<String, Book> entry : books.entrySet()) {
           System.out.println("ID: " + entry.getKey());
           System.out.println(entry.getValue());
           System.out.println("------------------------------");
       }
        return books;
    }

    @Override
    public boolean isBookAvailable(String isbn) {

        Book foundBook1 = books.get(isbn);

        if (foundBook1 == null) {
            throw new Child_Book_Not_Available_Ex("No book found with ISBN: " + isbn);
        } else {
            System.out.println("Book situation is : " + foundBook1.isAvailable());
        }
        return foundBook1.isAvailable();
    }

    @Override
    public Map<String, Book> searchBooks(String bookName) {

        Map<String, Book> foundBooks = new HashMap<>();

        Book foundBook = books.get(bookName);

        if (foundBook != null) {

        }
        System.out.println(foundBook);
        return  foundBooks;


    }
}
