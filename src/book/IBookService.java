package book;

public interface IBookService {

        /*
    Kitap ekleme, silme, güncelleme ve arama işlemlerini uygula.
ArrayList veya HashMap kullanarak kitap verilerini sakla.
     */

    void addBook(Book book);
    void removeBook(String isbn);
    void updateBook(String isbn, Book updatedBook);
    Book findBook(String isbn);
}
