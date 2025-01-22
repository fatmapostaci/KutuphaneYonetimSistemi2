package library;
/*
    Konsol tabanlı kullanıcı arayüzünü oluştur.
Menü sistemi ile kullanıcı işlemlerini yönlendir (örn. 1: Kitap Ekle, 2: Üye Ekle vb.).
Kullanıcı girdilerini kontrol et ve doğrula.

#### LibraryManagementSystem

1- Konsol tabanlı kullanıcı arayüzü
2- Menü sistemi
3- Tüm işlemlerin koordinasyonu
4- Exception handling
5- Kullanıcı girdisi doğrulama

- Konsol tabanlı kullanıcı arayüzü
- Menü sistemi
- Tüm işlemlerin koordinasyonu
- Exception handling
- Kullanıcı(Librarian) girdisi doğrulama

     */

import book.Book;
import person.Member;
import utilities.TryCatch;

import java.util.HashMap;
import java.util.Map;

public class LibraryManagementSystem {

    // Kitaplar ve üyeler icin veri yapilari (Map kullanarak ID ile erişim sagliyoruz)
    private static final Map<Integer, Book> books = new HashMap<>();
    private static final Map<Integer, Member> members = new HashMap<>();

    public static void main(String[] args) {

        // Ana uygulama baslatildiginda MainPage üzerinden calisacak
        System.out.println("Kütüphane Yönetim Sistemi Başlatılıyor... 📚");
    }

    // Hos geldiniz mesaji
    private static void printWelcomeMessage() {
        System.out.println("=========================================");
        System.out.println("  📚 KÜTÜPHANE YÖNETİM SİSTEMİ 📚");
        System.out.println("=========================================");
    }

    // Kitaplar ve üyeler icin örnek veriler ekleniyor
    public static void addSampleData() {

        // Örnek kitaplar ekleniyor
        books.put(1, new Book("Rich dad poor dad", "Robert Kiyosaki", true, ""));
        books.put(2, new Book("Smart investment", "Benjamin Graham", true, ""));

        // Örnek kullanicilar ekleniyor
        members.put(1, new Member(1, "Yusuf Kaya", "kayayusuf@example.com"));
        members.put(2, new Member(2, "Kübra Yılmaz", "yilmazkubra@example.com"));
    }

    // Menü seceneklerini yazdirma (Ana menüyü kullaniciya gösteriyoruz)
    private static void printMenu() {
        System.out.println("=========================================");
        System.out.println("\n📚 Ana Menü:");
        System.out.println("1. 🆕 Kitap Ekle");
        System.out.println("2. 🗑️ Kitap Sil");
        System.out.println("3. ✏️ Kitap Güncelle");
        System.out.println("4. 📜 Kitaplari Listele");
        System.out.println("5. 🧑‍💻 Üye Ekle");
        System.out.println("6. 🗑️ Üye Sil");
        System.out.println("7. 📝 Üye Güncelle");
        System.out.println("8. 📥 Kitap Ödünc Al");
        System.out.println("9. 📤 Kitap İade Et");
        System.out.println("10. 🔎 Kitap Ara");
        System.out.println("0. 🚪 Cikis");
        System.out.print("Seciminizi yapin: ");
    }

    // Kullanicinin secimine göre islemi yapma
    public static boolean handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> addBookInteractive(); // Kitap ekleme
            case 2 -> removeBook(); // Kitap silme
            case 3 -> updateBook(); // Kitap güncelleme
            case 4 -> listBooks(); // Kitaplari listeleme
            case 5 -> addMemberInteractive(); // Üye ekleme
            case 6 -> removeMember(); // Üye silme
            case 7 -> borrowBook(); // Kitap ödünc alma
            case 8 -> returnBook(); // Kitap iade etme
            case 9 -> searchBook(); // Kitap arama
            case 0 -> {

                System.out.println("Cikis yapiliyor... 🚪");
                return true; // Cikis yap
            }
            default -> System.out.println("Gecersiz secenek, tekrar deneyin. ⚠️");
        }
        return false;
    }

    // Kitap ekleme islemi
    private static void addBookInteractive() {
        int id = TryCatch.intInput("📚 Kitap ID: ");
        String name = TryCatch.stringInput("📖 Kitap Adi: ");
        String author = TryCatch.stringInput("✍️ Yazar Adi: ");
        books.put(id, new Book(name, author, true, ""));
        System.out.println("✔️ Kitap basariyla eklendi!");
    }

    // Kitap silme islemi
    private static void removeBook() {
        int id = TryCatch.intInput("❌ Silmek istediginiz kitabin ID'si: ");
        try {
            if (books.remove(id) == null) {
                throw new LibraryException.BookNotFoundException("❗ Kitap bulunamadi!");
            }
            System.out.println("✔️ Kitap basariyla silindi.");
        } catch (LibraryException.BookNotFoundException e) {
            System.out.println(e.getMessage()); // Hata mesajı
        }
    }

    // Kitap güncelleme islemi
    private static void updateBook() {
        int id = TryCatch.intInput("✏️ Güncellemek istediginiz kitabin ID'si: ");
        try {
            if (!books.containsKey(id)) {
                throw new LibraryException.BookNotFoundException("❗ Kitap bulunamadi!");
            }
            String name = TryCatch.stringInput("📖 Yeni Kitap Adi: ");
            String author = TryCatch.stringInput("✍️ Yeni Yazar Adi: ");
            books.put(id, new Book(name, author, true, ""));
            System.out.println("✔️ Kitap basariyla güncellendi!");
        } catch (LibraryException.BookNotFoundException e) {
            System.out.println(e.getMessage()); // Hata mesajı
        }
    }

    // Kitaplari listeleme islemi
    private static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("📚 Kütüphanede kitap yok.");
        } for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    // Kitap ödünc alma islemi
    private static void borrowBook() {
        int memberId = TryCatch.intInput("👤 Üye ID: ");
        int bookId = TryCatch.intInput("📚 Kitap ID: ");
        try {
            Book book = books.get(bookId);
            if (book == null) {
                throw new LibraryException.BookNotFoundException("❗ Kitap bulunamadi!");
            }

            Member member = members.get(memberId);
            if (member == null) {
                throw new LibraryException.MemberNotFoundException("❗ Üye bulunamadi!");
            }

            if (!book.isAvailable()) {
                throw new LibraryException.BookNotAvailableException("❗ Kitap ödünc alinamiyor, mevcut degil.");
            }

            if (member.getBorrowedBooks().size() >= 5) {
                throw new LibraryException.MaxBooksExceededException("❗ Üye, ödünc alabilecegi maksimum kitap sayisina ulasti.");
            }

            book.borrowBook(memberId);
            System.out.println("✔️ Kitap basariyla ödünc alindi.");

        } catch (LibraryException.BookNotFoundException | LibraryException.MemberNotFoundException |
                 LibraryException.BookNotAvailableException | LibraryException.MaxBooksExceededException e) {
            System.out.println(e.getMessage()); // Hata mesajı
        }
    }

    // Kitap iade etme islemi
    private static void returnBook() {
        int bookId = TryCatch.intInput("🔙 Kitap ID: ");
        try {
            Book book = books.get(bookId);
            if (book == null) {
                throw new LibraryException.BookNotFoundException("❗ Kitap bulunamadi!");
            }

            book.returnBook(); // Kitap iade islemi
            System.out.println("✔️ Kitap basariyla iade edildi.");
        } catch (LibraryException.BookNotFoundException e) {
            System.out.println(e.getMessage()); // Hata mesajı
        }
    }

    // Kitap arama islemi
    private static void searchBook() {
        int choice = TryCatch.intInput("🔍 Arama yapmak icin bir seçenek girin:\n1. Kitap adi ile\n2. Kitap ID'si ile\nSeciminiz: ");
        switch (choice) {
            case 1: // Kitap adi ile arama
                String bookName = TryCatch.stringInput("📖 Kitap adi girin: ");
                boolean foundByName = false;
                for (Book book : books.values()) {
                    if (book.getName().equalsIgnoreCase(bookName)) {
                        System.out.println(book); // Kitap bulunduysa yazdir
                        foundByName = true;
                    }
                }
                if (!foundByName) {
                    System.out.println("❗ Aradiginiz isimde kitap bulunamadi.");
                }
                break;
            case 2: // Kitap ID'si ile arama
                int bookId = TryCatch.intInput("📚 Kitap ID'si girin: ");
                Book bookById = books.get(bookId);
                if (bookById != null) {
                    System.out.println(bookById); // Kitap bulunduysa yazdir
                } else {
                    System.out.println("❗ Bu ID ile bir kitap bulunamadı.");
                }
                break;
            default:
                System.out.println("⚠️ Gecersiz secenek.");
        }
    }
}
