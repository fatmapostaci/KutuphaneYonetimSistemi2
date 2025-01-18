package book;

import java.util.HashMap;
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
    public void updateBook(String isbn, Book updatedBook) {

    }

    @Override
    public Book findBook(String isbn) {
        return null;
    }
}
