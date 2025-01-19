package book;

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


    @Override
    public void addBook(Book book) {

    }

    @Override
    public void removeBook(String isbn) {

    }

    @Override
    public Book findBook(String isbn) {
        return null;
    }

    @Override
    public void updateBook(String isbn, Book book) {

    }

    @Override
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
