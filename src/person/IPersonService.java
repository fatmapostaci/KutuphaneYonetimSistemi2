package person;

import java.awt.print.Book;

public interface IPersonService {

    /*
    IPersonService interface'ini implement et.
Üye ekleme, silme, güncelleme işlemlerini uygula.
Kitap ödünç alma ve iade etme işlemlerini yönet.
     */

    void addBook(Book book);
    void removeBook(String isbn);
    void updateBook(String isbn, Book updatedBook);
    Book findBook(String isbn);
}
