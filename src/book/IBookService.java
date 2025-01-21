package book;

import java.util.Map;

public interface IBookService {

        /*
    Kitap ekleme, silme, güncelleme ve arama işlemlerini uygula.
ArrayList veya HashMap kullanarak kitap verilerini sakla.
     */
            void addBook(Book book);                     // Yeni kitap ekleme
            void removeBook(String isbn);                // ISBN ile kitap silme
            Book findBook(String isbn);                  // ISBN ile kitap arama
            void updateBook(String isbn, Book book);     // Kitap bilgilerini güncelleme
            Map<String, Book> getAllBooks();                    // Tüm kitapları listeleme
            boolean isBookAvailable(String isbn);        // Kitap müsaitlik kontrolü
            Map<String, Book> searchBooks(String keyword);      // Anahtar kelime ile kitap arama
}
