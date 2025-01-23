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
import mertay.exceptionsclasses.Child_Book_Not_Found_Ex;
import person.Librarian;
import person.Member;
import person.PersonService;
import utilities.TryCatch;

import java.util.HashMap;
import java.util.Map;



public class LibraryManagementSystem {

    // Kitaplar ve üyeler icin veri yapilari (Map kullanarak ID ile erişim sagliyoruz)
   public static  Map<Integer, Book> books = new HashMap<>();
   private static  Map<Integer, Member> members = new HashMap<>();

    public PersonService personService = new PersonService();
    public BookService bookService = new BookService();

    // Hos geldiniz mesaji
    private void printWelcomeMessage() {
        System.out.println("=========================================");
        System.out.println("  📚 KÜTÜPHANE YÖNETİM SİSTEMİ 📚");
        System.out.println("=========================================");
    }

    // Kitaplar ve üyeler icin örnek veriler ekleniyor
    public void addSampleData() {

        // Örnek kitaplar ekleniyor





        // Örnek kullanicilar ekleniyor
        Member yusuf =  new Member("Yusuf", "Kaya", "54034343","kayayusuf@example.com");
        Member.setMemberList(yusuf);
        Member kubra =  new Member("Kübra", "Yılmaz", "54034343","yilmazkubra@example.com");
        Member.setMemberList(kubra);

        Librarian personel = new Librarian("Master","Master", "549373","master@master.com","Department1");
        Librarian.setLibrarianHashMap(personel);
    }

    // Menü seceneklerini yazdirma (Ana menüyü kullaniciya gösteriyoruz)
    void printMenu() {
        System.out.print("=========================================");
        System.out.println("\n📚 Ana Menü:");
        System.out.println("1. 🆕 Kitap Ekle");
        System.out.println("2. 🗑️ Kitap Sil");
        System.out.println("3. ✏️ Kitap Güncelle");
        System.out.println("4. 📜 Kitaplari Listele");
        System.out.println("5. 🧑‍💻 Üye Ekle");
        System.out.println("6. 🗑️ Üye Sil");
        System.out.println("7. 📥 Kitap Ödünc Al");
        System.out.println("8. 📤 Kitap İade Et");
        System.out.println("9. 🔎 Kitap Ara");
        System.out.println("10. üyeleri listele");
        System.out.println("0. 🚪 Cikis");
        System.out.print("Seciminizi yapin: ");
    }

    // Kullanicinin secimine göre islemi yapma
    public boolean handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> addBookInteractive(); // Kitap ekleme
            case 2 -> removeBook(); // Kitap silme
            case 3 -> updateBook(); // Kitap güncelleme
            case 4 -> listBooks(); // Kitaplari listeleme
            case 5 -> addMember(); // Üye ekleme
            case 6 -> removeMember(); // Üye silme
            case 7 -> borrowBook(); // Kitap ödünc alma
            case 8 -> returnBook(); // Kitap iade etme
            case 9 -> searchBook(); // Kitap arama
            case 10 -> getAllMembers();//üye listeleme
            case 0 -> {
                System.out.println("Cikis yapiliyor... 🚪");
                return true; // Cikis yap
            }
            default -> System.out.println("Gecersiz secenek, tekrar deneyin. ⚠️");
        }
        return false;
    }
/*
-----------start of PersonService Methods------------------------------------------------------
 */
    private void removeMember() {

        //todo -mehmet bey methodu çağırmayı yazdım ancak exception handling gerekiyorsa size bırakıyorum
        System.out.print("👤 Üye ID: ");
        String memberId = TryCatch.scan.next();
        personService.removeMember(memberId);


    }
    private void getAllMembers(){
        personService.getAllMembers();
    }
    private void addMember() {

        //todo -mehmet bey methodu çağırmayı yazdım, test ettim sisteme üye ekliyor, ancak exception handling gerekiyorsa size bırakıyorum
        System.out.print("👤 Üye Adı: ");
        String memberName = TryCatch.stringInput();

        System.out.print("👤 Üye Soyadı: ");
        String memberSurname = TryCatch.stringInput();

        System.out.print("👤 Üye TEL: ");
        String contactInfo = TryCatch.stringInput();

        System.out.print("👤 Üye Email: ");
        String mail = TryCatch.stringInput();


        Member newMember =  new Member(memberName,memberSurname,contactInfo,mail);
        personService.addMember(newMember);
    }
    // Kitap ödünc alma islemi
    private void borrowBook() {
        System.out.println("👤 Üye ID: ");
        String memberId = TryCatch.scan.next();
        System.out.println("📚 Kitap ID: ");
        String bookId = TryCatch.scan.next();
        try {
            Book book = books.get(bookId);
            if (book == null) {
                throw new LibraryException.BookNotFoundException("❗ Kitap bulunamadi!");
            }

            Member member = Member.getMemberList().get(memberId);
            if (member == null) {
                throw new LibraryException.MemberNotFoundException("❗ Üye bulunamadi!");
            }

            if (!book.isAvailable()) {
                throw new LibraryException.BookNotAvailableException("❗ Kitap ödünc alinamiyor, mevcut degil.");
            }

            if (member.getBorrowedBooks().size() >= 5) {
                throw new LibraryException.MaxBooksExceededException("❗ Üye, ödünc alabilecegi maksimum kitap sayisina ulasti.");
            }

            personService.borrowBook(memberId,book.getIsbn());
            System.out.println("✔️ Kitap basariyla ödünc alindi.");

        } catch (LibraryException.BookNotFoundException | LibraryException.MemberNotFoundException |
                 LibraryException.BookNotAvailableException | LibraryException.MaxBooksExceededException e) {
            System.out.println(e.getMessage()); // Hata mesajı
        }
    }

    // Kitap iade etme islemi
    private void returnBook() {
        System.out.println("👤 Üye ID: ");
        String memberId = TryCatch.scan.next();
        System.out.println("📚 Kitap ID: ");
        String bookId = TryCatch.scan.next();
        try {
            Book book = books.get(bookId);
            if (book == null) {
                throw new LibraryException.BookNotFoundException("❗ Kitap bulunamadi!");
            }


            //todo -> Mehmet Bey burada memberId ve isbn parametre olarak gönderilmeli, siz bookId almışsınız,
            //todo -> yukarıya memberId alma kısmını ekledim ancak exception method kısmını size bırakıyorum.

            personService.returnBook(memberId, book.getIsbn()); // Kitap iade islemi
            System.out.println("✔️ Kitap basariyla iade edildi.");
        } catch (LibraryException.BookNotFoundException e) {
            System.out.println(e.getMessage()); // Hata mesajı
        }
    }

    /*
------------start of book service methods------------------------------------------------
 */
    // Kitap ekleme islemi
    private void addBookInteractive() {
        System.out.print("\"\uD83D\uDCDA Kitap ID: \"");
        Integer id = Integer.valueOf(TryCatch.scan.nextLine());
        System.out.print("📖 Kitap Adi: ");
        String bookName = TryCatch.stringInput();
        System.out.println("");
        System.out.print("✍️ Yazar Adi: ");
        String author = TryCatch.stringInput();
        books.put(Integer.valueOf(id), new Book(bookName, author, true, ""));
        System.out.println("✔️ Kitap basariyla eklendi!");
    }

    // Kitap silme islemi
    private void removeBook() {
        System.out.println("❌ Silmek istediginiz kitabin adını: ");
        String bookName = TryCatch.stringInput();
        boolean bookFound = false;

        // Kitapları kontrol et
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            if (entry.getValue().getBookName().equalsIgnoreCase(bookName)) {
                books.remove(entry.getKey()); // Anahtar üzerinden sil
                System.out.println("✔️ Kitap '" + bookName + "' basariyla silindi.");
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            throw new Child_Book_Not_Found_Ex("No book found with name '" + bookName + "'.");
        }
    }

    // Kitap güncelleme islemi
    private void updateBook() {
        System.out.print("✏️ Güncellemek istediginiz kitabin adını: ");
        String bookName = TryCatch.stringInput(); // Kullanıcıdan kitap adı al

        boolean bookFound = false;

        // Map'teki tüm girişleri dolaş
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            if (entry.getValue().getBookName().equalsIgnoreCase(bookName)) {
                System.out.print("📖 Yeni Kitap Adı: ");
                String newName = TryCatch.stringInput();
                System.out.print("✍️ Yeni Yazar Adı: ");
                String newAuthor = TryCatch.stringInput();


                Book book = entry.getValue();
                book.setBookName(newName);
                book.setAuthor(newAuthor);
                System.out.println("✔️ Kitap '" + bookName + "' başarıyla güncellendi!");

                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            System.out.println("❗ Kitap '" + bookName + "' bulunamadı!");
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


    // Kitap arama islemi
    private void searchBook() {
        System.out.println("🔍 Arama yapmak icin bir seçenek girin:\n1. Kitap adi ile\n2. Kitap ID'si ile\nSeciminiz: ");
        int choice = TryCatch.intInput();
        switch (choice) {
            case 1: // Kitap adi ile arama
                System.out.println("📖 Kitap adi girin: ");
                String bookName = TryCatch.stringInput();

                boolean foundByName = false;
                for (Map.Entry<Integer, Book> book : books.entrySet()) {
                    if (book.getValue().getBookName().equalsIgnoreCase(bookName)) {
                        System.out.println(book); // Kitap bulunduysa yazdir
                        foundByName = true;
                    }
                }
                if (!foundByName) {
                    System.out.println("❗ Aradiginiz isimde kitap bulunamadi.");
                }
                break;
            case 2: // Kitap ID'si ile arama
                System.out.println("📚 Kitap ID'si girin: ");
                int bookId = TryCatch.intInput();
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
