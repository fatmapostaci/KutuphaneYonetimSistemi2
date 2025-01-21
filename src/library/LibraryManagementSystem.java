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
import book.BookService;
import person.Member;
import person.PersonService;
import utilities.TryCatch;
import java.util.Map;
import java.util.Scanner;

public class LibraryManagementSystem {

    // 3- Tüm işlemlerin koordinasyonu
    // Kitap ve üye islemlerini yönetmek icin servis siniflari
    private static BookService bookService = new BookService();
    private static PersonService personService = new PersonService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //1- Konsol tabanlı kullanıcı arayüzü
        printWelcomeMessage();  // Hos geldiniz mesajı yazdiriliyor
        boolean exit = false;   // Cikis islemi için kontrol degiskeni

        //2- Menü sistemi
        while (!exit) {
            printMenu();
            int choice = TryCatch.intInput();   // Kullanicidan bir secim almak icin
            switch (choice) {
                case 1 -> addBook();
                case 2 -> listBooks();
                case 3 -> addMember();
                case 4 -> listMembers();
                case 5 -> {
                    System.out.println("Cikis yapiliyor. İyi günler!");
                    exit = true;    // Döngüyü sonlandirilir
                }
                default -> System.out.println("Gecersiz secim. Lütfen tekrar deneyin.");
            }
            System.out.println();
        }
        System.out.println("Program sonlandi.");  // Program sonlandiginda mesaj yazdırılır
    }

    private static void listMembers() {
    }


    private static void printWelcomeMessage() {
        //1- Konsol tabanlı kullanıcı arayüzü: Hos geldiniz mesaji yazdirilir
        System.out.println("=========================================");
        System.out.println("  📚 KÜTÜPHANE YÖNETİM SİSTEMİ 📚");
        System.out.println("=========================================");
    }

    //2- Menü sistemi
    private static void printMenu() {
        System.out.println("=========================================");
        System.out.println("  1. 📖 Kitap Ekle");
        System.out.println("  2. 📚 Kitap Listesi");
        System.out.println("  3. 🧑‍🤝‍🧑 Üye Ekle");
        System.out.println("  4. 👥 Üye Listesi");
        System.out.println("  5. ❌ Cikis");
        System.out.println("=========================================");
        System.out.print("Seçiminizi girin: ");
    }



    // 3- Tüm işlemlerin koordinasyonu ==> Yeni kitap ekle
    private static void addBook() {
        System.out.print("Kitap Adi: ");
        String name = TryCatch.stringInput();
        System.out.print("Yazar Adi: ");
        String author = TryCatch.stringInput();
        Book newBook = new Book(name,author,true,"");
        bookService.addBook(newBook); // Yeni kitap ekleniyor
        System.out.println("Kitap basariyla eklendi!");
    }

    // 3- Tüm işlemlerin koordinasyonu ==> Kitapları listele
    private static void listBooks() {
        System.out.println("Kayitli Kitaplar:");
        for (Map.Entry<String, Book> book : bookService.getAllBooks().entrySet()) { // Kitaplarin listesini getirir
            System.out.println(book.getValue());
        }
    }

    // 3- Tüm işlemlerin koordinasyonu ==> Yeni üye ekle
    private static void addMember() {
        personService.borrowBook("FP1001","ISBN10000");
        System.out.print("-New Member Name: ");
        String newMemberName = TryCatch.stringInput();
        System.out.print("-New Member Surname: ");
        String newMemberSurname = TryCatch.stringInput();
        System.out.print("-Contact Info: ");
        String newMemberContactInfo = TryCatch.stringInput();
        System.out.print("-Member email: ");
        String newMemberEmail = TryCatch.stringInput();

        Member newMember= new Member(newMemberName,newMemberSurname,newMemberContactInfo,newMemberEmail);
        personService.addMember(newMember);
    }

}




