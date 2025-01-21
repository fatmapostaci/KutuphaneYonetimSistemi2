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
            int choice = getUserChoice();   // Kullanicidan bir secim almak icin
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


    //5- Kullanıcı girdisi doğrulama ve 4- Exception handling
    // Kullanicidan secim alma
    private static int getUserChoice() {
        return 0;
    }

    // 3- Tüm işlemlerin koordinasyonu ==> Yeni kitap ekle
    private static void addBook() {
        System.out.print("Kitap Adi: ");
        String name = scanner.nextLine();
        System.out.print("Yazar Adi: ");
        String author = scanner.nextLine();
        bookService.addBook(new Book(name, author)); // Yeni kitap ekleniyor
        System.out.println("Kitap basariyla eklendi!");
    }

    // 3- Tüm işlemlerin koordinasyonu ==> Kitapları listele
    private static void listBooks() {
        System.out.println("Kayitli Kitaplar:");
        for (Book book : bookService.getAllBooks()) { // Kitaplarin listesini getirir
            System.out.println(book);
        }
    }

    // 3- Tüm işlemlerin koordinasyonu ==> Yeni üye ekle
    private static void addMember() {
        System.out.print("Üye Adi: ");
        String name = scanner.nextLine();
        //personService.addMember(new Member(name)); // Yeni üye ekleniyor
        System.out.println("Üye basariyla eklendi!");
    }

   /* // 3- Tüm işlemlerin koordinasyonu ==> Üyeleri listele
    private static void listMembers() {
        System.out.println("Kayitli Üyeler:");
        for (Member:
            personService.getMembers()) {
            System.out.println(member);
        }
    }*/
}




